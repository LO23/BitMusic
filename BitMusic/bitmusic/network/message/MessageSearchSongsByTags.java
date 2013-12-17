/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.music.api.ApiMusicImpl;
import bitmusic.music.data.SongLibrary;
import bitmusic.network.exception.NetworkDirectoryException;
import bitmusic.network.main.Controller;
import java.util.List;

/**
 *
 * @author florian
 */
public class MessageSearchSongsByTags extends AbstractMessageSearchSongs {

      /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSearchId ID of the search
     * @param paramTagList List of tags
     * @param paramUserId ID the user that asked for the search
     */
    public MessageSearchSongsByTags(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramSearchId, final List<String> paramTagList,
            final String paramUserId) {
        super(paramType, paramIpSource, paramIpDest, paramSearchId,
                paramTagList, paramUserId);
    }

    /**
     * Method that implements the treatment of the message.
     */
    @Override
    public final void treatment() {
        try {
            final String userRequestedId = Controller.getInstance().
                    getUserIdFromDirectory(this.ipDest);

            final SongLibrary songLib = ApiMusicImpl.getInstance().
                    searchLocalSongsByTags(
                        //tag list
                        this.tagList,
                        //requested user
                        userRequestedId
                        );

            final MessageSendSongList message = new MessageSendSongList(
                    //type of message
                    EnumTypeMessage.SendSongList,
                    //ip source
                    Controller.getNetworkAddress(),
                    //ip dest
                    this.ipSource,
                    //search id
                    this.searchId,
                    //song library
                    songLib);

            Controller.getInstance().getThreadManager().
                    assignTaskToHermes(message);
        } catch (NetworkDirectoryException e) {
            e.printStackTrace();
        }
    }
}
