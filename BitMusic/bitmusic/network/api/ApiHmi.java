/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
import bitmusic.profile.classes.User;

/**
 *
 * @author florian, alexis
 */
public interface ApiHmi {
    /**
     * Notify every distant user that we are logging out.
     *
     * @param userId local user ID
     * @throws Exception thrown when the logging out fails
     */
    void logOut(final String userId) throws Exception;
    /**
     * Get the profile of a distant user.
     *
     * @param operator    local user ID who is requesting for the song
     * @param userId    id of the user whose profile we want.
     * @param researchId    id of the research
     * @throws NetworkException thrown when the get fail
     */
    void getUser(final String operator, final String userId,
            final String researchId) throws NetworkException;
    /**
     * Ask for a remote song file.
     *
     * @param operator    local user ID who is requesting the song
     * @param userId distant user ID that owns the song
     * @param songId distant song ID that you want retrieve
     * @param paramTemporary will the song be downloaded as temporary
     * @throws NetworkException thrown when the get fail
    */
    void getSongFile(final String operator, final String userId,
            final String songId, final boolean paramTemporary)
            throws NetworkException;
}