/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 * Components class of ImportSongPopUp
 * @author IHM
 */
public final class ImportSongPopUpComponent extends AbstractComponent<ImportSongPopUpModel, ImportSongPopUpView, ImportSongPopUpController> {

    /**
     * Constructor of ImportSongPopUpComponent
     */
    public ImportSongPopUpComponent() {
        this.model = new ImportSongPopUpModel();
        this.view = new ImportSongPopUpView();
        this.controller = new ImportSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);

        this.view.update(model, "init");
    }
}
