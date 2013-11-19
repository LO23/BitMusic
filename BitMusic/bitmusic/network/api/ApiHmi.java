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
     * @param operator    local user ID who is requesting for the song
     * @param userId    distant user ID that owns the song
     * @param songId    song ID on the distant user machine
     * @throws NetworkException thrown when saving fails
     */
    void saveSong(final String operator, final String userId,
            final String songId) throws NetworkException;
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
     * Request a distant user to send one of his song.
     *
     * @param operator    local user ID who is requesting for the song
     * @param userAsked owner of the song
     * @param requestedSong song required
     * @param temporary true if it is a temporary download (default),
     * false if you want to keep the song
     * @throws NetworkException thrown when the get fail
     */
    void getSong(final String operator, final String userAsked,
            final Song requestedSong, final boolean temporary)
            throws NetworkException;
    /**
     * Request a distant user to send one of his song.
     * Implements the function with temporary = true (it's a temporary download)
     * @param operator    local user ID who is requesting the song
     * @param userAsked owner of the song
     * @param requestedSong song required
     * false if you want to keep the song
     * @throws NetworkException thrown when the get fail
     */
    void getSong(final String operator, final String userAsked,
            final Song requestedSong) throws NetworkException;
    /**
     * Ask for a remote song file.
     *
     * @param operator    local user ID who is requesting the song
     * @param userId distant user ID that owns the song
     * @param songId distant song ID that you want retrieve
     * @throws NetworkException thrown when the get fail
    */
    void getSongFile(final String operator, final String userId,
            final String songId) throws NetworkException;

    /**
     *  Shutdown the Executor service (thread pool) when program exits.
     */
    void shutdownExecutorService();
}