/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.modifyprofile;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class ModifyProfilePopUpComponent extends AbstractComponent<ModifyProfilePopUpModel, ModifyProfilePopUpView, ModifyProfilePopUpController> {

    /**
     *
     */
    public ModifyProfilePopUpComponent() {
        this.model = new ModifyProfilePopUpModel();
        this.view = new ModifyProfilePopUpView();
        this.controller = new ModifyProfilePopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
