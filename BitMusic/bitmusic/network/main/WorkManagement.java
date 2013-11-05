/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;
import java.util.List;
import bitmusic.network.message.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;


/**Creates and manages workers on-demand.
 * @author Pak
 */
public final class WorkManagement {
    /**
    * singleton implementation
    */
    private static final WorkManagement WORKMANAGER = new WorkManagement();
    /**
     * Constructor initialize workers list
     */
    private WorkManagement(){ workers = new ArrayList<Runnable>(); }
    /**
     * @return unique instance of WorkManagement
     */
    public static WorkManagement getInstance() {
        return WORKMANAGER;
    }
    /**
    * list of current workers
    */
    private List<Runnable> workers;

    /**
    * Threads pool size
    */
    private static final int NWORKERS = 10;

    /**
     * executor
     */
    private final ExecutorService executorService
            = Executors.newFixedThreadPool(NWORKERS, null);

    /**
    * Creates a worker (thread) and initiate it with a message.
    * The task will be scheduled and
    * executed if there is an available thread in the pool.
    * One message = one job =  one worker
    * At the end of run(), the worker destroys itself.
    * @param task message treated as a task
    */
    public void assignTaskToWorker(AbstractMessage task){

        final Runnable worker = new Worker(task);
        workers.add(worker);
        executorService.execute(worker);

    }



}
