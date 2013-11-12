/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.network.main.Controller;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.api.ApiHmi;
import bitmusic.network.exception.NetworkDirectoryException;

/**
 *
 * @author alexis
 */
public final class MessageLogOut extends AbstractMessage {
    /**
     * Sender user ID.
     */
    private String userId;

    /**
     * Receiver user ID.
     */
    private String userIdLan;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId Sender user ID
     * @param paramUserIdLan Receiver user ID
     */
    public MessageLogOut(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final String paramUserIdLan) {
        super(paramType, paramIpSource, paramIpDest);
        userId = paramUserId;
        userIdLan = paramUserIdLan;
    }

    /**
     * .
     */
    @Override
    public void treatment() {
        try {
            Controller.getInstance().removeUserFromDirectory(this.getUserId());
            final ApiHmi apiHmi = WindowComponent.getInstance().getApiHmi();
            apiHmi.removeUserFromOnlineUsers(this.getUserId());

        } catch(NetworkDirectoryException exception) {

        }
    }

    /**
     * Setter of userId attribute.
     * @param paramUserId Sender user ID
     */
    public void setUserId(final String paramUserId) {
        this.userId = paramUserId;
    }

    /**
     * Getter of userId attribute.
     * @return String Sender user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter of userIdLan attribute.
     * @param paramUserIdLan Receiver user ID
     */
    public void setUserIdLan(final String paramUserIdLan) {
        this.userIdLan = paramUserIdLan;
    }

    /**
     * Getter of userIdLan attribute.
     * @return boolean The boolean value
     */
    public String getUserIdLan() {
        return userIdLan;
    }
}
