/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author alexis
 */
public class MessageSendSongFile extends AbstractMessage {

    /**
     * Array of byte which contain mp3 file
     */
    private byte[] mp3Array;

     /**
     * ID of the distant song we want.
     */
    private String songId;

     /**
     * ID of the user that owns the song.
     */
    private String userId;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId Id of the user who own the mp3
     * @param paramSongId Id of the the song
     * @param array Array of byte of mp3 file
     */
    public MessageSendSongFile(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final String paramSongId,
            final byte[] array) {
        super(paramType, paramIpSource, paramIpDest);
        this.mp3Array = array;
        this.songId = paramSongId;
        this.userId = paramUserId;
    }

    /**
     * .
     */
    @Override
    public void treatment() {
        try {
            //TODO : quelle est le path à écrire
            final String pathFile = "/tmp/" + this.userId + this.songId;
            final Path path = Paths.get(pathFile);
            //write byte into a file
            Files.write(path, this.mp3Array, null,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {

        }

        //TODO qui je previent du téléchargement de la musique??
    }

     /**
     * Getter of the mp3 file array
     * @return mp3Array Byte array of mp3 file
     */
    public byte[] getMp3Array() {
        return mp3Array;
    }

    public void setMp3Array(byte[] paramMp3Array) {
        this.mp3Array = paramMp3Array;
    }

     /**
     * Getter of the songId attribute.
     * @return String ID of the distant Song
     */
    public String getSongId() {
        return songId;
    }

    public void setSongId(String paramSongId) {
        this.songId = paramSongId;
    }

    public void setUserId(String paramUserId) {
        this.userId = paramUserId;
    }

    public String getUserId() {
        return userId;
    }


}
