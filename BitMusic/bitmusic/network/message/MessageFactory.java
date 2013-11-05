/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.message;

/**
 * Class that implements the factory design pattern,
 * which will provide an easy way to create
 * different kind of messages.
 * @author florian, alexis
 */
public final class MessageFactory {
    /**
     * The only instance of the MessageFactory class.
     */
    private static MessageFactory INSTANCE = null;
    /**
     * The object constructor.
     */
    private MessageFactory() {
        super();
    }
    /**
     * The method that returns the instance of the class.
     * @return The only instance of the MessageFactory class.
     */
    public static MessageFactory getInstance() {
         if (MessageFactory.INSTANCE == null) {
            MessageFactory.INSTANCE = new MessageFactory();
         }
         return MessageFactory.INSTANCE;
     }
    /**
     * Function provided to easily create different kind of messages.
     * @param type : Type of the message we want.
     * @return The newly created message.
     */
    public static AbstractMessage createMessage(final EnumTypeMessage type/*,
    passage d'un objet sérialisé contenant les arguments ?*/) {
        AbstractMessage message = null;
        switch (type) {
            case AddComment :
                message =  new MessageAddComment();
                break;
            case ErrorNotification :
                message = new MessageErrorNotification();
                break;
            case GetSongFile :
                message = new MessageGetSongFile();
                break;
            case GetSongsByUser :
                message = new MessageGetSongsByUser();
                break;
            case GetUser :
                message = new MessageGetUser();
                break;
            case LogOut :
                message = new MessageLogOut();
                break;
            case NotifyNewConnection :
                message = new MessageNotifyNewConnection();
                break;
            case ReplyConnectionUser :
                message = new MessageReplyConnectionUser();
                break;
            case SearchSongsByTag :
                message = new MessageSearchSongsByTag();
                break;
            case SendSongList :
                message = new MessageSendSongList();
                break;
            case SendUser :
                message = new MessageSendUser();
                break;
            case SendSongFile :
                message = new MessageSendSongFile();
                break;
            case TagRequest :
                message = new MessageTagRequest();
                break;
            case UpdateCommentNotification :
                message = new MessageUpdateCommentNotification();
                break;
            default :
                break;
        }
        return message;
    }
}
