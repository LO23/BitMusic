/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

/**
 * Abstract class for messages.
 * @author florian, alexis
 */
public abstract class AbstractMessage {
    /**
     * Type of the message.
     */
    private EnumTypeMessage type;

    /**
     * IP address of the sender.
     */
    protected String ipSource;

    /**
     * IP address of the receiver.
     */
    protected String ipDest;

    /**
     * Constructor.
     * @param paramType Type of the new message.
     * @param paramIpSource IP address of the sender.
     * @param paramIpDest IP address of the receiver.
     */
    protected AbstractMessage(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest) {
        type = paramType;
        ipSource = paramIpSource;
        ipDest = paramIpDest;
    }

    /**
     * .
     */
    public abstract void treatment();

    /**
     * Getter of type attribute.
     * @return EnumTypeMessage Type of the message
     */
    public final EnumTypeMessage getType() {
        return type;
    }

    /**
     * Getter of ipSource attribute.
     * @return String IP address of the sender
     */
    public final String getIpSource() {
        return ipSource;
    }

    /**
     * Getter of ipDest attribute.
     * @return String IP adress of the receiver
     */
    public final String getIpDest() {
        return ipDest;
    }

    /**
     * Setter of type attribute.
     * @param paramType New type of the message
     */
    public final void setType(final EnumTypeMessage paramType) {
        this.type = paramType;
    }

    /**
     * Setter of ipSource attribute.
     * @param paramIpSource New IP address for sender.
     */
    public final void setIpSource(final String paramIpSource) {
        this.ipSource = paramIpSource;
    }

    /**
     * Setter of ipDest attribute.
     * @param paramIpDest New IP address for receiver.
     */
    public final void setIpDest(final String paramIpDest) {
        this.ipDest = paramIpDest;
    }
}
