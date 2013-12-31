/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.music.business.SongPlayer;
import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import java.util.ArrayList;

/**
 *
 * @author hebergui <hebergui.utc@gmail.com>
 */
public interface ApiHmi {

    /**
    * Notify a new user connection to HMI
    *
    * @param lightUserLan   The light user profile
    */
    void notifyNewConnection(User lightUserLan);

    /**
    * Remove user from the online-users-frame of others users still online
    *
    * @param userId
    * @return void
    */
    void removeUserFromOnlineUsers(String userId);

    /**
    * Receive a user profile
    *
    * @param user       The user profile
    * @param searchId   String of the search ID
    * @return void
    */
    void notifyLightProfile(User user, String searchId);

    //NE DOIT PAS ETRE UTILISEE, JE NE SAIS PAS D'OU SORT CETTE METHODE
    //UTILISER notifySongListBySearchId !!
//    void notifySongListByUserId(String userId, SongLibrary songList);

    /**
    * Notify the HMI about the reception of a song list
    *
    * @param searchId	Research ID used by the HMI
    * @param songList	Song library containing songs
    * @return void
    */
    void notifySongListBySearchId(String searchId, SongLibrary songList);

    /**
    * Notify the HMI about the success of a comment add
    *
    * @param song	Song concerned by the comment
    * @param comment	Comment successfully added
    * @return void
    */
    void updateCommentNotification(Song song, String comment);

    // TODO : vérifier leur utilité pour les autres modules

    /**
     *
     */
        void displayCategories();

    /**
     *
     * @param name
     * @param play
     * @param readInfos
     * @param comment
     * @param rate
     */
    void addCategory(String name, boolean play, Rights readInfos, boolean comment, boolean rate);

    /**
     *
     */
    void removeCategory();

    /**
     *
     * @param userId
     */
    void searchSongsByUser(String userId);

    /**
     *
     * @param userID
     */
    void displayUser(String userID);

    /**
     *
     * @param path
     * @param title
     * @param artist
     * @param album
     * @param tags
     * @param rights
     */
    void importSong(String path, String title, String artist, String album, ArrayList<String> tags, Rights rights);

    /**
     *
     * @param song
     * @param comment
     * @return
     */
    boolean addComment(Song song, String comment);

    /**
     *
     * @param user
     * @param category
     */
    void addUserToCategory(User user, Category category);

    /**
     *
     */
    void logOut();

    /**
     *
     */
    void closeApp();

    /**
     *
     */
    void playRemoteSong();

    /**
     *
     * @param user
     * @param category
     */
    void removeUserFromCategory(User user, Category category);

    /**
     *
     * @param songId
     * @param rights
     */
    void manageRightsForOneSong(String songId, Rights rights);

    /**
     *
     * @param player
     */
    void startSong(SongPlayer player);

    /**
     *
     * @param login
     * @param mdp
     */
    void connectUser(String login, String mdp);

    /**
     *
     * @param userId
     */
    void displaySongs(String userId);

    /**
     *
     * @param moduleName
     * @param errorMessage
     */
    void errorNotification(String moduleName, String errorMessage);

    /**
     * This method updates the rates of a song in the network
     * @param song
     * @param
     * @return void
     */
    void updateRate(Song song, String userId);
}
