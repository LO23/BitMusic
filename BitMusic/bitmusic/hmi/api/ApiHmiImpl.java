/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.music.business.SongPlayer;
import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import java.util.ArrayList;

/**
 *
 * @author unkedeuxke
 */
public final class ApiHmiImpl implements ApiHmi {

    @Override
    public void notifyNewConnection(User lightUserLan){
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().addUser(lightUserLan);
    }

    @Override
    public void removeUserFromOnlineUsers(String userId) {
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().removeUser(userId);
    }

    @Override
    public void notifyLightProfile(User user, String searchId) {
        //TODO
    }

    @Override
    public void notifySongListByUserId(String userId, SongLibrary songList) {
        //TODO
    }

    @Override
    public void notifySongListBySearchId(String searchId, SongLibrary songList) {
        //TODO
    }

    @Override
    public void displayCategories() {
        // TODO
    }

    /*@Override
    public void addCategory(String name, boolean play, readInfos, boolean comment, boolean rate) {
        // TODO
    }*/

    @Override
    public void removeCategory() {
        // TODO
    }

    @Override
    public void searchSongsByUser(String userId) {
        // TODO
    }

    @Override
    public void displayUser(String userID) {
        // TODO
    }

    @Override
    public void importSong(String path, String title, String artist, String album, ArrayList<String> tags, Rights rights) {
        // TODO
    }

    @Override
    public boolean addComment(Song song, String comment) {
        return false;
        // TODO
    }

    @Override
    public void addUserToCategory(User user, Category category) {
        // TODO
    }

    @Override
    public void logOut() {
        // TODO
    }

    @Override
    public void closeApp() {
        // TODO
    }

    @Override
    public void playRemoteSong() {
        // TODO
    }

    @Override
    public void removeUserFromCategory(User user, Category category) {
        // TODO
    }

    @Override
    public void manageRightsForOneSong(String songId, Rights rights) {
        // TODO
    }

    @Override
    public void startSong(SongPlayer player) {
        // TODO
    }

    @Override
    public void connectUser(String login, String mdp) {
        // TODO
    }

    @Override
    public void displaySongs(String userId) {
        // TODO
    }

    @Override
    public void errorNotification(String errorMessage) {
        // TODO
    }
}
