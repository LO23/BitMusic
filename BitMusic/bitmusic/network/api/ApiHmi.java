/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
import bitmusic.profile.classes.User;
import java.util.List;

/**
 * Interface given to HMI to interact with the Network.
 * @author florian, alexis
 */
public interface ApiHmi {
    /**
     * Send a comment about a song to a distant user.
     *
     * @param song song concerned
     * @param comment the new comment to add
     * @throws NetworkException thrown when the user doesn't exist
    */
    void addComment(final Song song, final Comment comment)
            throws NetworkException;
    /**
     * Notify every distant user that we are logging out.
     *
     * @param userId local user ID
     * @throws NetworkException thrown when the logging out fails
     */
    void logOut(final String userId) throws NetworkException;
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
    /**
     *  Shutdown the Executor service (thread pool) when program exits.
     */
    void shutdownExecutorService();

    /**
     *
     * @return The list of User who are connected
     */
    List<String> getAllUserId();

    /**
    * Notify connection of a user and pass his profile to broadcast it.
    *
    * @param user the complete user who just connected
    * @throws NetworkException throws an exception when the given user isn't
    * registered in the directory
    */
    void notifyNewConnection(final User user) throws NetworkException;
}
