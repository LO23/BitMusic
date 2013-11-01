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
    private static MessageFactory instance = null;
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
         if (MessageFactory.instance == null) {
            MessageFactory.instance = new MessageFactory();
         }
         return MessageFactory.instance;
     }
    /**
     * Function provided to easily create different kind of messages.
     * @param type : Type of the message we want.
     * @return The newly created message.
     */
    public static AbstractMessage createMessage(final EnumTypeMessage type/*,
    passage d'un objet sérialisé contenant les arguments ?*/) {
        switch (type) {
            case AddComment :
                return new MessageAddComment();
            case ErrorNotification :
                return new MessageErrorNotification();
            case GetSongFile :
                return new MessageGetSongFile();
            case GetSongsByUser :
                return new MessageGetSongsByUser();
            case GetUser :
                return new MessageGetUser();
            case LogOut :
                return new MessageLogOut();
            case NotifyNewConnection :
                return new MessageNotifyNewConnection();
            case ReplyConnectionUser :
                return new MessageReplyConnectionUser();
            case SearchSongsByTag :
                return new MessageSearchSongsByTag();
            case SendSongList :
                return new MessageSendSongList();
            case SendUser :
                return new MessageSendUser();
            case SendSongFile :
                return new MessageSendSongFile();
            case TagRequest :
                return new MessageTagRequest();
            case UpdateCommentNotification :
                return new MessageUpdateCommentNotification();
            default :
                return null;
        }
    }
}
