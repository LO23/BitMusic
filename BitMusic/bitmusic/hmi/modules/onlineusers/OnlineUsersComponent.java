/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersComponent extends AbstractComponent<OnlineUsersModel, OnlineUsersView, OnlineUsersController> {

    public OnlineUsersComponent() {
        this.model = new OnlineUsersModel();
        this.view = new OnlineUsersView();
        this.controller = new OnlineUsersController(this.model, this.view);
        this.view.setController(this.controller);
        this.model.addObserver(this.view);
    }
}
