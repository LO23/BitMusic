/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.onlineusers.OnlineUsersModel;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.User;

/**
 *
 * @author unkedeuxke
 */
public final class ApiHmiImpl implements ApiHmi {


    @Override
    public void notifyLightProfile(User user, String searchId) {
        //TODO
    }

    @Override
    public void notifyNewConnection(User lightUserLan){
        OnlineUsersModel onlineUsersModel = (OnlineUsersModel) WindowComponent.getInstance().getComponent("OnlineUsersComponent").get(0).getModel();
        onlineUsersModel.addUser(lightUserLan);
    }

    @Override
    public void notifySongListByUserId(String userID, SongLibrary songLibrary) {
        //TODO
    }

    @Override
    public void notifySongListBySearchId(String searchId, SongLibrary songList) {
        //TODO
    }

    @Override
    public void removeUserFromOnlineUsers(String userId) {// pourquoi ne pas passer un User lightUserLan en argument directement ? et pourquoi ne pas encore + simplement utiliser la méthode getListUser de apiNetwork ?
        OnlineUsersModel onlineUsersModel = (OnlineUsersModel) WindowComponent.getInstance().getComponent("OnlineUsersComponent").get(0).getModel();
        onlineUsersModel.removeUser(userId);
    }

}
