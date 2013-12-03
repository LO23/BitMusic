/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.music.data.Song;
import bitmusic.music.data.Comment;

/**
 * Message used to notify that
 * a comment was successfully added on a distant song.
 * @author alexis
 */
public final class MessageUpdateCommentNotification extends AbstractMessage {
    /**
     * ID of the user that wanted to add the comment.
     */
    private String userId;

    /**
     * Song on which we've added a comment.
     */
    private Song song;

    /**
     * Comment we've just added.
     */
    private Comment comment;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId ID of the user that wanted to add a comment
     * @param paramSong Song on whiwh we've added a comment
     * @param paramComment Comment we've just added
     */
    public MessageUpdateCommentNotification(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final Song paramSong,
            final Comment paramComment) {
        super(paramType, paramIpSource, paramIpDest);
        userId = paramUserId;
        song = paramSong;
        comment = paramComment;
    }

    /**
     * .
     */
    @Override
    public void treatment() {
        WindowComponent.getInstance().getApiHmi().updateCommentNotification(
            this.song, this.comment);
    }

    /**
     * Setter of the userId attribute.
     * @param paramUserId ID of the user that wanted to add a comment
     */
    public void setUserId(final String paramUserId) {
        this.userId = paramUserId;
    }

    /**
     * Setter of the song attribute.
     * @param paramSong Song on whiwh we've added a comment
     */
    public void setSong(final Song paramSong) {
        this.song = paramSong;
    }

    /**
     * Setter of the comment attribute.
     * @param paramComment Comment we've just added
     */
    public void setComment(final Comment paramComment) {
        this.comment = paramComment;
    }

    /**
     * Getter of the userId attribute.
     * @return String ID of the user that wanted to add a comment
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Getter of the song attribute.
     * @return Song The song on which we've just added a comment
     */
    public Song getSong() {
        return song;
    }

    /**
     * Getter of the comment attribute.
     * @return Comment The comment we've just added
     */
    public Comment getComment() {
        return comment;
    }


}
