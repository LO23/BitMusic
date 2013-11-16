/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;


import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.DatagramChannel;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.util.Set;
import java.util.Iterator;


/**
 * TCP/UDP network listener.
 * "Server" process waiting for TCP clients connections
 * @author Pak, Florian
 */
public final class NetworkListener implements Runnable {
    /**
    * port listened to by the listener.
    */
    private final int PORT_LISTENED;

    /**
     * Socket address.
     */
    private final SocketAddress LOCALPORT;

    /**
     * TCP channel.
     */
    private ServerSocketChannel TCPSERVER;

    /**
     * UDP channel.
     */
    private DatagramChannel UDPSERVER;

    /**
    * Singleton thread implementation.
    */
    private static final NetworkListener
            NETLISTENER = new NetworkListener(4444);

    /**
     * Default constructor.
     * @param portToListen The port number
     */
    private NetworkListener(final int portToListen) {
        PORT_LISTENED = portToListen;
        LOCALPORT = new InetSocketAddress(PORT_LISTENED);
        TCPSERVER = null;
        UDPSERVER = null;
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @return return the listened port number.
     */
    public int getPORTLISTENED() {
        return PORT_LISTENED;
    }

    /**
     * @return unique instance of NetworkListener.
     */
    public static NetworkListener getInstance() {
        return NETLISTENER;
    }

    /**
     * TCP/UDP network listening behavior.
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
                    final Set<SelectionKey> keys = selector.selectedKeys();

                    // Iterate through the Set of keys.
                    for (final Iterator<SelectionKey> i = keys.iterator();
                            i.hasNext();) {
                        final SelectionKey key = i.next();
                        i.remove();
                        //######################################################
                        //TCP CONNECTION ACCEPTED
                        //######################################################
                        if (key.isAcceptable()) {
                            final ServerSocket servSocket = TCPSERVER.socket();
                            final Socket connectionSocket = servSocket.accept();

                            Controller.getInstance().getThreadManager().
                                    assignTaskToWorker(connectionSocket);
                        //######################################################
                        //UDP CONNECTION ACCEPTED
                        //######################################################
                        } else if (key.isReadable()) {
                            final DatagramSocket connectionSocket = UDPSERVER.socket();
                            //TO DO
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
