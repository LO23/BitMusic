/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.onlineusers;

import bitmusic.profile.classes.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
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

    public void addOnlineUser(User user) {
        this.onlineUsers.add(user);
        fireTableRowsInserted(this.onlineUsers.size()-1, this.onlineUsers.size()-1);
    }

    public void removeOnlineUser(int row) {
        this.onlineUsers.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void removeAllOnlineUsers() {
        for (int i=0; i<this.onlineUsers.size(); i++) {
            this.removeOnlineUser(i);
        }
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

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 1 || col == 2) {
            return true;
        }
        return false;
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
    }
}
