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

    private ArrayList<User> listUsersOnline = new ArrayList<>();


    public OnlineUsersModel() {
        super();
    }

    public void addUser(User user) {
        this.listUsersOnline.add(user);
        this.notifyObservers("ADD_ONLINE_USER");
    }

    public void removeUser(String userId) {
        boolean userRemoved = false;
        User tempUser;
        for ( int i=0; i<listUsersOnline.size(); i++) {
            tempUser = this.listUsersOnline.get(i).getContact(userId); // méthode de apiNetwork (getContact)
            if (this.listUsersOnline.get(i).equals(tempUser)) {
                this.listUsersOnline.remove(i);
                userRemoved = true;
            }
        }
        if (userRemoved ==false) {
            System.out.println("--- Error: User doesn't exist, or is not online");
        }
        this.notifyObservers("REMOVE_ONLINE_USER");
    }

    public ArrayList<User> getListUsersOnline() {
        return listUsersOnline;
    }

    public void setListUsersOnline(ArrayList<User> listUsersOnline) {
        this.listUsersOnline = listUsersOnline;
    }

}
