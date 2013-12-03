/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.profile.classes.User;
import bitmusic.network.main.Controller;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.network.exception.NetworkDirectoryException;
import bitmusic.profile.api.ApiProfileImpl;



/**
 * Message to notify to distant user that we are logged in.
 * @author alexis
 */
public final class MessageNotifyNewConnection extends AbstractMessage {
    /**
     * The profile we send to the newly connected user.
     */
    private User user;

    /**
     * True if we the distant user to send back his profile.
     */
    private boolean giveMeYourProfile;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUser The profile we send
     * @param paramGiveProfile Should distant user send back his profile
     */
    public MessageNotifyNewConnection(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final User paramUser, final boolean paramGiveProfile) {
        super(paramType, paramIpSource, paramIpDest);
        user = paramUser;
        giveMeYourProfile = paramGiveProfile;
    }

    /**
     * Method that implements the treatment of the message.
     */
    @Override
    public void treatment() {
       try {
           //Add user to the directory
           Controller.getInstance()
                   .addUserToDirectory(this.user.getUserId(),
                                       this.getIpSource());
           //Notify user connecxion to HMI
           WindowComponent.getInstance().getApiHmi().
                   notifyNewConnection(this.user);

           final User currentUser = ApiProfileImpl.getApiProfile().
                   getCurrentUser();

           //Build an answer message to the new user
           final MessageReplyConnectionUser message =
                   new MessageReplyConnectionUser(
                    //Type of Message
                    EnumTypeMessage.ReplyConnectionUser,
                    //IP Source
                    this.ipDest,
                    //IP Dest
                    this.ipSource,
                    //User Profile
                    currentUser);

           Controller.getInstance().getThreadManager()
                                   .assignTaskToHermes(message);

       } catch (NetworkDirectoryException exception) {
               WindowComponent.getInstance().getApiHmi()
                       .errorNotification("Network", exception.getMessage());
       }

   }

    /**
     * Setter of profile attribute.
     * @param paramUser The user object to set
     */
    public void setUser(final User paramUser) {
        this.user = paramUser;
    }

    /**
     * Getter of myProfile attribute.
     * @return User The user we are about to send
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter of giveMeYourProfile attribute.
     * @param giveProfile New boolean value
     */
    public void setGiveMeYourProfile(final boolean giveProfile) {
        this.giveMeYourProfile = giveProfile;
    }

    /**
     * Getter of giveMeYourProfile attribute.
     * @return boolean The boolean value
     */
    public boolean isGiveMeYourProfile() {
        return giveMeYourProfile;
    }
}
