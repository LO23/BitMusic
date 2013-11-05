/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import java.util.List;
import bitmusic.network.api.ApiExceptionImpl;
import bitmusic.network.api.ApiHmiImpl;
import bitmusic.network.api.ApiMusicImpl;
import bitmusic.network.api.ApiProfileImpl;

/**
 *
 * @author florian
 */
public class Controller {
    /**
     * References the HMI API (Due to the composition link on the class diagram)
     */
    private ApiHmiImpl apiHmi;
    /**
     * References the Music API (Due to the composition link on the class diagram)
     */
    private ApiMusicImpl apiMusic;
    /**
     * References the Profile API (Due to the composition link on the class diagram)
     */
    private ApiProfileImpl apiProfile;
    /**
     * References the Exception API (Due to the composition link on the class diagram)
     */
    private ApiExceptionImpl apiException;
    /**
     * References the network listener (Due to the composition link on the class diagram)
     */
    private TCPNetworkListener TCPNETLISTENER;

    private UDPNetworkListener UDPNETLISTER;

    /**
     * List which contains the instantiated workers
     * (Due to the composition link on the class diagram)
     */
    private List<Worker> workers;


}
