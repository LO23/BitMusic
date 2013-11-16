/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkDirectoryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author florian, Pak
 */
public final class Controller {
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
    private ThreadManager threadManager;
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
        threadManager = bitmusic.network.main.ThreadManager.getInstance();

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
    public ApiHmiImpl getApiHmi() {
        return apiHmi;
    }
    /**
     * Get the ApiMusicImpl.
     * @return instance of ApiMusicImpl
     */
    public ApiMusicImpl getApiMusic() {
        return apiMusic;
    }
    /**
     * Get the ApiProfileImpl.
     * @return instance of ApiProfileImpl
     */
    public ApiProfileImpl getApiProfile() {
        return apiProfile;
    }
    /**
     * Get the ApiExceptionImpl.
     * @return instance of ApiExceptionImpl
     */
    public ApiExceptionImpl getApiException() {
        return apiException;
    }
    /**
     * Get the NetworkListener.
     * @return instance of NetworkListener
     */
    public NetworkListener getNetworkListener() {
        return NETLISTENER;
    }
    /**
     * Get the WorkManager.
     * @return instance of WorkManager
     */
    public ThreadManager getThreadManager() {
        return threadManager;
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
     * @throws NetworkDirectoryException An exception is thrown if the userId
     * already exist
     */
    public void addUserToDirectory(final String userId,
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
     * @throws NetworkDirectoryException An exception is thrown if the userId
     * doesn't exist
     */
    public void removeUserFromDirectory(final String userId)
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
    public String getUserIpFromDirectory(final String userId)
            throws NetworkDirectoryException {
        if (!directory.containsKey(userId)) {
            throw new NetworkDirectoryException(
                    "The user " + userId + " doesn't exist in the directory.");
        }
        return directory.get(userId);
    }

    /**
     * @return List containing all IP addresses contained in the directory
     */
    public List<String> getIpListFromDirectory() {
        ArrayList<String> ipList;
        ipList = new ArrayList();

        for (Entry<String, String> entry : directory.entrySet()) {
            ipList.add(entry.getValue());
        }

        return ipList;
    }


    /**
     * @return List containing all IP addresses contained in the directory
     */
    public List<String> getUserListFromDirectory() {
        ArrayList<String> userList;
        userList = new ArrayList();

        for (Entry<String, String> entry : directory.entrySet()) {
            userList.add(entry.getKey());
        }

        return userList;
    }

    // ##################################
    // ## ##       TEST TOOLS       ## ##
    // ##################################

    /**
     * Prepare the app for test.
     */
    public void prepareForTest() {
        this.getThreadManager().prepareForTest();
    }
    /**
     * Undo prepareForTest().
     */
    public void endTest() {
        this.getThreadManager().endTest();
    }
}
