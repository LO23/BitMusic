/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.modules.onlineusers.OnlineUsersModel;
import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;
import bitmusic.profile.classes.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
public final class TabModel extends AbstractModel {

    private TabTableModel modeleTable = new TabTableModel();
    public TabModel() {
        super();
    }

    public class TabTableModel extends AbstractTableModel {
        private String[] columnNames = { "Titre","Artiste","Album","Edit", "Infos","Note","Sauvergarder" };
        private ArrayList<Song> arrayListSong = new ArrayList<>();

        public TabTableModel() {
            super();
        }

        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return this.arrayListSong.get(row).getTitle();
                case 1:
                    return this.arrayListSong.get(row).getArtist();
                case 2:
                    return this.arrayListSong.get(row).getAlbum();
                case 3:
                    return "Edit";
                case 4:
                    return "Infos";
                case 5:
                    return "Note";
                case 6:
                    return "Sauvegarder";
                default:
                    return null;
            }
        }

        public Song getSongsAt(int row) {
            return this.arrayListSong.get(row);
        }

//        public void addOnlineUser(final User user) {
//            this.onlineUsers.add(user);
//            fireTableRowsInserted(this.onlineUsers.size()-1, this.onlineUsers.size()-1);
//            (TabModel.this).notifyObservers("ONLINE_USER_ADDED");
//        }
//
//        public void removeOnlineUser(final String userId) {
//            for (int row = 0; row < this.onlineUsers.size(); row++) {
//                if (this.onlineUsers.get(row).getUserId().equals(userId)) {
//                    this.onlineUsers.remove(row);
//                    fireTableRowsDeleted(row, row);
//                }
//            }
//            (TabModel.this).notifyObservers("ONLINE_USER_REMOVED");
//        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 1 || col == 2 || col == 3) {
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
            return this.arrayListSong.size();
        }

        @Override
        public String getColumnName(int col) {
            return this.columnNames[col];
        }

        public String[] getColumnNames() {
            return this.columnNames;
        }

        public void setColumnNames(String[] stringTable) {
            this.columnNames = stringTable;
        }

        public ArrayList<Song> getSongs() {
            return this.arrayListSong;
        }

        public void setSong(ArrayList<Song> songList) {
            this.arrayListSong = songList;
            (TabModel.this).notifyObservers("LIST_SONGS_SET");
        }
    }

    public TabTableModel getModeleTable() {
        return this.modeleTable;
    }
}
