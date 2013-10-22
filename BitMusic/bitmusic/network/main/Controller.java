/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.main;

import java.util.List;
import network.api.ApiExceptionImpl;
import network.api.ApiHmiImpl;
import network.api.ApiMusicImpl;
import network.api.ApiProfileImpl;

/**
 *
 * @author florian
 */
public class Controller {
    /**
     * References the HMI API (Due to the composition link on the class diagram)
     */
    private network.api.ApiHmiImpl apiHmi;
    /**
     * References the Music API (Due to the composition link on the class diagram)
     */
    private network.api.ApiMusicImpl apiMusic;
    /**
     * References the Profile API (Due to the composition link on the class diagram)
     */
    private network.api.ApiProfileImpl apiProfile;
    /**
     * References the Exception API (Due to the composition link on the class diagram)
     */
    private network.api.ApiExceptionImpl apiException;
    /**
     * References the network listener (Due to the composition link on the class diagram)
     */
    private network.main.NetworkListener networkListener;
    /**
     * List which contains the instanciated workers
     * (Due to the composition link on the class diagram)
     */
    private List<network.main.Worker> workers;
    
    
}
