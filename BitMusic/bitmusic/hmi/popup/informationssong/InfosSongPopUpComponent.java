/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpComponent extends AbstractComponent<InfosSongPopUpModel, InfosSongPopUpView, InfosSongPopUpController> {

    public InfosSongPopUpComponent() {
        this.model = new InfosSongPopUpModel();
        this.view = new InfosSongPopUpView();
        this.controller = new InfosSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
