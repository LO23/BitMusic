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
import java.nio.channels.SocketChannel;


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
    private ServerSocketChannel TCPSERVER;

    /**
     * UDP channel
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
        PORTLISTENED = portToListen;
        LOCALPORT = new InetSocketAddress(PORTLISTENED);
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

        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public int getPORTLISTENED() {
        return PORTLISTENED;
    }

    /**
     *
     * @return unique instance of NetworkListener
     */
    public static NetworkListener getInstance() {
        return NETLISTENER;
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

                      if (key.isAcceptable() || key.isReadable()) {
                          SocketChannel sc = (SocketChannel) key.channel();
                          Controller.getInstance().getThreadManager().assignTaskToWorker(sc.socket());
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

