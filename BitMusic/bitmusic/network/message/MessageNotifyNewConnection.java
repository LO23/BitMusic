/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.profile.User;

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
     * .
     */
    @Override
    public void treatment() {

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