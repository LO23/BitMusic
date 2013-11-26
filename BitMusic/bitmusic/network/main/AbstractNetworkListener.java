/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Abstract Network Listener
 * @author Pak, Hugo
 */
public abstract class AbstractNetworkListener implements Runnable {
        /**
    * port listened to by the listener.
    */
    private final int PORT_LISTENED;

    /**
     * Socket address.
     */
    private final SocketAddress LOCALPORT;

    public AbstractNetworkListener(final int portToListen)
            throws NetworkException{
        PORT_LISTENED = portToListen;
        LOCALPORT = new InetSocketAddress(PORT_LISTENED);
    }
}
