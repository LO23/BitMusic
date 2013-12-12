/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;
import bitmusic.profile.classes.User;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersModel extends AbstractModel {

    private OnlineUsersTableModel modeleTable = new OnlineUsersTableModel();

    /**
     *
     */
    public OnlineUsersModel() {
        super();
    }

    /**
     *
     */
    public class OnlineUsersTableModel extends AbstractTableModel {
        private String[] columnNames = { "Utilisateur", "Infos", "Sons" };
        private ArrayList<User> onlineUsers = new ArrayList();

        /**
         *
         */
        public OnlineUsersTableModel() {
            super();
        }

        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return this.onlineUsers.get(row).getLogin();
                case 1:
                    return "I";
                case 2:
                    return "M";
                default:
                    return null;
            }
        }

        /**
         *
         * @param row
         * @return
         */
        public User getUserAt(int row) {
            return this.onlineUsers.get(row);
        }

        /**
         *
         * @param user
         */
        public void addOnlineUser(final User user) {
            this.onlineUsers.add(user);
            fireTableRowsInserted(this.onlineUsers.size()-1, this.onlineUsers.size()-1);
            (OnlineUsersModel.this).notifyObservers("ONLINE_USER_ADDED");
        }

        /**
         *
         * @param userId
         */
        public void removeOnlineUser(final String userId) {
            for (int row = 0; row < this.onlineUsers.size(); row++) {
                if (this.onlineUsers.get(row).getUserId().equals(userId)) {
                    this.onlineUsers.remove(row);
                    fireTableRowsDeleted(row, row);
                }
            }
            (OnlineUsersModel.this).notifyObservers("ONLINE_USER_REMOVED");
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 1 || col == 2) {
                return true;
            }
            return false;
        }

        @Override
        public int getColumnCount() {
            return this.columnNames.length;
        }

        @Override
        public int getRowCount() {
            return this.onlineUsers.size();
        }

        @Override
        public String getColumnName(int col) {
            return this.columnNames[col];
        }

        /**
         *
         * @return
         */
        public String[] getColumnNames() {
            return this.columnNames;
        }

        /**
         *
         * @param stringTable
         */
        public void setColumnNames(String[] stringTable) {
            this.columnNames = stringTable;
        }

        /**
         *
         * @return
         */
        public ArrayList<User> getOnlineUsers() {
            return this.onlineUsers;
        }

        /**
         *
         * @param userList
         */
        public void setOnlineUsers(ArrayList<User> userList) {
            this.onlineUsers = userList;
            (OnlineUsersModel.this).notifyObservers("LIST_ONLINE_USERS_SET");
        }
    }

    /**
     *
     * @return
     */
    public OnlineUsersTableModel getModeleTable() {
        return this.modeleTable;
    }

    /**
     *
     * @param modele
     */
    public void setModeleTable(final OnlineUsersTableModel modele) {
        this.modeleTable = modele;
    }

    /**
     *
     * @param searchId
     * @param userId
     */
    public void searchSongsFromUserId(final String searchId, final String userId) {
        // Vérifier si c'est bon
        WindowComponent win = WindowComponent.getInstance();
        win.getApiMusic().searchSongsByUser(userId, searchId); // searchId semble nécessaire ? (void retourné)
    }

    //METHODE POUR LES TESTS

    /**
     *
     * @param seachId
     * @param userId
     * @return
     */
        //public ArrayList<Song> searchSongsFromUserId2(final String seachId, final String userId) {
        // --------------- À supprimer dès que possible (pour le test) ------------------
       // ArrayList<Song> songResults = new ArrayList();
        //songResults.add(new Song("1", "Title1", "Author1", "USER - " + userId, new LinkedList()));
        //songResults.add(new Song("2", "Title2", "Author2", "USER - " + userId, new LinkedList()));
        // ------------------------------------------------------------------------------
        //return songResults;
   // }
}
