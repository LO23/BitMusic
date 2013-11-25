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
    public void notifyNewConnection(final User lightUserLan) {
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().getModeleTable().addOnlineUser(lightUserLan);
    }

    @Override
    public void removeUserFromOnlineUsers(final String userId) {
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().getModeleTable().removeOnlineUser(userId);
    }

    @Override
    public void notifyLightProfile(final User user, final String searchId) {
        //TODO
    }

    @Override
    public void notifySongListByUserId(final String userId, final SongLibrary songList) {
        //TODO
    }

    @Override
    public void notifySongListBySearchId(final String searchId, final SongLibrary songList) {
        //TODO
    }

    @Override
    public void updateCommentNotification(final Song song, final String comment) {
        //TODO
    }

    @Override
    public void displayCategories() {
        // TODO
    }

    @Override
    public void addCategory(final String name, final boolean play, final Rights readInfos, final boolean comment, final boolean rate) {
        // TODO
    }

    @Override
    public void removeCategory() {
        // TODO
    }

    @Override
    public void searchSongsByUser(final String userId) {
        // TODO
    }

    @Override
    public void displayUser(final String userID) {
        // TODO
    }

    @Override
    public void importSong(final String path, final String title, final String artist, final String album, final ArrayList<String> tags, final Rights rights) {
        // TODO
    }

    @Override
    public boolean addComment(final Song song, final String comment) {
        return false;
        // TODO
    }

    @Override
    public void addUserToCategory(final User user, final Category category) {
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
    public void removeUserFromCategory(final User user, final Category category) {
        // TODO
    }

    @Override
    public void manageRightsForOneSong(final String songId, final Rights rights) {
        // TODO
    }

    @Override
    public void startSong(final SongPlayer player) {
        // TODO
    }

    @Override
    public void connectUser(final String login, final String mdp) {
        // TODO
    }

    @Override
    public void displaySongs(final String userId) {
        // TODO
    }

    @Override
    public void errorNotification(final String errorMessage) {
        // TODO
    }
}
