/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.network.main.Controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Message send to notify that we want a distant song file.
 * @author alexis
 */
public final class MessageGetSongFile extends AbstractMessage {
    /**
     * ID of the user that owns the song.
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
     * Create a new message to transfert a song
     */
    @Override
    public void treatment() {
        //String path = ApiProfileImpl.getApiProfile().getSongFile(this.userId, this.songId);
        final String pathFile = null;
        final Path path = Paths.get(pathFile);
        try {
           final byte[] mp3Array = Files.readAllBytes(path);

            final MessageSendSongFile message = new MessageSendSongFile(
                    //type of message
                    EnumTypeMessage.SendSongFile,
                    //ipSource
                    Controller.getNetworkAddress(),
                    //ipDest
                    this.ipSource,
                    //user id mp3 owner
                    this.userId,
                    //song id
                    this.songId,
                    //Mp3 file into a byte array
                    mp3Array);

            Controller.getInstance().getThreadManager().
                    assignTaskToHermes(message);
        } catch (IOException e) {

        }
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
