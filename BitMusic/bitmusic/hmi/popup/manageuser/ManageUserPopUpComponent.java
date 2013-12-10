/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.manageuser;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class ManageUserPopUpComponent extends AbstractComponent<ManageUserPopUpModel, ManageUserPopUpView, ManageUserPopUpController> {

    /**
     *
     */
    public ManageUserPopUpComponent() {
        this.model = new ManageUserPopUpModel();
        this.view = new ManageUserPopUpView();
        this.controller = new ManageUserPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
