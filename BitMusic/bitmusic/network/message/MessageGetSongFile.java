/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.music.api.ApiMusicImpl;
import bitmusic.network.main.Controller;
import bitmusic.profile.api.ApiProfileImpl;
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
     * Is the file temporary or should it be kept on disc?
     */
    private boolean temporary;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId ID of the user that owns the song
     * @param paramSongId ID of the distant song
     * @param paramTemporary will the song be downloaded as temporary
     */
    public MessageGetSongFile(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final String paramSongId,
            final boolean paramTemporary) {
        super(paramType, paramIpSource, paramIpDest);
        userId = paramUserId;
        songId = paramSongId;
        temporary = paramTemporary;
    }

    /**
     * Create a new message to transfer a song.
     */
    @Override
    public void treatment() {
        final String pathFile = ApiMusicImpl.getInstance().
                getSongFile(this.songId);
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
                    ApiProfileImpl.getApiProfile().getCurrentUser().getUserId(),
                    //song id
                    this.songId,
                    //temporary file
                    this.temporary,
                    //Mp3 file into a byte array
                    mp3Array);

            Controller.getInstance().getThreadManager().
                    assignTaskToHermes(message);
        } catch (IOException e) {
            WindowComponent.getInstance().getApiHmi()
                    .errorNotification("Network", e.getMessage());
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
     * Setter of the temporary attribute.
     * @param paramTemporary is the file temporary
     */
    public void setTemporary(final boolean paramTemporary) {
        this.temporary = paramTemporary;
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

    /**
     * Getter of the temporary attribute.
     * @return boolean is the file temporary
     */
    public boolean isTemporary() {
        return temporary;
    }
}
