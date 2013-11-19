/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.profile.classes.User;

/**
 * Message used to send our asked Profile.
 * @author alexis
 */
public final class MessageSendUser extends AbstractMessage {
    /**
     * The asked profile.
     */
    private User user;

    /**
     * ID of the search.
     */
    private String searchId;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUser The asked profile
     * @param paramSearchId ID of the search
     */
    public MessageSendUser(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final User paramUser, final String paramSearchId) {
        super(paramType, paramIpSource, paramIpDest);
        user = paramUser;
        searchId = paramSearchId;
    }

    /**
     * .
     */
    @Override
    public void treatment() {
        WindowComponent.getInstance().getApiHmi().notifyLightProfile(
                //light Profile
                this.user,
                //researchID
                this.searchId);
    }

    /**
     * Setter of the user attribute.
     * @param paramUser The asked profile
     */
    public void setUser(final User paramUser) {
        this.user = paramUser;
    }

    /**
     * Setter of the searchId attribute.
     * @param paramSearchId ID of the search
     */
    public void setSearchId(final String paramSearchId) {
        this.searchId = paramSearchId;
    }

    /**
     * Getter of the user attribute.
     * @return User The asked profile
     */
    public User getUser() {
        return user;
    }

    /**
     * Getter of the searchId attribute.
     * @return String ID of the search
     */
    public String getSearchId() {
        return searchId;
    }

}
