/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

/**
 * Message send to notify that we want a distant song file.
 * @author alexis
 */
public final class MessageGetSongFile extends AbstractMessage {
    /**
     * ID of the user that owns th song.
     */
    private String userId;

    /**
     * ID of the distant song we want.
     */
    private String songId;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId ID of the user that owns the song
     * @param paramSongId ID of the distant song
     */
    public MessageGetSongFile(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final String paramSongId) {
        super(paramType, paramIpSource, paramIpDest);
        userId = paramUserId;
        songId = paramSongId;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }

    /**
     * Setter of the userId attribute.
     * @param paramUserId ID of the user that owns the song
     */
    public void setUserId(final String paramUserId) {
        this.userId = paramUserId;
    }

    /**
     * Setter of the song attribute.
     * @param paramSongId ID of the distant song
     */
    public void setSongId(final String paramSongId) {
        this.songId = paramSongId;
    }

    /**
     * Getter of the userId attribute.
     * @return String ID of the user that owns the song.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Getter of the songId attribute.
     * @return String ID of the distant Song
     */
    public String getSongId() {
        return songId;
    }

}
