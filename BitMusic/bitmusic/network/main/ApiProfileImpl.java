/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.api.ApiProfile;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageGetUser;
import bitmusic.network.message.MessageNotifyNewConnection;
import bitmusic.profile.classes.User;

/**
 *
 * @author florian
 */
public final class ApiProfileImpl implements ApiProfile {
    /**
    * Singleton implementation.
    */
    private static final ApiProfileImpl APIPROFILEHMI = new ApiProfileImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiProfileImpl() { }

    /**
     * .
     * @return Unique instance of ApiProfileImpl
     */
    protected static ApiProfileImpl getInstance() {
        return APIPROFILEHMI;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Get the profile of a distant user.
     *
     * @param operator the id of the asking user.
     * @param userId the id of the user whose profile we want.
     * @return profile of the distant user, null if no such user found
     * @throws NetworkException throws an exception when the given idUser isn't
     * in the directory
    */
    @Override
    public void getUser(final String operator, final String userId,
            final String searchId) throws NetworkException {
        //Get the source address
        final String sourceAddress;

        //Warning, it may emmit an exception thrown to the calling method!
        sourceAddress = Controller.getInstance().
                getUserIpFromDirectory(operator);

        //Get the remote address
        final String destAddress;

        //Warning, it may emmit an exception thrown to the calling method!
        destAddress = Controller.getInstance().
                getUserIpFromDirectory(userId);

        //Construct the message
        final AbstractMessage message;

        message = new MessageGetUser(
                EnumTypeMessage.GetUser,
                sourceAddress,
                destAddress,
                operator,
                userId,
                searchId);

        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
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
        final AbstractMessage message = new MessageNotifyNewConnection(
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
