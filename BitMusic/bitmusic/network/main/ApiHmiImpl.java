/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.network.api.ApiHmi;
import bitmusic.network.exception.NetworkDirectoryException;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageAddComment;
import bitmusic.network.message.MessageGetSongFile;
import bitmusic.network.message.MessageLogOut;
import bitmusic.network.message.MessageGetUser;
import bitmusic.network.message.MessageNotifyNewConnection;
import bitmusic.network.message.MessageRateSong;
import bitmusic.profile.classes.User;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the API we provide to HMI.
 * @author florian, alexis
 */
public final class ApiHmiImpl implements ApiHmi {
    /**
    * Singleton implementation.
    */
    private static final ApiHmiImpl API_HMI_IMPL = new ApiHmiImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiHmiImpl() { }

    /**
     * Getter of the only instance of this class.
     * @return Unique instance of ApiHmiImpl
     */
    protected static ApiHmiImpl getInstance() {
        return API_HMI_IMPL;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Send a comment about a song to a distant user.
     *
     * @param song song concerned
     * @param comment the new comment to add
     * @throws NetworkException thrown when the user doesn't have
     *                           sufficient rights
    */
    @Override
    public void addComment(final Song song, final Comment comment)
            throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        final String destAddress = Controller.getInstance().
        getUserIpFromDirectory(song.getOwnerId());


        final MessageAddComment message = new MessageAddComment(
                EnumTypeMessage.AddComment,
                sourceAddress,
                destAddress,
                bitmusic.profile.api.ApiProfileImpl.getApiProfile().getCurrentUser().getUserId(),
                song,
                comment);
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
    /**
     * Notify every distant user that we are logging out.
     *
     * @param userId local user ID
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void logOut(final String userId) throws NetworkException {

        //Loop on the directory
        final Map<String, String> userDirectory = Controller.getInstance().
                getDirectory();

        for (Map.Entry<String, String> entry : userDirectory.entrySet()) {
            //entry.getValue()) contains remote user IP

            //Construct a message
            final MessageLogOut message = new MessageLogOut(
                //Type of message
                EnumTypeMessage.LogOut,
                //Source address
                Controller.getNetworkAddress(),
                //Destination address
                entry.getValue(),
                //userId
                userId,
                //Remote userId
                entry.getKey());

            //Give the message to a worker...
            Controller.getInstance().getThreadManager().
                    assignTaskToHermes(message);
        }
    }
    /**
     * Get the profile of a distant user.
     *
     * @param operator    local user ID who is requesting the remote profile
     * @param userId    id of the user whose profile we want.
     * @param researchId    id of the research
     * @throws NetworkException thrown when the get fail
     */
    @Override
    public void getUser(final String operator, final String userId,
            final String researchId) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the destination address
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userId);

        final MessageGetUser message = new MessageGetUser(
                //type of the message
                EnumTypeMessage.GetUser,
                //source address
                sourceAddress,
                //destination address
                destAddress,
                //ID of the user that owns the profile
                userId,
                //ID of the user that asks for the profile
                operator,
                //ID of the research
                researchId);

        //Give the message to a worker...
            Controller.getInstance().getThreadManager().
                    assignTaskToHermes(message);
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
     * Shutdown the Executor service (thread pool) when program exits.
     */
    @Override
    public void shutdownExecutorService() {

        Controller.getInstance().getThreadManager()
                .getExecutorService().shutdown();

    }

    /**
     * Rate a distant song.
     * @param paramSong The song to rate
     * @param paramUserId ID of the user that rates the song
     */
    @Override
    public void rateSong(final Song paramSong, final String paramUserId) {
        final String owner = paramSong.getOwnerId();
        try {
            final MessageRateSong message = new MessageRateSong(
                EnumTypeMessage.RateSong,
                Controller.getNetworkAddress(),
                Controller.getInstance().getUserIpFromDirectory(owner),
                paramSong,
                paramUserId);

            Controller.getInstance().
                    getThreadManager().assignTaskToHermes(message);

        } catch (NetworkDirectoryException e) {

        }

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

    /**
    * Notify connection of a user and pass his profile to broadcast it.
    *
    * @param user the complete user who just connected
    */
    @Override
    public void notifyNewConnection(final User user) {
        //Get the source address
        final String sourceAddress = Controller.getNetworkAddress();

        //Construct the message
        final MessageNotifyNewConnection message =
                new MessageNotifyNewConnection(
                    //Type of message
                    EnumTypeMessage.NotifyNewConnection,
                    //Source address
                    sourceAddress,
                    //Destination address (Everyone)
                    Controller.getBroadcastAddress(),
                    //idUser
                    user,
                    //Get the profile
                    true);

        //Give the message to a worker...
        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }
}
