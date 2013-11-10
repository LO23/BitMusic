/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import java.util.ArrayList;

/**
 * Message used to search songs with tags.
 * @author alexis
 */
public final class MessageSearchSongsByTag extends AbstractMessage {
    /**
     * ID of the search.
     */
    private String searchId;

    /**
     * List of tags.
     */
    private ArrayList<String> tagList;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSearchId ID of the search
     * @param paramTagList List of tags
     */
    public MessageSearchSongsByTag(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramSearchId, final ArrayList<String> paramTagList) {
        super(paramType, paramIpSource, paramIpDest);
        searchId = paramSearchId;
        tagList = paramTagList;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

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
    public ArrayList<String> getTagList() {
        return tagList;
    }


}
