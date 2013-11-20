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
    private final transient DatagramChannel channel;

    /**
    *@param paramSocket The socket
    */
    DatagramWorker(final DatagramChannel paramChannel) {
        super();
        channel = paramChannel;
    }

    /**
     * Thread running behavior (task to complete).
     */
    @Override
    public final void run() {
        try {
            ByteBuffer incomingData = ByteBuffer.allocate(1024);

            channel.receive(incomingData);

            final byte[] data = incomingData.array();
            final ByteArrayInputStream bais = new ByteArrayInputStream(data);
            final ObjectInputStream ois = new ObjectInputStream(bais);
            try {
                final AbstractMessage message =
                        (AbstractMessage) ois.readObject();

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
    public final DatagramChannel getChannel() {
        return this.channel;
    }
}
