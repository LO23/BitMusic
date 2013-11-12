/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;

import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.DatagramChannel;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.util.Set;
import java.util.Iterator;
import java.nio.channels.Channel;


/**
 * TCP network listener.
 * "Server" process waiting for TCP clients connections
 * @author Pak
 */
public final class NetworkListener implements Runnable {

    /**
    * port listened to by the listener
    */
    private final int PORTLISTENED;

    /**
     * Socket address
     */
    private final SocketAddress LOCALPORT;

    /**
     * TCP channel
     */
    private final ServerSocketChannel TCPSERVER;

    /**
     * UDP channel
     */
    private final DatagramChannel UDPSERVER;

    /**
    * Singleton thread implementation.
    */
    private static final NetworkListener
            NETLISTENER = new NetworkListener(4444);

    /**
     * default constructor.
     */
    private NetworkListener(int portToListen)

    {
        PORTLISTENED= portToListen;
        LOCALPORT = new InetSocketAddress(PORTLISTENED);

        try{
        TCPSERVER = ServerSocketChannel.open();
        TCPSERVER.socket().bind(LOCALPORT);
        UDPSERVER = DatagramChannel.open();
        UDPSERVER.socket().bind(LOCALPORT);
        /**
         * configure blocking mode to false
         * since our Selector will do blocking for us
         */
        TCPSERVER.configureBlocking(false);
        UDPSERVER.configureBlocking(false);

        } catch (IOException e ){
            e.printStackTrace();
        }

    }

    /**
     *
     * @return unique instance of NetworkListener
     */
    public static NetworkListener getInstance() {
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

      /**
     * TCP network listening behavior.
     */
    @Override
    public void run() {

        try{

        Selector selector = Selector.open();
        TCPSERVER.register(selector, SelectionKey.OP_ACCEPT);
        UDPSERVER.register(selector, SelectionKey.OP_READ);

        //Loop forever, processing connections

          while(true){
            try {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();

                // Iterate through the Set of keys.
                for (Iterator<SelectionKey> i = keys.iterator(); i.hasNext();) {
                    SelectionKey key = i.next();
                    i.remove();

                    Channel c = key.channel();

                    if (key.isAcceptable() && c == TCPSERVER) {
                        /**
                         * TODO: create a thread processing this TCP connection
                         */
                    } else if (key.isReadable() && c == UDPSERVER) {
                        /**
                         * TODO: create a thread processing this UDP connection
                         */
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    } catch (Exception e){
        e.printStackTrace();
    }

    }

}

