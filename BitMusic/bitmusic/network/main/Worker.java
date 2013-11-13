/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.message.AbstractMessage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *@author Pak
 * Worker manages INCOMING message as tasks.
 */
public class Worker extends AbstractManageable {

    /**
     * message.
     */
    private Socket socket;

    /**
    *@param task task to do
    */
    Worker(final Socket paramSocket) {
          socket = paramSocket;
    }

    /**
     * Thread running behavior (task to complete).
     */
    @Override
    public void run() {
        try {

            final ObjectInputStream ois = new ObjectInputStream(
                    socket.getInputStream());
            try {
                AbstractMessage message = (AbstractMessage) ois.readObject();

                message.treatment();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @return message
     */
    public final Socket getSocket() {
        return socket;
    }
}

