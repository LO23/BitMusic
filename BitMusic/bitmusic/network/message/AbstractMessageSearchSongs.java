/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.music.business.SongSearcher;
import bitmusic.music.business.strategies.TagSearchStrategy;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.network.main.Controller;
import bitmusic.profile.api.ApiProfileImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Message used to search songs with tags on the LAN.
 * @author alexis
 */
public abstract class AbstractMessageSearchSongs extends AbstractMessage {
    /**
     * ID of the user that asked for the search.
     */
    protected String operator;

    /**
     * ID of the search.
     */
    protected String searchId;

    /**
     * List of tags.
     */
    protected List<String> tagList;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSearchId ID of the search
     * @param paramTagList List of tags
     * @param paramUserId ID the user that asked for the search
     */
    public AbstractMessageSearchSongs(final EnumTypeMessage paramType,
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
    public abstract void treatment();

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
