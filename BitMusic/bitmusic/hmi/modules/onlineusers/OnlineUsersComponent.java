/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.onlineusers;

import hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersComponent extends AbstractComponent {

    public OnlineUsersComponent() {
        this.model = new OnlineUsersModel();
        this.view = new OnlineUsersView();
        this.controller = new OnlineUsersController(this.model, this.view);
        this.view.setAbstractController(this.controller);
        this.model.addObserver(this.view);
    }
}
