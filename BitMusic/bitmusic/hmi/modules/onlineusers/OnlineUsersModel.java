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

    private OnlineUsersDynamicObject modeleTable = new OnlineUsersDynamicObject();

    public OnlineUsersModel() {
        super();
    }

    public class OnlineUsersDynamicObject extends AbstractTableModel {
        private String[] columnNames = { "Utilisateur", "Infos", "MP3" };
        private ArrayList<OnlineUserRow> listUsers = new ArrayList<>();

        public OnlineUsersDynamicObject() {
            super();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return listUsers.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            switch(col){
                case 0:
                    return listUsers.get(row).getUser().getLogin();
                case 1:
                    return listUsers.get(row).getInfosBtn();
                case 2:
                    return listUsers.get(row).getUserSongsBtn();
                default:
                    return null; // Ne devrait jamais arriver
            }
        }

        public void addUser(User user) {
            listUsers.add(new OnlineUserRow(user));
            fireTableRowsInserted(listUsers.size()-1, listUsers.size()-1);
        }

        public void removeUser(int rowIndex) {
            listUsers.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        public void removeAllUsers() {
            for (int i=0; i<this.listUsers.size(); i++)
                this.removeUser(i);
        }

        public ArrayList<OnlineUserRow> getListUsers() {
            return this.listUsers;
        }

        public void setListUsers(ArrayList<OnlineUserRow> users) {
            this.removeAllUsers();
            this.listUsers = users;
        }
    }

    public void addUser(User user) {
        this.modeleTable.addUser(user);
        this.notifyObservers("ADD_ONLINE_USER");
    }

    public void removeUser(String userId) {
        ArrayList<OnlineUserRow> listOnlineUsers = this.modeleTable.getListUsers();

        boolean userRemoved = false;
        for ( int i=0; i<listOnlineUsers.size(); i++) {
            if (listOnlineUsers.get(i).getUser().getUserId().equals(userId)) {
                listOnlineUsers.remove(i);
                userRemoved = true;
            }
        }

        if (userRemoved == true) {
            this.notifyObservers("REMOVE_ONLINE_USER");
        }
        else {
            System.out.println("--- Error: User doesn't exist");
        }
    }

    public ArrayList<OnlineUserRow> getListOnlineUsers() {
        return this.modeleTable.getListUsers();
    }

    public void setListUsersOnline(ArrayList<OnlineUserRow> listOnlineUsers) {
        this.modeleTable.setListUsers(listOnlineUsers);
        this.notifyObservers("SET_LIST_ONLINE_USERS");
    }

    public OnlineUsersDynamicObject getModeleTable() {
        return this.modeleTable;
    }

    public void setModeleTable(OnlineUsersDynamicObject modeleTable) {
        this.modeleTable = modeleTable;
    }

}
