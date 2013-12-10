/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.hmi.mainwindow.WindowComponent;
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
        if (netlistener == null) {
            System.out.println("Init UDP LISTENER");
            netlistener = new UDPNetworkListener(4445);
        }
        return netlistener;
    }

    public UDPNetworkListener(final int portToListen) {
        super(portToListen);
        try{
            UDPSERVER = new DatagramSocket(portListened);
        } catch (SocketException e) {
            WindowComponent.getInstance().getApiHmi()
                    .errorNotification("Network", e.getMessage());
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
