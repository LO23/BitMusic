/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;

import bitmusic.music.api.ApiMusicImpl;
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
     * ID of the distant song we want.
     */
    private boolean temporary;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId Id of the user who own the mp3
     * @param paramSongId Id of the the song
     * @param paramTemporary is the file temporary
     * @param array Array of byte of mp3 file
     */
    public MessageSendSongFile(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final String paramSongId,
            final boolean paramTemporary, final byte[] array) {
        super(paramType, paramIpSource, paramIpDest);
        this.mp3Array = array;
        this.songId = paramSongId;
        this.userId = paramUserId;
        this.temporary = paramTemporary;
    }

    /**
     * .
     */
    @Override
    public final void treatment() {
        try {
            /*
             If temporary is set to false, it means the file should be read,
             if it is set to true, the file should be saved on the hard drive.
            */
            if (temporary) {
                //ask pathFile to Music API
            } else {
                // ask pathFile to HMI, should be a blocking method call
            }
            final String pathFile = "/tmp/" + this.userId + this.songId;
            final Path path = Paths.get(pathFile);
            //write byte into a file
            Files.write(path, this.mp3Array, null,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            if (temporary) {
                bitmusic.music.api.ApiMusicImpl.getInstance().
                        playSongFromStart(pathFile);
            }
        } catch (IOException e) {

        }
        
        //TODO qui je previent du téléchargement de la musique??
    }

     /**
     * Getter of the mp3 file array.
     * @return mp3Array Byte array of mp3 file
     */
    public final byte[] getMp3Array() {
        return mp3Array;
    }

    /**
     * Setter of the mp3Array attribute.
     * @param paramMp3Array data array containing the MP3 file
     */
    public final void setMp3Array(final byte[] paramMp3Array) {
        this.mp3Array = paramMp3Array;
    }

    /**
    * Getter of the songId attribute.
    * @return String ID of the distant Song
    */
    public final String getSongId() {
        return songId;
    }

    /**
    * Getter of the temporary attribute.
    * @return boolean is the file temporary
    */
    public final boolean isTemporary() {
        return this.temporary;
    }

    /**
     * Setter of the songId attribute.
     * @param paramSongId id of the song
     */
    public final void setSongId(final String paramSongId) {
        this.songId = paramSongId;
    }

    /**
     * Setter of the userId attribute.
     * @param paramUserId ID of the user who owns the song
     */
    public final void setUserId(final String paramUserId) {
        this.userId = paramUserId;
    }

    /**
     * Getter of the userId attribute.
     * @return String ID of the user who owns the song
     */
    public final String getUserId() {
        return this.userId;
    }


}
