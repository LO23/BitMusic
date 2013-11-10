/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.music.data.Song;
import bitmusic.music.data.Comment;

/**
 *
 * @author alexis
 */
public final class MessageAddComment extends AbstractMessage {

    /**
     * The song to comment.
     */
    private Song song;

    /**
     * The comment we want to add.
     */
    private Comment comment;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramSong The song we want to comment
     * @param paramComment The comment we want to add
     */
    public MessageAddComment(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final Song paramSong, final Comment paramComment) {
        super(paramType, paramIpSource, paramIpDest);
        this.song = paramSong;
        this.comment = paramComment;
    }

    /**
     * .
     */
    @Override
    public void treatment() {

    }

    /**
     * Setter for the song attribute.
     * @param paramSong The song wa want to comment
     */
    public void setSong(final Song paramSong) {
        this.song = paramSong;
    }

    /**
     * Setter for the comment attribute.
     * @param paramComment The comment we want to add
     */
    public void setComment(final Comment paramComment) {
        this.comment = paramComment;
    }

    /**
     * Getter for the song attribute.
     * @return Song The song we want to comment
     */
    public Song getSong() {
        return song;
    }

    /**
     * Getter for the comment attribute.
     * @return Comment The comment we want to add
     */
    public Comment getComment() {
        return comment;
    }
}
