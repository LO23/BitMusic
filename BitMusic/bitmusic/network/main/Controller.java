/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.EnumTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author florian
 */
public class Controller {
    /**
     * References the HMI API
     * (Due to the composition link on the class diagram).
     */
    private final ApiHmiImpl apiHmi;
    /**
     * References the Music API
     * (Due to the composition link on the class diagram).
     */
    private final ApiMusicImpl apiMusic;
    /**
     * References the Profile API
     * (Due to the composition link on the class diagram).
     */
    private final ApiProfileImpl apiProfile;
    /**
     * References the Exception API
     * (Due to the composition link on the class diagram).
     */
    private final ApiExceptionImpl apiException;
    /**
     * References the network listener
     * (Due to the composition link on the class diagram).
     */
    private final NetworkListener networkListener;
    /**
     * References the worker manage
     * (Due to the composition link on the class diagram).
     */
    private final WorkManagement workManager;
    /**
     * Contains the correspondance between UserId and Ips.
     */
    private final Map<String, String> directory;

    /*########################################################################*/
    /* CONSTRUCTORS */
    /*########################################################################*/
    /**
     * Construct a new controller and links all the singleton's instances
     */
    public Controller() {
        //Create the directory
        directory = new HashMap<>();

        //Contains all the API's instances
        apiException = bitmusic.network.main.ApiExceptionImpl.getInstance();
        apiHmi = bitmusic.network.main.ApiHmiImpl.getInstance();
        apiMusic = bitmusic.network.main.ApiMusicImpl.getInstance();
        apiProfile = bitmusic.network.main.ApiProfileImpl.getInstance();

        //Contains the NetworkListener instance
        networkListener = bitmusic.network.main.NetworkListener.getInstance();

        //Contains the WorkManager instance
        workManager = bitmusic.network.main.WorkManagement.getInstance();
    }

    /*########################################################################*/
    /* GETTERS */
    /*########################################################################*/
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
        return networkListener;
    }
    /**
     * Get the WorkManager.
     * @return instance of WorkManager
     */
    public final WorkManagement getWorkManager() {
        return workManager;
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
            final String ipAddress) throws Exception {
        if (directory.containsKey(userId)) {
            apiException.throwException(
                    EnumTypeException.NetworkDirectoryException,
                    "The user is already in the directory.");
        }
        directory.put(userId, ipAddress);
    }
    /**
     * .
     * @param userId Id of the user
     * @throws Exception An exception is thrown if the userId doesn't exist
     */
    public final void removeUserFromDirectory(final String userId)
            throws Exception {
        if (!directory.containsKey(userId)) {
            apiException.throwException(
                    EnumTypeException.NetworkDirectoryException,
                    "The user " + userId + " doesn't exist in the directory.");
        }
        directory.remove(userId);
    }
}