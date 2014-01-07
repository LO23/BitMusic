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
public final class Hermes extends AbstractManageable {
    /**
     * The message that hermes has to send.
     */
    private final transient AbstractMessage message;
    private final transient int UDP_SENDING_PORT=4445;

    /**
     * Create a new instance of Hermes messenger.
     * @param paramMessage The message that has to be sent
     */
    public Hermes(final AbstractMessage paramMessage) {
        super();
        message = paramMessage;
    }

    /**
     * Getter for the message attribute.
     * @return The message saved in Hermes
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

    /**
     * Method used to send a message using TCP protocol on the network.
     */
    private void sendTcpMessage() {
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

    /**
     * Method used to send a message using UDP protocol on the network.
     */
    private void sendUdpMessage() {
        try {
            final DatagramSocket socket = new DatagramSocket(UDP_SENDING_PORT , InetAddress.getLocalHost());
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();

            final ObjectOutputStream oos = new ObjectOutputStream(baos);

            oos.writeObject(this.message);

            final byte[] data = baos.toByteArray();

            final DatagramPacket packet = new DatagramPacket(data, data.length,
                    InetAddress.getByName(Controller.getBroadcastAddress()),
                    UDP_SENDING_PORT);
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

