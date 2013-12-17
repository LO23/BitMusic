/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.api.ApiMusic;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageAddComment;
import bitmusic.network.message.MessageGetSongFile;
import bitmusic.network.message.MessageGetSongsByUser;
import bitmusic.network.message.MessageSearchSongsByAlbum;
import bitmusic.network.message.MessageSearchSongsByArtist;
import bitmusic.network.message.MessageSearchSongsByTags;
import bitmusic.network.message.MessageSearchSongsByTitle;
import java.util.List;

/**
 * Implementation of the API we provide to Music.
 * @author florian, alexis
 */
public final class ApiMusicImpl implements ApiMusic {
    /**
    * Singleton implementation.
    */
    private static final ApiMusicImpl API_MUSIC_IMPL = new ApiMusicImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiMusicImpl() { }

    /**
     * Getter of the only instance of this class.
     * @return Unique instance of ApiMusicImpl
     */
    protected static ApiMusicImpl getInstance() {
        return API_MUSIC_IMPL;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Network message send to a distant user to ask him to send his songList.
     *
     * @param operator user that is asking
     * @param askedUser user to ask
     * @param researchId id of the research
     *
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void getSongsByUser(final String operator, final String askedUser,
            final String researchId) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the remote address
        //Warning, it may emmit an exception thrown to the calling method!
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(askedUser);

        final MessageGetSongsByUser message = new MessageGetSongsByUser(
                EnumTypeMessage.GetSongsByUser,
                sourceAddress,
                destAddress,
                askedUser,
                operator,
                researchId);
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
    /**
     * Search songs by album in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void searchSongsByAlbum(final String operator,
            final String userIdDest, final String searchId,
            final List<String> tagList) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the remote address
        //Warning, it may emmit an exception thrown to the calling method!
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userIdDest);

        final MessageSearchSongsByAlbum message = new MessageSearchSongsByAlbum(
                EnumTypeMessage.SearchSongsByAlbum,
                sourceAddress,
                destAddress,
                searchId,
                tagList,
                userIdDest);
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
    /**
     * Search songs by artist in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void searchSongsByArtist(final String operator,
            final String userIdDest, final String searchId,
            final List<String> tagList) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the remote address
        //Warning, it may emmit an exception thrown to the calling method!
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userIdDest);

        final MessageSearchSongsByArtist message =
                new MessageSearchSongsByArtist(
                EnumTypeMessage.SearchSongsByArtist,
                sourceAddress,
                destAddress,
                searchId,
                tagList,
                userIdDest);
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
    /**
     * Search songs by tags in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void searchSongsByTags(final String operator,
            final String userIdDest, final String searchId,
            final List<String> tagList) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the remote address
        //Warning, it may emmit an exception thrown to the calling method!
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userIdDest);

        final MessageSearchSongsByTags message = new MessageSearchSongsByTags(
                EnumTypeMessage.SearchSongsByTags,
                sourceAddress,
                destAddress,
                searchId,
                tagList,
                userIdDest);
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
    /**
     * Search songs by title in the LAN  with tag specified in the search.
     *
     * @param operator asking user
     * @param userIdDest id of the distant user
     * @param searchId id of the research
     * @param tagList list of tags
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void searchSongsByTitle(final String operator,
            final String userIdDest, final String searchId,
            final List<String> tagList) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the remote address
        //Warning, it may emmit an exception thrown to the calling method!
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userIdDest);

        final MessageSearchSongsByTitle message = new MessageSearchSongsByTitle(
                EnumTypeMessage.SearchSongsByTitle,
                sourceAddress,
                destAddress,
                searchId,
                tagList,
                userIdDest);
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
    /**
     * Ask for a remote song file.
     *
     * @param operator    local user ID who is requesting the song
     * @param userId distant user ID that owns the song
     * @param songId distant song ID that you want retrieve
     * @param paramTemporary will the song be downloaded as temporary
     * @throws NetworkException thrown when the get fail
    */
    @Override
    public void getSongFile(final String operator, final String userId,
            final String songId, final boolean paramTemporary)
            throws NetworkException{
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the destination address
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userId);

        final MessageGetSongFile message = new MessageGetSongFile(
                //type of the message
                EnumTypeMessage.GetSongFile,
                //source address
                sourceAddress,
                //destination address
                destAddress,
                //ID of the user that owns the song
                userId,
                //ID of the song
                songId,
                //Is the file temporary ?
                paramTemporary);

        //Give the message to a worker...
            Controller.getInstance().getThreadManager().
                    assignTaskToHermes(message);
    }
    /**
     *Return the list of users’ IDs.
     *
     * @return listUserId
     */
    @Override
    public List<String> getAllUserId() {
        return Controller.getInstance().getUserListFromDirectory();
    }
}
