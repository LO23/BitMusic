/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Threads that only SEND messages are called Hermes.
 * @author Pak
 */
public class Hermes extends AbstractManageable {
    /**
     * The message that hermes has to send.
     */
    private final AbstractMessage message;

    /**
     * Create a new instance of Hermes messenger.
     * @param paramMessage The message that has to be sent
     */
    public Hermes(AbstractMessage paramMessage) {
        message = paramMessage;
    }

    /**
     * .
     * @return
     */
    public AbstractMessage getMessage() {
        return message;
    }

    /**
     * Thread running behavior (message to send).
     */
    @Override
    public void run() {
        //Send an UDP message
        if (this.message.getType() == EnumTypeMessage.NotifyNewConnection) {
            sendUdpMessage();
        //Send a TCP message
        } else {
            sendTcpMessage();
        }
    }

    private final void sendTcpMessage() {
        try {
            final Socket socket = new Socket(message.getIpDest(),
            Controller.getInstance().
            getTCPNetworkListener().getPortListened());

            final ObjectOutputStream oos = new ObjectOutputStream(
            socket.getOutputStream());

            oos.writeObject(message);

            oos.flush();
            
            socket.close();
        } catch (IOException e) {
            WindowComponent.getInstance().getApiHmi()
                    .errorNotification("Network", e.getMessage());
        }
    }

    private final void sendUdpMessage() {
        try {
            final DatagramSocket socket = new DatagramSocket(
                    Controller.getInstance().getUDPNetworkListener().
                            getPortListened(), InetAddress.getLocalHost());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(baos);

            oos.writeObject(this.message);

            byte[] data = baos.toByteArray();

            DatagramPacket packet = new DatagramPacket(data, data.length,
                    InetAddress.getByName(Controller.getBroadcastAddress()),
                    Controller.getInstance().getUDPNetworkListener().
                            getPortListened());

            socket.send(packet);

            oos.writeObject(message);

            oos.flush();

            socket.close();
        } catch (IOException e) {
            WindowComponent.getInstance().getApiHmi()
                    .errorNotification("Network", e.getMessage());
        }
    }
}

