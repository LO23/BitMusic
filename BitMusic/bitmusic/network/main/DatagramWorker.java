/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.xml.ws.Service;

/**
 *
 * @author florian
 */
public class DatagramWorker extends AbstractManageable {

    /**
     * The socket use to exchange.
     */
    private final transient DatagramSocket socket;

    /**
    *@param paramSocket The socket
    */
    DatagramWorker(final DatagramSocket paramSocket) {
        super();
        socket = paramSocket;
    }

    /**
     * Thread running behavior (task to complete).
     */
    @Override
    public final void run() {
        try {
            byte[] incomingData = new byte[1024];

            DatagramPacket incomingPacket = new DatagramPacket(incomingData,
                     incomingData.length);

            socket.receive(incomingPacket);
            byte[] data = incomingPacket.getData();
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            try {
                AbstractMessage message = (AbstractMessage) ois.readObject();

                message.treatment();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @return socket
     */
    public final DatagramSocket getSocket() {
        return this.socket;
    }
}
