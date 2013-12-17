/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
import java.util.List;

/**
 * Interface given to Music to interact with the Network.
 * @author florian, alexis
 */
public interface ApiMusic {

    /**
     * Network message send to a distant user to ask him to send his songList.
     *
     * @param operator asking user
     * @param askedUser user to ask
     * @param researchId id of the research
     * @throws NetworkException thrown when the user doesn't exist
     */
    void getSongsByUser(final String operator, final String askedUser,
            final String researchId) throws NetworkException;
    /**
     * Search songs by album in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    void searchSongsByAlbum(final String operator, final String userIdDest,
            final String searchId, final List<String> tagList)
            throws NetworkException;
    /**
     * Search songs by artist in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    void searchSongsByArtist(final String operator, final String userIdDest,
            final String searchId, final List<String> tagList)
            throws NetworkException;
    /**
     * Search songs by tags in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    void searchSongsByTags(final String operator, final String userIdDest,
            final String searchId, final List<String> tagList)
            throws NetworkException;
    /**
     * Search songs by title in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    void searchSongsByTitle(final String operator, final String userIdDest,
            final String searchId, final List<String> tagList)
            throws NetworkException;
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
     *Return the list of users’ IDs.
     *
     * @return listUserId
     */
    List<String> getAllUserId();
}
