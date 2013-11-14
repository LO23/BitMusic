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

    private OnlineUsersDynamicObject modeleTable = new OnlineUsersDynamicObject();

    public OnlineUsersModel() {
        super();
    }

    public void addUser(User user) {
        ArrayList<User> listOnlineUsers = this.modeleTable.getUsers();

        listOnlineUsers.add(user);
        this.notifyObservers("ADD_ONLINE_USER");
    }

    public void removeUser(String userId) {
        ArrayList<User> listOnlineUsers = this.modeleTable.getUsers();

        boolean userRemoved = false;
        User tempUser;
        for ( int i=0; i<listOnlineUsers.size(); i++) {
            tempUser = listOnlineUsers.get(i).getContact(userId); // méthode de apiNetwork (getContact)
            if (listOnlineUsers.get(i).equals(tempUser)) {
                listOnlineUsers.remove(i);
                userRemoved = true;
            }
        }
        if (userRemoved ==false) {
            System.out.println("--- Error: User doesn't exist, or is not online");
        }
        this.notifyObservers("REMOVE_ONLINE_USER");
    }

    public ArrayList<User> getListOnlineUsers() {
        return this.modeleTable.getUsers();
    }

    public void setListUsersOnline(ArrayList<User> listOnlineUsers) {
        this.modeleTable.setListUsersOnline(listOnlineUsers);
    }

    public OnlineUsersDynamicObject getModeleTable() {
        return modeleTable;
    }

    public void setModeleTable(OnlineUsersDynamicObject modeleTable) {
        this.modeleTable = modeleTable;
    }

}
