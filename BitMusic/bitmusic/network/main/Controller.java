/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;


import bitmusic.network.exception.NetworkDirectoryException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author florian, Pak, vincent
 */
public final class Controller {
    /**
     * The broadcast address of the network.
     */
    private transient String broadcastAddress = "";
    /**
     * The network address of the network.
     */
    private transient String networkAddress = "";
    /**
     * Contains the singleton instance.
     */
    private static final Controller CONTROLLER = new Controller();
    /**
     * References the HMI API
     * (Due to the composition link on the class diagram).
     */
    private final transient ApiHmiImpl apiHmi;
    /**
     * References the Music API
     * (Due to the composition link on the class diagram).
     */
    private final transient ApiMusicImpl apiMusic;
    /**
     * References the Profile API
     * (Due to the composition link on the class diagram).
     */
    private final transient ApiProfileImpl apiProfile;
    /**
     * References the Exception API
     * (Due to the composition link on the class diagram).
     */
    private final transient ApiExceptionImpl apiException;
    /**
     * References the network listener
     * (Due to the composition link on the class diagram).
     */
    private final transient NetworkListener netListener;


    /**
     * References the worker manager
     * (Due to the composition link on the class diagram).
     */
    private final transient ThreadManager threadManager;
    /**
     * Contains the correspondance between UserId and Ips.
     */
    private final transient Map<String, String> directory;

    /*########################################################################*/
    /* CONSTRUCTORS */
    /*########################################################################*/
    /**
     * Construct a new controller and links all the singleton's instances.
     */
    private Controller() {
        this.networkAddress = "";
        this.broadcastAddress = "";
        try {
            this.networkAddress = InetAddress.getLocalHost().getHostAddress();
            this.broadcastAddress = findBroadCastAddress();
        }
        catch (UnknownHostException ex) {
        }




        //Create the directory
        directory = new HashMap();

        //Contains all the API's instances
        apiException = bitmusic.network.main.ApiExceptionImpl.getInstance();
        apiHmi = bitmusic.network.main.ApiHmiImpl.getInstance();
        apiMusic = bitmusic.network.main.ApiMusicImpl.getInstance();
        apiProfile = bitmusic.network.main.ApiProfileImpl.getInstance();

        //Contains the NetworkListener instance
        netListener = bitmusic.network.main.NetworkListener.getInstance();

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
        return CONTROLLER.broadcastAddress;
    }
    /**
     * Get the network address.
     * @return the network address
     */
    public static String getNetworkAddress() {
        return CONTROLLER.networkAddress;
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
        return netListener;
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


    private String findBroadCastAddress(){
        String brcstAddr;
        try {
            int index = 0;
            if(isMac()) {
                index = 1;
            }
            brcstAddr = NetworkInterface
                        .getByInetAddress(InetAddress.getLocalHost())
                          .getInterfaceAddresses()
                            .get(index).getBroadcast().getHostAddress();
        } catch (SocketException | UnknownHostException ex) {
            brcstAddr = "";
        }
        return brcstAddr;
    }

    private final static String OS = System.getProperty("os.name").toLowerCase();

    private boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    /*
    ###   MAY BE USEFUL   ###
    #########################

    private boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
    private boolean isUnix() {
        return (OS.indexOf("nix") >= 0
                || OS.indexOf("nux") >= 0
                || OS.indexOf("aix") >= 0);
    }
    */



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
