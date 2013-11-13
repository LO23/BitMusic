/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        try {
            final Socket socket = new Socket(message.getIpDest(),
                    Controller.getInstance().
                        getNetworkListener().getPORTLISTENED());

            final ObjectOutputStream oos = new ObjectOutputStream(
                    socket.getOutputStream());

            oos.writeObject(message);

            oos.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
