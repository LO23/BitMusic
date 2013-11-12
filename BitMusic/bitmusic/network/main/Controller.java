/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.EnumTypeException;
import bitmusic.network.exception.NetworkDirectoryException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author florian, Pak
 */
public class Controller {
    /**
     * The broadcast address of the network.
     */
    private static String broadcastAddress;
    /**
     * The network address of the network.
     */
    private static String networkAddress;
    /**
     * Contains the singleton instance.
     */
    private static final Controller CONTROLLER = new Controller();
    /**
     * References the HMI API
     * (Due to the composition link on the class diagram).
     */
    private ApiHmiImpl apiHmi;
    /**
     * References the Music API
     * (Due to the composition link on the class diagram).
     */
    private ApiMusicImpl apiMusic;
    /**
     * References the Profile API
     * (Due to the composition link on the class diagram).
     */
    private ApiProfileImpl apiProfile;
    /**
     * References the Exception API
     * (Due to the composition link on the class diagram).
     */
    private ApiExceptionImpl apiException;
    /**
     * References the network listener
     * (Due to the composition link on the class diagram).
     */
    private NetworkListener NETLISTENER;


    /**
     * References the worker manage
     * (Due to the composition link on the class diagram).
     */
    private WorkManagement workManager;
    /**
     * Contains the correspondance between UserId and Ips.
     */
    private Map<String, String> directory;

    /*########################################################################*/
    /* CONSTRUCTORS */
    /*########################################################################*/
    /**
     * Construct a new controller and links all the singleton's instances.
     */
    private Controller() {
        //Initialisation of IP addresses
        broadcastAddress = "127.0.0.255";
        networkAddress = "127.0.0.1";

        //Create the directory
        directory = new HashMap<String, String>();

        //Contains all the API's instances
        apiException = bitmusic.network.main.ApiExceptionImpl.getInstance();
        apiHmi = bitmusic.network.main.ApiHmiImpl.getInstance();
        apiMusic = bitmusic.network.main.ApiMusicImpl.getInstance();
        apiProfile = bitmusic.network.main.ApiProfileImpl.getInstance();

        //Contains the NetworkListener instance
        NETLISTENER = bitmusic.network.main.NetworkListener.getInstance();

        //Contains the WorkManager instance
        //workManager = bitmusic.network.main.WorkManagement.getInstance();
        workManager = null;
    }

    /**
     * Implements the singleton pattern.
     * @return The controller
     */
    public static Controller getInstance() {
        return CONTROLLER;
    }

    /*########################################################################*/
    /* GETTERS */
    /*########################################################################*/
    /**
     * Get the broadcast address.
     * @return the broadcast address
     */
    public static String getBroadcastAddress() {
        return broadcastAddress;
    }
    /**
     * Get the network address.
     * @return the broadcast address
     */
    public static String getNetworkAddress() {
        return networkAddress;
    }
    /**
     * Get the ApiHmiImpl.
     * @return instance of ApiHmiImpl
     */
    public final ApiHmiImpl getApiHmi() {
        return apiHmi;
    }
    /**
     * Get the ApiMusicImpl.
     * @return instance of ApiMusicImpl
     */
    public final ApiMusicImpl getApiMusic() {
        return apiMusic;
    }
    /**
     * Get the ApiProfileImpl.
     * @return instance of ApiProfileImpl
     */
    public final ApiProfileImpl getApiProfile() {
        return apiProfile;
    }
    /**
     * Get the ApiExceptionImpl.
     * @return instance of ApiExceptionImpl
     */
    public final ApiExceptionImpl getApiException() {
        return apiException;
    }
    /**
     * Get the NetworkListener.
     * @return instance of NetworkListener
     */
    public final NetworkListener getNetworkListener() {
        return NETLISTENER;
    }
    /**
     * Get the WorkManager.
     * @return instance of WorkManager
     */
    public final WorkManagement getWorkManager() {
        return workManager;
    }
    /**
     * Get the Directory.
     * @return the user directory
     */
    public Map<String, String> getDirectory() {
        return directory;
    }

    /*########################################################################*/
    /* METHODS */
    /*########################################################################*/
    /**
     * Add a user to the directory.
     * @param userId Id of the user
     * @param ipAddress Ip address of the user
     * @throws Exception An exception is thrown if the userId already exist
     */
    public final void addUserToDirectory(final String userId,
               final String ipAddress) throws NetworkDirectoryException {
           if (directory.containsKey(userId)) {
               throw new NetworkDirectoryException(
                           "The user is already in the directory."
               );
           }
           directory.put(userId, ipAddress);
       }
    /**
     * .
     * @param userId Id of the user
     * @throws NetworkDirectoryException An exception is thrown if the userId doesn't exist
     */
    public final void removeUserFromDirectory(final String userId)
            throws NetworkDirectoryException {
        if (!directory.containsKey(userId)) {
            throw new NetworkDirectoryException(
                    "The user " + userId + " doesn't exist in the directory.");
        }
        directory.remove(userId);
    }

    /**
     * .
     * @param userId Id of the user
     * @return the Ip corresponding to the userId given
     * @throws NetworkDirectoryException An exception is thrown if the userId
     * doesn't exist
     */
    public final String getUserIpFromDirectory(final String userId)
            throws NetworkDirectoryException {
        if (!directory.containsKey(userId)) {
            throw new NetworkDirectoryException(
                    "The user " + userId + " doesn't exist in the directory.");
        }
        return directory.get(userId);
    }

    // ##################################
    // ## ##       TEST TOOLS       ## ##
    // ##################################

    /**
     * Prepare the app for test.
     */
    public final void prepareForTest() {
        this.getWorkManager().prepareForTest();
    }
    /**
     * Undo prepareForTest().
     */
    public void endTest() {
        this.getWorkManager().endTest();
    }
}
