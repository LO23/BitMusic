/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.music.data.Song;
import bitmusic.network.api.ApiHmi;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageLogOut;
import bitmusic.profile.classes.User;
import java.util.Map;

/**
 *
 * @author florian
 */
public final class ApiHmiImpl implements ApiHmi {
    /**
    * Singleton implementation.
    */
    private static final ApiHmiImpl APIHMIIMPL = new ApiHmiImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiHmiImpl() { }

    /**
     * .
     * @return Unique instance of ApiHmiImpl
     */
    protected static ApiHmiImpl getInstance() {
        return APIHMIIMPL;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Notify every distant user that we are logging out.
     *
     * @param userId local user ID
     * @throws Exception thrown when the logging out fails
     */
    @Override
    public void logOut(final String userId) throws Exception {
        //Get the source address
        String sourceAddress;

        //Warning, it may emmit an exception thrown to the calling method!
        sourceAddress = Controller.getInstance().
                getUserIpFromDirectory(userId);

        AbstractMessage message = null;
        //Loop on the directory
        Map<String, String> userDirectory = Controller.getInstance().getDirectory();
        for (Map.Entry<String, String> entry : userDirectory.entrySet()) {
            //entry.getValue()) contains remote user IP

            //Construct a message
            message = new MessageLogOut(
                //Type of message
                EnumTypeMessage.LogOut,
                //Source address
                sourceAddress,
                //Destination address
                entry.getValue(),
                //userId
                userId,
                //Remote userId
                entry.getKey());

            //Give the message to a worker...
            Controller.getInstance().getThreadManager().assignTaskToHermes(message);
        }
    }
    /**
     * Save, on local user machine, a song from a distant user machine.
     * @param userId    distant user ID that owns the song
     * @param songId    song ID on the distant user machine
     * @return True if the message was successfully sent, otherwise false
     * @throws Exception thrown when saving fails
     */
    @Override
    public boolean saveSong(final String userId, final String songId)
        throws Exception {
        boolean bool = false;

        return bool;
    }
    /**
     * Get the profile of a distant user.
     *
     * @param userId    id of the user whose profile we want.
     * @param researchId    id of the research
     * @return  User profile of the distant user, null if no such user found
     * @throws Exception thrown when the get fail
     */
    public User getUser(final String userId, final String researchId)
            throws Exception {
        User user = null;

        return user;
    }
    /**
     * Request a distant user to send one of his song.
     *
     * @param userAsked owner of the song
     * @param requestedSong song required
     * @param temporary true if it is a temporary download (default),
     * false if you want to keep the song
     * @return  True if the request was correctly sent
     */
    @Override
    public boolean getSong(final String userAsked, final Song requestedSong,
            final boolean temporary) {
        boolean bool = false;

        return bool;
    }
    /**
     * Request a distant user to send one of his song.
     * Implements the function with temporary = true (it's a temporary download)
     * @param userAsked owner of the song
     * @param requestedSong song required
     * false if you want to keep the song
     * @return  True if the request was correctly sent
     */
    @Override
    public boolean getSong(final String userAsked, final Song requestedSong) {
        return this.getSong(userAsked, requestedSong, true);
    }
    /**
     * Ask for a remote song file.
     *
     * @param userId distant user ID that owns the song
     * @param songId distant song ID that you want retrieve
    */
    @Override
    public void getSongFile(final String userId, final String songId) {

    }
}
