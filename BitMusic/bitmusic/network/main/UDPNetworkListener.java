/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

/**
 * UDP Network listener.
 * "Server" process waiting for UDP clients connections
 * @author Pak
 */
public final class UDPNetworkListener implements Runnable {

    /**
    * Singleton thread implementation.
    */
    private static final UDPNetworkListener
            UDPNETLISTENER = new UDPNetworkListener();

    /**
     * default constructor.
     */
    private UDPNetworkListener() { super(); };

    /**
     *
     * @return unique instance of NetworkListener
     */
    public static UDPNetworkListener getInstance() {
        return UDPNETLISTENER;
    }

    /**
     * UDP network listening behavior.
     */
    @Override
    public void run() {

    }


}
