/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;


/**
 *
 * @author Pak
 */
public final class NetworkListener {
    /**
    * Singleton implementation.
    */
    private static final NetworkListener NETLISTENER = new NetworkListener();

    /**
     * default constructor.
     */
    private NetworkListener() { };

    /**
     *
     * @return unique instance of NetworkListener
     */
    protected static NetworkListener getInstance() {
        return NETLISTENER;
    }

    /**
    * Upon receiving a task (a message),
    * schedule this task to a worker thanks to the work manager.
    * @param task is a message
    */
    public void scheduleTask(final AbstractMessage task) {
        WorkManagement.getInstance().assignTaskToWorker(task);
    }
}

