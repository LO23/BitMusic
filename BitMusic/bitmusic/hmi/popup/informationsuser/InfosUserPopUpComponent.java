/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationsuser;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.profile.classes.User;

/**
 *
 * @author unkedeuxke
 */
public final class InfosUserPopUpComponent extends AbstractComponent<InfosUserPopUpModel, InfosUserPopUpView, InfosUserPopUpController> {

    private User user;

    public InfosUserPopUpComponent(User user) {
        this.user = user;

        this.model = new InfosUserPopUpModel(user);
        this.view = new InfosUserPopUpView();
        this.controller = new InfosUserPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
