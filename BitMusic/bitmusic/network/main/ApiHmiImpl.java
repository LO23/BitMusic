/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.music.data.Song;
import bitmusic.network.api.ApiHmi;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageLogOut;
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
     * @throws NetworkException thrown when the user doesn't exist
     */
    @Override
    public void logOut(final String userId) throws NetworkException {
        //Get the source address
        String sourceAddress;

        //Warning, it may emmit an exception thrown to the calling method!
        sourceAddress = Controller.getInstance().
                getUserIpFromDirectory(userId);

        AbstractMessage message = null;

        //Loop on the directory
        final Map<String, String> userDirectory = Controller.getInstance().
                getDirectory();

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
        Controller.getInstance().getApiProfile().
                getUser(operator, userId, researchId);
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

    }
}