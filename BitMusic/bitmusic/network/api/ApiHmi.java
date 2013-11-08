/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.music.data.Song;
import bitmusic.profile.User;

/**
 *
 * @author florian
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
     * Save, on local user machine, a song from a distant user machine.
     * @param userId    distant user ID that owns the song
     * @param songId    song ID on the distant user machine
     * @return True if the message was successfully sent, otherwise false
     * @throws Exception thrown when saving fails
     */
    boolean saveSong(final String userId, final String songId) throws Exception;
    /**
     * Get the profile of a distant user.
     *
     * @param userId    id of the user whose profile we want.
     * @param researchId    id of the research
     * @return  User profile of the distant user, null if no such user found
     * @throws Exception thrown when the get fail
     */
    User getUser(final String userId, final String researchId) throws Exception;
    /**
     * Request a distant user to send one of his song.
     *
     * @param userAsked owner of the song
     * @param requestedSong song required
     * @param temporary true if it is a temporary download (default),
     * false if you want to keep the song
     * @return  True if the request was correctly sent
     */
    boolean getSong(final User userAsked, final Song requestedSong,
            final boolean temporary);
    /**
     * Request a distant user to send one of his song.
     * Implements the function with temporary = true (it's a temporary download)
     * @param userAsked owner of the song
     * @param requestedSong song required
     * false if you want to keep the song
     * @return  True if the request was correctly sent
     */
    boolean getSong(final User userAsked, final Song requestedSong);
    /**
     * Ask for a remote song file.
     *
     * @param userId distant user ID that owns the song
     * @param songId distant song ID that you want retrieve
    */
    void getSongFile(final String userId, final String songId);
}
