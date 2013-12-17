/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Pak
 */
public final class TCPNetworkListener extends AbstractNetworkListener {
    /**
     * TCP Socket Server.
     */
    private transient ServerSocket tcpServer;

    /**
    * Singleton thread implementation.
    */
    private static TCPNetworkListener NETLISTENER = null;

    /**
     * TCP port.
     */
    private static final int TCP_PORT = 4444;


    /**
     * Default constructor.
     * @param portToListen The port number
     * @throws NetworkException Send a NetworkException
     */
    private TCPNetworkListener(final int portToListen) throws NetworkException {
        super(portToListen);
        try {
            tcpServer = new ServerSocket(portListened);
        } catch (IOException e) {
            throw new NetworkException(
                    "TCP server socket binding with LOCALPORT failed : "+e.getMessage());
        }
        thread.start();
    }

    /**
     * @return unique instance of TCPNetworkListener.
     */
    public static TCPNetworkListener getInstance() {
        try {
            NETLISTENER = new TCPNetworkListener(TCP_PORT);
        } catch (NetworkException e) {
            e.printStackTrace();
        }
        return NETLISTENER;
    }

    /**
     * TCP/UDP network listening behavior.
     */
    @Override
    public void run() {
        //Loop forever, processing connections
        while (true) {
            try {
                //######################################################
                //TCP CONNECTION ACCEPTED
                //######################################################
                    final Socket connectionSocket = tcpServer.accept();
                    Controller.getInstance().getThreadManager().
                            assignTaskToWorker(connectionSocket);
            } catch (IOException e) {
                //Impossible! it implements run and not run throws ...
                //throw new NetworkException("TCP "
                //        + "or UDP server registration failed");
                e.printStackTrace();
            }
        }
    }
}
