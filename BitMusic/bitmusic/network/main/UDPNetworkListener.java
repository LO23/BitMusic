/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkException;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Pak
 */
public class UDPNetworkListener extends AbstractNetworkListener {
        /**
     * UDP channel.
     */
    private DatagramSocket UDPSERVER;

        /**
     * @return unique instance of NetworkListener.
     */
    public static AbstractNetworkListener getInstance() {
        NETLISTENER = new UDPNetworkListener(4445);
        return NETLISTENER;
    }

    public UDPNetworkListener(final int portToListen) {
        super(portToListen);
        try{
            UDPSERVER = new DatagramSocket(PORT_LISTENED);
        } catch (SocketException e) {

        }
        thread.start();
    }

    @Override
    public void run() {
        try {
            Controller.getInstance().getThreadManager().
                                        assignTaskToDatagramWorker(UDPSERVER);
        } catch(NetworkException e) {
            e.printStackTrace();
        }
    }
}
