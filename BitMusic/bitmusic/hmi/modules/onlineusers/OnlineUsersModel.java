/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.hmi.patterns.DynamicObject;
import bitmusic.profile.classes.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersModel extends AbstractModel {

    private OnlineUsersDynamicObject modeleTable = new OnlineUsersDynamicObject(Arrays.asList("Login", "Infos", "MP3"));

    public OnlineUsersModel() {
        super();
    }

    public class OnlineUsersDynamicObject extends DynamicObject<OnlineUserRow> {
        public OnlineUsersDynamicObject(List<String> columnNames) {
            super(columnNames);
        }

        @Override
        public Object getValueAt(int row, int col) {
            OnlineUserRow rowObject = this.getListObjects().get(row);
            switch(col){
                case 0:
                    return rowObject.getUser().getLogin();
                case 1:
                    return rowObject.getInfosBtn();
                case 2:
                    return rowObject.getUserSongsBtn();
                default:
                    return null; // Ne devrait jamais arriver
            }
        }
    }

    public void addUser(User user) {
        OnlineUserRow userToAdd = new OnlineUserRow(user);
        this.modeleTable.addObject(userToAdd);
        this.notifyObservers("ONLINE_USER_ADDED");
    }

    public void removeUser(String userId) {
        ArrayList<OnlineUserRow> listOnlineUsers = this.modeleTable.getListObjects();
        for (int i = 0; i < listOnlineUsers.size(); i++) {
            if (listOnlineUsers.get(i).getUser().getUserId().equals(userId)) {
                listOnlineUsers.remove(i);
            }
        }
        this.notifyObservers("ONLINE_USER_REMOVED");
    }

    public ArrayList<OnlineUserRow> getListOnlineUsers() {
        return this.modeleTable.getListObjects();
    }

    public void setListUsersOnline(ArrayList<OnlineUserRow> listOnlineUsers) {
        this.modeleTable.setListObjects(listOnlineUsers);
        this.notifyObservers("LIST_ONLINE_USERS_SET");
    }

    public OnlineUsersDynamicObject getModeleTable() {
        return this.modeleTable;
    }

    public void setModeleTable(OnlineUsersDynamicObject modele) {
        this.modeleTable = modele;
    }

}
