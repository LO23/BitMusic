/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *@author Pak
 * Worker manages INCOMING message as tasks.
 */
public class Worker extends AbstractManageable {

    /**
     * The socket use to exchange.
     */
    private final transient Socket socket;

    /**
    *@param paramSocket The socket
    */
    Worker(final Socket paramSocket) {
        super();
        socket = paramSocket;
    }

    /**
     * Thread running behavior (task to complete).
     */
    @Override
    public final void run() {
        try {

            final ObjectInputStream ois = new ObjectInputStream(
                    socket.getInputStream());
            try {
                AbstractMessage message;
                message = (AbstractMessage) ois.readObject();

                message.treatment();
                //Notify the HMI in order to destroy
                if(message.getType() == EnumTypeMessage.LogOut) {
                            Controller.getInstance().getThreadManager()
                .getExecutorService().shutdown();
                }
            } catch (ClassNotFoundException e) {
                WindowComponent.getInstance().getApiHmi()
                        .errorNotification(e.getMessage());
            }
        } catch (IOException e) {
            WindowComponent.getInstance().getApiHmi()
                    .errorNotification(e.getMessage());
        }
    }

    /**
     *
     * @return socket
     */
    public final Socket getSocket() {
        return socket;
    }
}

