/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.music.api.ApiMusicImpl;
import bitmusic.music.data.SongLibrary;
import bitmusic.network.main.Controller;
import java.util.ArrayList;
import java.util.List;

/**
 * Message used to search songs with tags on the LAN.
 * @author alexis
 */
public final class MessageSearchSongsByTag extends AbstractMessage {
    /**
     * ID of the user that asked for the search.
     */
    private String operator;

    /**
     * ID of the search.
     */
    private String searchId;

    /**
     * List of tags.
     */
    private List<String> tagList;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSearchId ID of the search
     * @param paramTagList List of tags
     * @param paramUserId ID the user that asked for the search
     */
    public MessageSearchSongsByTag(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramSearchId, final List<String> paramTagList,
            final String paramUserId) {
        super(paramType, paramIpSource, paramIpDest);
        searchId = paramSearchId;
        tagList = paramTagList;
        operator = paramUserId;
    }

    /**
     * Method that implements the treatment of the message.
     */
    @Override
    public void treatment() {
        final SongLibrary songLib = ApiMusicImpl.getInstance().
                searchSongsByTags(
                    //search id
                    this.searchId,
                    //tag list
                    this.tagList);

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

        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }

    /**
     * Setter of the searchId attribute.
     * @param paramSearchId ID of the search
     */
    public void setSearchId(final String paramSearchId) {
        this.searchId = paramSearchId;
    }

    /**
     * Setter of the tagList attribute.
     * @param paramTagList List of tags
     */
    public void setTagList(final ArrayList<String> paramTagList) {
        this.tagList = paramTagList;
    }

    /**
     * Setter of the operator attribute.
     * @param paramOperator ID of the user that asked for the search
     */
    public void setOperator(final String paramOperator) {
        this.operator = paramOperator;
    }

    /**
     * Getter of the searchId attribute.
     * @return String ID of the search
     */
    public String getSearchId() {
        return searchId;
    }

    /**
     * Getter og the tagList attribute.
     * @return ArrayList<String> List of tags
     */
    public List<String> getTagList() {
        return tagList;
    }

    /**
     * Getter of the operator attribute.
     * @return String ID of the user that asked for the search
     */
    public String getOperator() {
        return operator;
    }
}
