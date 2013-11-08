/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.api.ApiProfile;
import bitmusic.profile.User;
/**
 *
 * @author florian
 */
public final class ApiProfileImpl implements ApiProfile {
    /**
    * Singleton implementation.
    */
    private static final ApiProfileImpl APIPROFILEHMI = new ApiProfileImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiProfileImpl() { }

    /**
     * .
     * @return Unique instance of ApiProfileImpl
     */
    protected static ApiProfileImpl getInstance() {
        return APIPROFILEHMI;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Get the profile of a distant user.
     *
     * @param userId the id of the user whose profile we want.
     * @return profile of the distant user, null if no such user found
    */
    @Override
    public User getUser(final String userId) {
        User user = null;

        return user;
    }

    /**
    * Notify connection of a user and pass his profile to broadcast it.
    *
    * @param idUser the id of the user who just connected
    */
    @Override
    public void notifyNewConnection(final User idUser) {

    }
}
