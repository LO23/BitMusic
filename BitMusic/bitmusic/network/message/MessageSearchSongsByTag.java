/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

/**
 *
 * @author alexis
 */
public class MessageSearchSongsByTag extends AbstractMessage {
    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     */
    public MessageSearchSongsByTag(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest) {
        super(paramType, paramIpSource, paramIpDest);
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }
}
