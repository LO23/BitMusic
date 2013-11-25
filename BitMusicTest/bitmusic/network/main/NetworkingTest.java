package bitmusic.network.main;


import bitmusic.network.message.AbstractMessage;
import bitmusic.network.test.SocketListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincetn
 */
public class NetworkingTest implements SocketListener {


    /* To manage socket received by ThreadManager */
    private Socket socketReceived;
    @Override
    public void setSocket(Socket socket) {
        this.socketReceived = socket;
        synchronized(this) {
            this.notify();
        }
    }

    protected Socket getSocketReceived() {
        return this.socketReceived;
    }

    protected void waitForSocket() {
        synchronized (this) {
            while(this.socketReceived == null) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    fail("InterruptedException Raised : "+ex.getMessage());
                }
            }
        }
    }

    protected void resetSocket() {
        this.socketReceived = null;
    }

    protected AbstractMessage readMessageFromSocket() {
        final ObjectInputStream ois;
        AbstractMessage message = null;
        try {
            ois = new ObjectInputStream(this.getSocketReceived().getInputStream());
            message = (AbstractMessage) ois.readObject();

            //message.treatment();
        } catch (IOException | ClassNotFoundException e) {
            fail(e.getMessage());
        }
        return message;
    }

}
