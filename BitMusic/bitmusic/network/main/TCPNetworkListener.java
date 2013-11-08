/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;


/**
 * TCP network listener.
 * ("Server"-side)
 * @author Pak
 */
public final class TCPNetworkListener implements Runnable {

    /**
    * Singleton thread implementation.
    */
    private static final TCPNetworkListener
            TCPNETLISTENER = new TCPNetworkListener();

    /**
     * default constructor.
     */
    private TCPNetworkListener() { };

    /**
     *
     * @return unique instance of NetworkListener
     */
    public static TCPNetworkListener getInstance() {
        return TCPNETLISTENER;
    }

    /**
    * Upon receiving a task (a message),
    * schedule this task to a worker thanks to the work manager.
    * @param task is a message
    */
    public void scheduleTask(final AbstractMessage task) {
        WorkManagement.getInstance().assignTaskToWorker(task);
    }

      /**
     * TCP network listening behavior.
     */
    @Override
    public void run() {

    }

}

