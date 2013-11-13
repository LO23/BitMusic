/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;
import bitmusic.network.message.AbstractMessage;
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
    private final ExecutorService executorService;


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
        final AbstractManageable worker = new Worker(socket);
        executorService.execute(worker);
    }
    /**
     *
     * Creates an hermes messenger (thread) and initiate it with a message.
     * The task will be scheduled and
     * executed if there is an available thread in the pool.
     * One message = one job = one hermes messenger
     * At the end of run(), the hermes destroys itself.
     * @param task
     */
    public void assignTaskToHermes(final AbstractMessage task) {
        if (weAreTesting()) {
            task.setIpDest(LOOP_ADRESS);
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
    private static final String LOOP_ADRESS = "127.0.0.1";
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
