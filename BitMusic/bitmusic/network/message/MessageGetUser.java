/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.profile.classes.User;


/**
 * Message to ask a distant user to send his profile.
 * @author alexis
 */
public final class MessageGetUser extends AbstractMessage {
    /**
     * ID of the User that owns the list we want.
     */
    private String askedUser;

    /**
     * ID of the user that asks for this list.
     */
    private String operator;

    /**
     * ID of the research ?
     */
    private String researchId;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramAskedUser ID of the user that owns the list
     * @param paramOperator ID of the user that asks for the list
     * @param paramResearchId ID of the research
     */
    public MessageGetUser(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramAskedUser, final String paramOperator,
            final String paramResearchId) {
        super(paramType, paramIpSource, paramIpDest);
        askedUser = paramAskedUser;
        operator = paramOperator;
        researchId = paramResearchId;
    }

    /**
     * Send the current profile to the user requesting it over the network
     */
    @Override
    public void treatment() {
        /**
         * @TODO change getCurrentLightUser with actual method from Profile
         */
        /*User currentUser = getCurrentLightUser();
        if(this.askedUser.equals(currentUser.getUserId())){
            MessageSendUser message = new MessageSendUser(
                    EnumTypeMessage.SendUser, ipDest, 
                    ipSource, currentUser, researchId);
          */  
            // Send message...
        }
    }

    /**
     * Setter of the asekedUser attribute.
     * @param paramAskedUser ID of the user that owns the list
     */
    public void setAskedUser(final String paramAskedUser) {
        this.askedUser = paramAskedUser;
    }

    /**
     * Setter of the operator attribute.
     * @param paramOperator ID of the user that asks for the list
     */
    public void setOperator(final String paramOperator) {
        this.operator = paramOperator;
    }

    /**
     * Setter of the researchId attribute.
     * @param paramResearchId ID of the research
     */
    public void setResearchId(final String paramResearchId) {
        this.researchId = paramResearchId;
    }

    /**
     * Getter of the askedUser attribute.
     * @return String Id of the user that owns the list
     */
    public String getAskedUser() {
        return askedUser;
    }

    /**
     * Getter of the operator attribute.
     * @return String ID of the user that asks for the list
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Getter of the researchId attribute.
     * @return String ID of the research
     */
    public String getResearchId() {
        return researchId;
    }
}
