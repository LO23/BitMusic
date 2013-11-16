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
 *
 * @author florian
 */
public interface ApiMusic {
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
     * Ask a distant user to search     for keywords in his tags.
     * This is an asynchrounous call
     *
     * @param operator user operating the research
     * @param askedUser user asked
     * @param idResearch the id of the research
     * @param keywordsList keywords searched
     * @param option 0 = ALL keywords must match (default), 1 = ANY
     * keyword match
     * @throws NetworkException thrown when the user doesn't exist
     */
    void tagRequest(final String operator, final String askedUser,
            final String idResearch, final List<String> keywordsList,
            final int option) throws NetworkException;
    /**
     * Ask a distant user to search for keywords in his tags.
     * Implements the default option option = 0 (ALL keywords must match)
     * This is an asynchrounous call
     *
     * @param operator user operating the research
     * @param askedUser user asked
     * @param idResearch the id of the research
     * @param keywordsList keywords searched
     * @throws NetworkException thrown when the user doesn't exist
     */
    void tagRequest(final String operator, final String askedUser,
            final String idResearch, final List<String> keywordsList)
            throws NetworkException;
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
     * Search songs in the LAN  with tag specified in the search.
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
     *Return the list of users’ IDs.
     *
     * @return listUserId
     */
    List<String> getAllUserId();
}
