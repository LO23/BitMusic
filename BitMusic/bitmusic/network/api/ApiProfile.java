/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.network.exception.NetworkException;
import bitmusic.profile.classes.User;

/**
 *
 * @author florian
 */
public interface ApiProfile {
    /**
     * Get the profile of a distant user.
     *
     * @param operator the id of the asking user.
     * @param userId the id of the user whose profile we want.
     * @param searchId the id of research.
     * @throws NetworkException throws an exception when the given idUser isn't
     * in the directory
    */
    void getUser(final String operator, final String userId,
            final String searchId) throws NetworkException;


}
