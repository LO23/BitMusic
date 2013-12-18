/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.music.data.Song;

/**
 * Message to notify that a song have been ranked.
 * @author alexis
 */
public final class MessageRateSong extends AbstractMessage {
    /**
     * The newly ranked song.
     */
    private Song song;

    /**
     * ID of the user that rates the song.
     */
    private String userId;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSong The newly ranked song
     * @param paramUserId ID of the user that rates the song
     */
    public MessageRateSong(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final Song paramSong, final String paramUserId) {
        super(paramType, paramIpSource, paramIpDest);
        song = paramSong;
        userId = paramUserId;
    }

    /**
     * Method that implements the treatment of the message.
     */
    @Override
    public void treatment() {
        //mise à jour de la note sur l'IHM
        WindowComponent.getInstance().getApiHmi().updateRate(song, userId);
   }

    /**
     * Setter of song attribute.
     * @param paramSong The unewly ranked song
     */
    public void setSong(final Song paramSong) {
        this.song = paramSong;
    }

    /**
     * Getter of song attribute.
     * @return Song The unewly ranked song
     */
    public Song getSong() {
        return song;
    }

    /**
     * Setter of userId attribute.
     * @param paramUserId ID of the user that rates the song
     */
    public void setUserId(final String paramUserId) {
        this.userId = paramUserId;
    }

    /**
     * Getter of userId attribute.
     * @return String ID of the user that rates the song
     */
    public String getUserId() {
        return userId;
    }
}
