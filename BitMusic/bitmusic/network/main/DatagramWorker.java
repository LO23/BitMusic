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
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

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
        byte[] buf = new byte[1000];

        final DatagramPacket datagramPaquet = new DatagramPacket(buf,
                buf.length);

        while(true) {
            try {
                socket.receive(datagramPaquet);

                buf = datagramPaquet.getData();

                final ByteArrayInputStream bais = new ByteArrayInputStream(buf);

                final ObjectInputStream ois = new ObjectInputStream(bais);

                try {
                    final AbstractMessage message =
                            (AbstractMessage) ois.readObject();

                    message.treatment();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                 e.printStackTrace();
            }
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
