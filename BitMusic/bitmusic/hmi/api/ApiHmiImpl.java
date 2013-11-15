/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.User;

/**
 *
 * @author unkedeuxke
 */
public final class ApiHmiImpl implements ApiHmi {

    @Override
    public void notifyNewConnection(User lightUserLan){
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().addUser(lightUserLan);
    }

    @Override
    public void removeUserFromOnlineUsers(String userId) {
        WindowComponent.getInstance().getOnlineUsersComponent().getModel().removeUser(userId);
    }

    @Override
    public void notifyLightProfile(User user, String searchId) {
        //TODO
    }

    @Override
    public void notifySongListByUserId(String userID, SongLibrary songLibrary) {
        //TODO
    }

    @Override
    public void notifySongListBySearchId(String searchId, SongLibrary songList) {
        //TODO
    }
}
