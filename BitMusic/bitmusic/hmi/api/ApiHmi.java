/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.onlineusers.OnlineUsersModel;
import bitmusic.profile.classes.User;

/**
 *
 * @author unkedeuxke
 */
public final class ApiHmi {


    public void notifyNewConnection(User lightUserLan){
        OnlineUsersModel onlineUsersModel = (OnlineUsersModel) WindowComponent.getInstance().getComponent("OnlineUsersComponent").get(0).getModel();
        onlineUsersModel.addUser(lightUserLan);
    }

}
