/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;
import bitmusic.network.message.AbstractMessage;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;


/**Creates and manages workers on-demand.
 * @author Pak
 */
public final class WorkManagement {
    /**
    * singleton implementation.
    */
    private static final WorkManagement WORKMANAGER = new WorkManagement();
    /**
     * executor.
     */
    private final transient ExecutorService executorService
            = Executors.newFixedThreadPool(NWORKERS, null);

    /**
    * list of current workers.
    */
    private final transient List<Runnable> workers = new ArrayList();
    /**
    * Threads pool size.
    */
    private static final int NWORKERS = 10;

    /**
     * Constructor initialize workers list.
     */
    private WorkManagement() { }
    /**
     * @return unique instance of WorkManagement.
     */
    protected static WorkManagement getInstance() {
        return WORKMANAGER;
    }


    /**
    * Creates a worker (thread) and initiate it with a message.
    * The task will be scheduled and
    * executed if there is an available thread in the pool.
    * One message = one job =  one worker
    * At the end of run(), the worker destroys itself.
    * @param task message treated as a task
    */
    public void assignTaskToWorker(final AbstractMessage task) {
        if (weAreTesting()) {
            task.setIpDest(LOOP_ADRESS);
        }
        final Runnable worker = new Worker(task);
        workers.add(worker);
        executorService.execute(worker);
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
