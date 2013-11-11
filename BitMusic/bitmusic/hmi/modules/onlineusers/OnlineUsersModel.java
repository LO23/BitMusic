/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.profile.User;
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
    }

    public ArrayList<User> getListUsersOnline() {
        return listUsersOnline;
    }

    public void setListUsersOnline(ArrayList<User> listUsersOnline) {
        this.listUsersOnline = listUsersOnline;
    }

    @Override
    public void removeObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(Object o, String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
