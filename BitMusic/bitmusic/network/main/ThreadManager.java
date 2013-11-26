/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.test.SocketListener;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**Creates and manages workers on-demand.
 * @author Pak
 */
public final class ThreadManager {
    /**
    * singleton implementation.
    */
    private static final ThreadManager THREADMANAGER = new ThreadManager();

    /**
     * executor.
     */
    private final transient ExecutorService executorService;

    /**
     * @return executorService
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }


    /**
    * Threads pool size.
    */
    private static final int NTHREADS = 10;

    /**
     * Constructor initialize workers list.
     */
    private ThreadManager() {
        executorService = Executors.newFixedThreadPool(NTHREADS);
    }

    /**
     * @return unique instance of WorkManagement.
     */
    protected static ThreadManager getInstance() {
        return THREADMANAGER;
    }


    /**
    * Creates a worker (thread) and initiate it with a socket.
    * The task will be scheduled and
    * executed if there is an available thread in the pool.
    * One message = one job = one worker
    * At the end of run(), the worker destroys itself.
    * @param socket socket treated as a task
    */
    public void assignTaskToWorker(final Socket socket) {
        if (weAreTesting()) {
            this.jUnitTest.setSocket(socket);
        } else {
            final AbstractManageable worker = new Worker(socket);
            executorService.execute(worker);
        }
    }
    /**
     * .
    */
    public void assignTaskToDatagramWorker(final DatagramSocket socket)
            throws NetworkException {
                if (weAreTesting()) {
                    throw new NetworkException("Fuck YEAH !");
        } else {
            final AbstractManageable datagramWorker =
                    new DatagramWorker(socket);
            executorService.execute(datagramWorker);
        }
    }
    /**
     *
     * Creates an hermes messenger (thread) and initiate it with a message.
     * The task will be scheduled and
     * executed if there is an available thread in the pool.
     * One message = one job = one hermes messenger
     * At the end of run(), the hermes destroys itself.
     * @param task Message to deal with
     */
    public void assignTaskToHermes(final AbstractMessage task) {
        if (weAreTesting()) {
            task.setIpDest(LOOP_ADDRESS);
        }
        final AbstractManageable hermes = new Hermes(task);
        executorService.execute(hermes);
    }

    // ##################################
    // ## ##       TEST TOOLS       ## ##
    // ##################################

    /**
     * must be true when testing the app.
     */
    private transient boolean testContext = false;
    /**
     * Common loop ip adress for network.
     */
    private static final String LOOP_ADDRESS = "127.0.0.1";

    /**
     * (QUALITY) Used for JUnit tests (JUnit suscribed).
     */
    private transient SocketListener jUnitTest;

    /**
     * permet à un test JUnit de demander la reception des sockets entrantes.
     * @param jUnitTestArg le test JUnit héritant de NetworkingTest
     */
    public void suscribe(final SocketListener jUnitTestArg) {
        this.jUnitTest = jUnitTestArg;
    }

    public void onSocketReceived() {
        this.jUnitTest.notify();
    }

    public Socket getLastSocketReceived() {
        return null;//this.lastSocketReceived;
    }

    /**
     * (QUALITY) Prepare the workManager for some tests.
     */
    public void prepareForTest() {
        this.testContext = true;
    }
    /**
     * (QUALITY) Undo prepareForTest().
     */
    public void endTest() {
        this.testContext = false;
    }
    /**
     * Are we testing the app ?.
     * @return true if we are testing the app
     */
    private boolean weAreTesting() {
        return this.testContext;
    }
}
