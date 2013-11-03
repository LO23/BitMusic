/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package network.message;

/**
 * Énumération des types possibles de Message.
 * @author alexis
 */
public enum EnumTypeMessage {
    /**
     * Send a comment about a song
     * Receive a comment about one of our song.
     */
    AddComment,
    /**
     * A network message to tell a distant application
     * that an error occurred and the comment sent was not recorded.
     */
    ErrorNotification,
    /**
     * Network message send to / received from a distant user
     * to ask for a song download/upload.
     */
    GetSongFile,
    /**
     * Network message send to / received from a distant user
     * to ask for a song download/upload.
     */
    GetSongsByUser,
    /**
     * Network message send to a distant user to ask him to send his songList.
     */
    GetUser,
    /**
     * Notify a distant user that we are logging out
.     */
    LogOut,
    /**
     * Notify distant users that we are logging in.
     */
    NotifyNewConnection,
    /**
     * Reply to a newly connected user with our own profile.
     */
    ReplyConnectionUser,
    /**
     * Network message send to / receive from a distant user
     * to ask for songs with specific tags.
     */
    SearchSongsByTag,
    /**
     * Network message send to / received from a distant user in response of
     * a TagRequestMessage or GetSongsMessage.
     */
    SendSongList,
    /**
     * Network message send to / received from a distant user
     * to ask for his song list.
     */
    SendUser,
    /**
     * Network message send to / received from a distant user
     * to download/upload a song.
     */
    SendSongFile,
    /**
     * Network message send to a distant user
     * to ask him to search items matching the keywords.
     */
    TagRequest,
    /**
     * A network message to tell a distant application
     * that the comment sent was successfully recorded.
     */
    UpdateCommentNotification;
}
