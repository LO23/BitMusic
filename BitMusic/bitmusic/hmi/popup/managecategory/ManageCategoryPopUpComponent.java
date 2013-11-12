/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.managecategory;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class ManageCategoryPopUpComponent extends AbstractComponent<ManageCategoryPopUpModel, ManageCategoryPopUpView, ManageCategoryPopUpController> {

    public ManageCategoryPopUpComponent() {
        this.model = new ManageCategoryPopUpModel();
        this.view = new ManageCategoryPopUpView();
        this.controller = new ManageCategoryPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
