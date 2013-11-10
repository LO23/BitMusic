/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.api.ApiMusic;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.profile.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author florian
 */
public final class ApiMusicImpl implements ApiMusic {
    /**
    * Singleton implementation.
    */
    private static final ApiMusicImpl APIMUSICIMPL = new ApiMusicImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiMusicImpl() { }

    /**
     * .
     * @return Unique instance of ApiMusicImpl
     */
    protected static ApiMusicImpl getInstance() {
        return APIMUSICIMPL;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Send a list of all connected users.
     *
     * @return list of all connected users
     */
    @Override
    public List<User> getListUser() {
        List<User> userList = new ArrayList<User>();

        return userList;
    }
    /**
     * Send a comment about a song to a distant user.
     *
     * @param song song concerned
     * @param comment the new comment to add
    */
    @Override
    public void addComment(final Song song, final Comment comment){

    }
    /**
     * Ask a distant user to search for keywords in his tags.
     * This is an asynchrounous call
     *
     * @param operator user operating the research
     * @param askedUser user asked
     * @param idResearch the id of the research
     * @param keywordsList keywords searched
     * @param option 0 = ALL keywords must match (default), 1 = ANY
     * keyword match
     */
    @Override
    public void tagRequest(final String operator, final String askedUser,
            final String idResearch, final List<String> keywordsList,
            final int option) {

    }
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
    @Override
    public void tagRequest(final String operator, final String askedUser,
            final String idResearch, final List<String> keywordsList) {
        this.tagRequest(operator, askedUser, idResearch, keywordsList, 0);
    }
    /**
     * Network message send to a distant user to ask him to send his songList.
     *
     * @param askedUser user to ask
     * @param researchId id of the research
     */
    @Override
    public void getSongsByUser(final String askedUser, final String researchId) {

    }
    /**
     * Search songs in the LAN  with tag specified in the search.
     *
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     */
    @Override
    public void searchSongsByTags(final String userIdDest,
            final String searchId, final List<String> tagList) {

    }
    /**
     *Return the list of users’ IDs.
     *
     * @return listUserId
     */
    @Override
    public List<String> getAllUserId() {
        List<String> userIdList = new ArrayList<String>();

        return userIdList;
    }

}
