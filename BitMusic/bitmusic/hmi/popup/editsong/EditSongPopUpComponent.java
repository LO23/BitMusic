/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class EditSongPopUpComponent extends AbstractComponent<EditSongPopUpModel, EditSongPopUpView, EditSongPopUpController> {

    public EditSongPopUpComponent() {
        this.model = new EditSongPopUpModel();
        this.view = new EditSongPopUpView();
        this.controller = new EditSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
