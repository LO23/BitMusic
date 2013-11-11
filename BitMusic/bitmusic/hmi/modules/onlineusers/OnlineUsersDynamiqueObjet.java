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
public class OnlineUsersDynamiqueObjet extends AbstractTableModel {
    private ArrayList<User> users = new ArrayList<User>();
    private final String[] entetes = {"Login", "MdP"};

    public OnlineUsersDynamiqueObjet() {
        super();
        users.add(new User("User 1", "Test"));
        users.add(new User("User 2", "Test"));
    }

    public int getRowCount() {
        return users.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return users.get(rowIndex).getLogin();
            case 1:
                return users.get(rowIndex).getPassword();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addUser(User ami) {
        users.add(ami);

        fireTableRowsInserted(users.size() -1, users.size() -1);
    }

    public void removeUser(int rowIndex) {
        users.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void setListUsersOnline(ArrayList<User> users) {
        this.users = users;
    }
}
