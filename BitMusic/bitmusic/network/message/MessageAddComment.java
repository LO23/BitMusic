/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.message;
import bitmusic.music.data.Song;
import bitmusic.music.data.Comment;
import bitmusic.network.main.Controller;
import bitmusic.profile.api.ApiProfileImpl;
import java.util.Map;

/**
 * Message used to send a comment on a specific song.
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
     * ID of the user that wanted to add the comment.
     */
    private String userId;

    /**
     * Constructor.
     * @param paramType Type of the message
     * @param paramIpSource IP address of the sender
     * @param paramIpDest IP address of the receiver
     * @param paramUserId Id of the user who comments
     * @param paramSong The song we want to comment
     * @param paramComment The comment we want to add
     */
    public MessageAddComment(final EnumTypeMessage paramType,
            final String paramIpSource, final String paramIpDest,
            final String paramUserId, final Song paramSong,
            final Comment paramComment) {
        super(paramType, paramIpSource, paramIpDest);
        this.song = paramSong;
        this.comment = paramComment;
        this.userId = paramUserId;
    }

    /**
     * .
     */
    @Override
    public void treatment() {
        final boolean right = true;//a supprimer quand api sera ompl
       // boolean right = ApiMusicImpl..addCommentFromNetwork(
         //       this.song.getSongId(), this.comment);

        if(right == true){
            //Loop on the directory
            final Map<String, String> userDirectory =
                    Controller.getInstance().getDirectory();
            for (Map.Entry<String, String> entry : userDirectory.entrySet()) {

                //construct a message
                final AbstractMessage message =
                        new MessageUpdateCommentNotification(
                            //type of message
                            EnumTypeMessage.UpdateCommentNotification,
                            //ip source
                            Controller.getInstance().getNetworkAddress(),
                            //ip dest
                            entry.getValue(),
                            //userID (who comment)
                            this.userId,
                            //songId
                            this.song,
                            //comment add
                            this.comment);
                //send update to all the user

                Controller.getInstance().getThreadManager()
                        .assignTaskToHermes(message);
            }
        } else {
            final AbstractMessage message = new MessageErrorNotification(
                    //type of message
                    EnumTypeMessage.ErrorNotification,
                    //ip source
                    Controller.getInstance().getNetworkAddress(),
                    //ip dest
                    this.ipSource,
                    //userID (who comment)
                    this.userId,
                    //songId
                    this.song,
                    //comment add
                    this.comment,
                    //Message erreur
                    "You don't have the right to comment this song");
            Controller.getInstance().getThreadManager()
                    .assignTaskToHermes(message);
            }
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
