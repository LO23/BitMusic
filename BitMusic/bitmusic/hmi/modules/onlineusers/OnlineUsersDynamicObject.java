/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.profile.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hebergui <hebergui.utc@gmail.com>
 */
public class OnlineUsersDynamicObject extends AbstractTableModel {
    private ArrayList<User> listUsers = new ArrayList<User>();
    private final String[] header = {"Login", "MdP"};

    public OnlineUsersDynamicObject() {
        super();
    }

    public int getRowCount() {
        return listUsers.size();
    }

    public int getColumnCount() {
        return header.length;
    }

    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listUsers.get(rowIndex).getLogin();
            case 1:
                return listUsers.get(rowIndex).getPassword();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addUser(User ami) {
        listUsers.add(ami);

        fireTableRowsInserted(listUsers.size() -1, listUsers.size() -1);
    }

    public void removeUser(int rowIndex) {
        listUsers.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void removeAllUsers() {
        for (int i=0; i<this.listUsers.size(); i++)
            this.removeUser(i);
    }

    public ArrayList<User> getUsers() {
        return this.listUsers;
    }

    public void setListUsersOnline(ArrayList<User> users) {
        this.removeAllUsers();
        this.listUsers = users;
    }
}
