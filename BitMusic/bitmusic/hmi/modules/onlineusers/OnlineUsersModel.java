/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.profile.classes.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersModel extends AbstractModel {

    private OnlineUsersTableModel modeleTable = new OnlineUsersTableModel();

    public OnlineUsersModel() {
        super();
    }

    public class OnlineUsersTableModel extends AbstractTableModel {
        private String[] columnNames = { "Utilisateur", "Infos", "MP3" };
        private ArrayList<User> onlineUsers = new ArrayList<>();

        public OnlineUsersTableModel() {
            super();
        }

        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0:
                    return this.onlineUsers.get(row).getLogin();
                case 1:
                    return "i";
                case 2:
                    return "MP3";
                default:
                    return null;
            }
        }

        public User getUserAt(int row) {
            return this.onlineUsers.get(row);
        }

        public void addOnlineUser(final User user) {
            this.onlineUsers.add(user);
            fireTableRowsInserted(this.onlineUsers.size()-1, this.onlineUsers.size()-1);
            (OnlineUsersModel.this).notifyObservers("ONLINE_USER_ADDED");
        }

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

        public String[] getColumnNames() {
            return this.columnNames;
        }

        public void setColumnNames(String[] stringTable) {
            this.columnNames = stringTable;
        }

        public ArrayList<User> getOnlineUsers() {
            return this.onlineUsers;
        }

        public void setOnlineUsers(ArrayList<User> userList) {
            this.onlineUsers = userList;
            (OnlineUsersModel.this).notifyObservers("LIST_ONLINE_USERS_SET");
        }
    }

    public OnlineUsersTableModel getModeleTable() {
        return this.modeleTable;
    }

    public void setModeleTable(final OnlineUsersTableModel modele) {
        this.modeleTable = modele;
    }

}
