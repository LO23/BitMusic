/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.music.data.Song;
import bitmusic.music.data.Comment;

/**
 * Message used to notify to a sender
 * that the receiver failed to add his comment.
 * @author alexis
 */
public final class MessageErrorNotification extends AbstractMessage {

    /**
     * The user we want to warn.
     */
    private String userId;

    /**
     * The song we wanted to comment.
     */
    private Song song;

    /**
     * The comment we wanted to add.
     */
    private Comment comment;

    /**
     * The description of the error.
     */
    private String errorMessage;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId ID of the user that wanted to comment a song
     * @param paramSong The song we wanted to comment
     * @param paramComment The comment we wanted to add
     * @param paramErrorMessage Description of the error
     */
    public MessageErrorNotification(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final Song paramSong,
            final Comment paramComment, final String paramErrorMessage) {
        super(paramType, paramIpSource, paramIpDest);
        userId = paramUserId;
        song = paramSong;
        comment = paramComment;
        errorMessage = paramErrorMessage;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }

    /**
     * Setter of the userId attribute.
     * @param paramUserId ID of the user that wanted to comment a song
     */
    public void setUserId(final String paramUserId) {
        this.userId = paramUserId;
    }

    /**
     * Setter of the song attribute.
     * @param paramSong The song we wanted to comment
     */
    public void setSong(final Song paramSong) {
        this.song = paramSong;
    }

    /**
     * Setter of the comment attribute.
        * @param paramComment The comment we wanted to add
     */
    public void setComment(final Comment paramComment) {
        this.comment = paramComment;
    }

    /**
     * Setter of the errorMessage attribute.
     * @param paramErrorMessage Description of the error
     */
    public void setErrorMessage(final String paramErrorMessage) {
        this.errorMessage = paramErrorMessage;
    }

    /**
     * Getter of the userId atttribute.
     * @return String ID of the user that wanted to comment a song
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Getter of the song atttribute.
     * @return Song The song we wanted to comment
     */
    public Song getSong() {
        return song;
    }

    /**
     * Getter of the comment atttribute.
     * @return Comment The comment we wanted to add
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Getter of the errorMessage atttribute.
     * @return String Description of the error
     */
    public String getErrorMessage() {
        return errorMessage;
    }


}
