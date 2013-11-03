/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.main;
import java.util.List;
import network.message.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Creates and manages workers on-demand
 * @author Pak
 */
public class WorkManagement {
    
    /*
    * singleton implementation
    */
    private static final WorkManagement WORKMANAGER = new WorkManagement();
    private WorkManagement(){};
    public static WorkManagement getInstance(){
        return WORKMANAGER;
    }
    /*
    * list of current workers
    */
    private List<Runnable> workers;
      
    /*
    * Threads pool size
    */
    private static final int NWORKERS = 10;
    
    /*
    * the workers pool
    * execute() method will assign and execute if there's space available in the pool
    */
    private final ExecutorService executorService = Executors.newFixedThreadPool(NWORKERS, null);
    
    /*
    * Creates a worker (thread) and itiniate it with a message.
    * The task will be scheduled and executed if there is an available thread in the pool.
    * One message = one job =  one worker
    * At the end of run(), the worker destroys itself.
    */
    public void assignTaskToWorker(AbstractMessage task){
        
        Runnable worker = new Worker(task);
        workers.add(worker);
        executorService.execute(worker);
        
    } 
     
    
     
}
