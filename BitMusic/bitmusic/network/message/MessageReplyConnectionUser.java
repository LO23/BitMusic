/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.profile.classes.User;

/**
 * Message to send our profile to a newly connected user.
 * @author alexis
 */
public final class MessageReplyConnectionUser extends AbstractMessage {
    /**
     * The profile we send to the newly connected user.
     */
    private User profile;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUser The profile we send
     */
    public MessageReplyConnectionUser(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final User paramUser) {
        super(paramType, paramIpSource, paramIpDest);
        profile = paramUser;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }

    /**
     * Setter of profile attribute.
     * @param paramProfile The profile to set
     */
    public void setProfile(final User paramProfile) {
        this.profile = paramProfile;
    }

    /**
     * Getter of myProfile attribute.
     * @return User The profile we are about to send
     */
    public User getProfile() {
        return profile;
    }

}
