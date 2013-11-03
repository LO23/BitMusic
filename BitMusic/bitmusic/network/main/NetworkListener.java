/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.main;

import network.message.*;

/**
 *
 * @author Pak
 */
public class NetworkListener {
    /*
    * Singleton implementation
    */
    private static final NetworkListener NETLISTENER = new NetworkListener();
    private NetworkListener(){};
    public static NetworkListener getInstance(){
        return NETLISTENER;
    }
    
    /*
    *Upon receiving a task (a message), schedule this task to a worker thanks to the work manager
    *@param a message from a subclass of AbstractMessage
    */
    public void scheduleTask(AbstractMessage task){
        
    WorkManagement.getInstance().assignTaskToWorker(task);
        
    }
}
