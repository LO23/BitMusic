/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.modules.tab.TabController;
import bitmusic.hmi.modules.tab.TabModel;
import bitmusic.hmi.popup.informationssong.InfosSongPopUpComponent;
import bitmusic.music.business.SongPlayer;
import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author IHM
 */
public final class ApiHmiImpl implements ApiHmi {
    /**
     * Notifies a new connection
     * @param lightUserLan
     */
    @Override
    public void notifyNewConnection(final User lightUserLan) {
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().getModeleTable().addOnlineUser(lightUserLan);
    }
    /**
     * Removes user from the online users list
     * @param userId
     */
    @Override
    public void removeUserFromOnlineUsers(final String userId) {
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().getModeleTable().removeOnlineUser(userId);
    }

    @Override
    public void notifyLightProfile(final User user, final String searchId) {
        //TODO
    }

    //NE DOIT PAS ETRE UTILISEE, JE NE SAIS PAS D'OU SORT CETTE METHODE
    //UTILISER notifySongListBySearchId !!
//    @Override
//    public void notifySongListByUserId(final String userId, final SongLibrary songList) {
//        //TODO
//    }
    /**
     * Searches a song
     * @param searchId
     * @param songList
     */
    @Override
    public void notifySongListBySearchId(final String searchId, final SongLibrary songList) {
        CentralAreaComponent cac = WindowComponent.getInstance().getCentralAreaComponent();
        //Grace au searchId on va prendre le tab correspondant à la recherche (searchId = tabId !)
        TabComponent tabComponent = cac.getView().getTabComponent(Integer.parseInt(searchId));
        //On ajoute au tab les musiques
        // Deux solutions :

        //1. Si l'on considère que le réseau nous envoie un seul notifySongListBySearchId pour un même searchId
        // C'est à dire qu'il a récupéré TOUS les musiques qui correspondent et nous les envoie une fois
//        tabComponent.getModel().getModeleTable().setSong(songList.getlibrary());

        //2. Si l'on considère que le réseau nous envoie les musiques petit peu par petit peu,
        // c'est à cire au fil des réponses qu'il reçoit...
        tabComponent.getModel().getModeleTable().addSongs(songList.getlibrary());
    }

    @Override
    public void updateCommentNotification(final Song song, final String comment) {
        //TODO
    }

    /**
     *
     */
    @Override
    public void displayCategories() {
        // TODO
    }

    /**
     *
     * @param name
     * @param play
     * @param readInfos
     * @param comment
     * @param rate
     */
    @Override
    public void addCategory(final String name, final boolean play, final Rights readInfos, final boolean comment, final boolean rate) {
        // TODO
    }

    /**
     *
     */
    @Override
    public void removeCategory() {
        // TODO
    }

    /**
     *
     * @param userId
     */
    @Override
    public void searchSongsByUser(final String userId) {
        // TODO
    }

    /**
     *
     * @param userID
     */
    @Override
    public void displayUser(final String userID) {
        // TODO
    }

    /**
     *
     * @param path
     * @param title
     * @param artist
     * @param album
     * @param tags
     * @param rights
     */
    @Override
    public void importSong(final String path, final String title, final String artist, final String album, final ArrayList<String> tags, final Rights rights) {
        // TODO
    }

    /**
     *
     * @param song
     * @param comment
     * @return
     */
    @Override
    public boolean addComment(final Song song, final String comment) {
        return false;
        // TODO
    }

    /**
     *
     * @param user
     * @param category
     */
    @Override
    public void addUserToCategory(final User user, final Category category) {
        // TODO
    }

    /**
     *
     */
    @Override
    public void logOut() {
        // TODO
    }

    /**
     *
     */
    @Override
    public void closeApp() {
        // TODO
    }

    /**
     *
     */
    @Override
    public void playRemoteSong() {
        // TODO
    }

    /**
     *
     * @param user
     * @param category
     */
    @Override
    public void removeUserFromCategory(final User user, final Category category) {
        // TODO
    }

    /**
     *
     * @param songId
     * @param rights
     */
    @Override
    public void manageRightsForOneSong(final String songId, final Rights rights) {
        // TODO
    }

    /**
     *
     * @param player
     */
    @Override
    public void startSong(final SongPlayer player) {
        // TODO
    }

    /**
     *
     * @param login
     * @param mdp
     */
    @Override
    public void connectUser(final String login, final String mdp) {
        // TODO
    }

    /**
     *
     * @param userId
     */
    @Override
    public void displaySongs(final String userId) {
        // TODO
    }

    /**
     *
     * @param moduleName
     * @param errorMessage
     */
    @Override
    public void errorNotification(final String moduleName, final String errorMessage) {
        JOptionPane.showMessageDialog(
                         null,
                         errorMessage,
                         "Erreur de " + moduleName,
                         JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Updates the rate song component of a song in the network : distant user
     * @param song
     * @param userId
     */
    @Override
    public void updateRate(Song song, String userId) {
        // call updateRateLabel
        WindowComponent win = WindowComponent.getInstance();
        ArrayList<TabComponent> listTabComponent = win.getCentralAreaComponent().getView().getListTabComponent();
        //InfosSongPopUpComponent infosSongPopUpComponent = new InfosSongPopUpComponent(song, win.getCentralAreaComponent().getView().getListTabComponent().ge.getView().getTabId());
        for (TabComponent t : listTabComponent) {
                for (int row = 0; row< t.getModel().getModeleTable().getRowCount(); row++) {
                    if(t.getModel().getModeleTable().getSongAt(row).equals(song)) {
                        // ici on souhaite mettre à jour directement la pop infosSong concernee
                        InfosSongPopUpComponent infosSongPopUpComponent = new InfosSongPopUpComponent(song, t.getView().getTabId());
                        infosSongPopUpComponent.getView().update(infosSongPopUpComponent.getModel(), userId);
                }
            }
        }
        // TODO :

    }
}
