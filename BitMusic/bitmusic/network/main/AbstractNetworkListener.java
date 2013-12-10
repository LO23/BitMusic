/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Abstract Network Listener.
 * @author Pak, Hugo
 */
public abstract class AbstractNetworkListener implements Runnable {
        /**
    * port listened to by the listener.
    */
    protected final int portListened;

    /**
     * Socket address.
     */
    protected final SocketAddress localport;

    /**
     * Network listener.
     */
    protected static AbstractNetworkListener netlistener = null;

    /**
     * The thread in wich we run the listener.
     */
    protected final Thread thread = new Thread(this);

    /**
     * Constructor.
     * @param portToListen Port number
     */
    public AbstractNetworkListener(final int portToListen) {
        portListened = portToListen;
        localport = new InetSocketAddress(portListened);
    }

    @Override
    public abstract void run();

    /**
     * Getter for the portListened attribute.
     * @return The port number
     */
    public final int getPortListened() {
        return portListened;
    }

}
