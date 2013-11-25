/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.profile.classes.User;
import java.util.ArrayList;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersModel extends AbstractModel {

    private OnlineUsersTableModel modeleTable = new OnlineUsersTableModel();

    public OnlineUsersModel() {
        super();
    }

    public void addUser(User user) {
        this.modeleTable.addOnlineUser(user);
        this.notifyObservers("ONLINE_USER_ADDED");
    }

    public void removeUser(String userId) {
        ArrayList<User> onlineUsers = this.modeleTable.getOnlineUsers();
        for (int i = 0; i < onlineUsers.size(); i++) {
            if (onlineUsers.get(i).getUserId().equals(userId)) {
                onlineUsers.remove(i);
            }
        }
        this.notifyObservers("ONLINE_USER_REMOVED");
    }

    public ArrayList<User> getListOnlineUsers() {
        return this.modeleTable.getOnlineUsers();
    }

    public void setListUsersOnline(final ArrayList<User> userList) {
        this.modeleTable.setOnlineUsers(userList);
        this.notifyObservers("LIST_ONLINE_USERS_SET");
    }

    public OnlineUsersTableModel getModeleTable() {
        return this.modeleTable;
    }

    public void setModeleTable(final OnlineUsersTableModel modele) {
        this.modeleTable = modele;
    }

}
