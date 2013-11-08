/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.profile.User;

/**
 * Message to send our profile to a newly connected user.
 * @author alexis
 */
public final class MessageReplyConnectionUser extends AbstractMessage {
    /**
     * The profile we send to the newly connected user.
     */
    private User myProfile;

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
        myProfile = paramUser;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }

    /**
     * Setter of myProfile attribute.
     * @param paramMyProfile The profile to set
     */
    public void setMyProfile(final User paramMyProfile) {
        this.myProfile = paramMyProfile;
    }

    /**
     * Getter of myProfile attribute.
     * @return User The profile we are about to send
     */
    public User getMyProfile() {
        return myProfile;
    }

}
