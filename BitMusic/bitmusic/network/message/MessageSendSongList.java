/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.music.data.SongLibrary;

/**
 * Message used to send a song list.
 * @author alexis
 */
public final class MessageSendSongList extends AbstractMessage {
    /**
     * ID of the search.
     */
    private String searchId;

    /**
     * Song list to send.
     */
    private SongLibrary songLibrary;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSearchId ID of the search
     * @param paramSongLibrary Song list to send
     */
    public MessageSendSongList(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramSearchId, final SongLibrary paramSongLibrary) {
        super(paramType, paramIpSource, paramIpDest);
        searchId = paramSearchId;
        songLibrary = paramSongLibrary;
    }

    /**
     * .
     */
    @Override
    public void treatment() {
        WindowComponent.getInstance().getApiHmi().
                notifySongListBySearchId(
                        this.searchId,
                        this.songLibrary);
    }

    /**
     * Setter of the searchId attribute.
     * @param paramSearchId ID of the search
     */
    public void setSearchId(final String paramSearchId) {
        this.searchId = paramSearchId;
    }

    /**
     * Setter of the songLibrary attribute.
     * @param paramSongLibrary song list to send
     */
    public void setSongLibrary(final SongLibrary paramSongLibrary) {
        this.songLibrary = paramSongLibrary;
    }

    /**
     * Getter of the searchId attribute.
     * @return String ID of the search
     */
    public String getSearchId() {
        return searchId;
    }

    /**
     * Getter of the songLibrary attribute.
     * @return SongLibrary song list to send
     */
    public SongLibrary getSongLibrary() {
        return songLibrary;
    }

}
