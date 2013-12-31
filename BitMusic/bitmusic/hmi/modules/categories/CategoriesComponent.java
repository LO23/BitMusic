/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.categories;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 * 
 * @author IHM
 */
public final class CategoriesComponent extends AbstractComponent<CategoriesModel, CategoriesView, CategoriesController> {

    /**
     * Constructor of CategoriesComponent
     */
    public CategoriesComponent() {
        this.model = new CategoriesModel();
        this.view = new CategoriesView();
        this.controller = new CategoriesController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
