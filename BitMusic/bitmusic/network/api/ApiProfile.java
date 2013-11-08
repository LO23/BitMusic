/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.profile.User;

/**
 *
 * @author florian
 */
public interface ApiProfile {
    /**
     * Get the profile of a distant user.
     *
     * @param userId the id of the user whose profile we want.
     * @return profile of the distant user, null if no such user found
    */
    User getUser(final String userId);

    /**
    * Notify connection of a user and pass his profile to broadcast it.
    *
    * @param idUser the id of the user who just connected
    */
    void notifyNewConnection(final User idUser);
}
