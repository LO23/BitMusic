/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.profile.User;
import java.util.List;
/**
 *
 * @author florian
 */
public interface ApiMusic {
    /**
     * Send a list of all connected users.
     *
     * @return list of all connected users
     */
    List<User> getListUser();
    /**
     * Send a comment about a song to a distant user.
     *
     * @param song song concerned
     * @param comment the new comment to add
    */
    void addComment(final Song song, final Comment comment);
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
     */
    void tagRequest(final User operator, final User askedUser,
            final String idResearch, final List<String> keywordsList,
            final int option);
    /**
     * Ask a distant user to search for keywords in his tags.
     * Implements the default option option = 0 (ALL keywords must match)
     * This is an asynchrounous call
     *
     * @param operator user operating the research
     * @param askedUser user asked
     * @param idResearch the id of the research
     * @param keywordsList keywords searched
     */
    void tagRequest(final User operator, final User askedUser,
            final String idResearch, final List<String> keywordsList);
    /**
     * Network message send to a distant user to ask him to send his songList.
     *
     * @param askedUser user to ask
     * @param researchId id of the research
     */
    void getSongsByUser(final String askedUser, final String researchId);
    /**
     * Search songs in the LAN  with tag specified in the search.
     *
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     */
    void searchSongsByTags(final String userIdDest, final String searchId,
            final List<String> tagList);
    /**
     *Return the list of users’ IDs.
     *
     * @return listUserId
     */
    List<String> getAllUserId();
}
