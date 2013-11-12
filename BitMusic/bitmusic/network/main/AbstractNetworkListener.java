/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;
import java.net;

/**
 *
 * @author Pak
 */
public class AbstractNetworkListener implements Runnable {

    /*
    * Abstract constructor.
    */
    public AbstractNetworkListener(int portToListen){PORTLISTENED=portToListen};

    /*
    * port listened to by the listener
    */
    public final int PORTLISTENED;


}
