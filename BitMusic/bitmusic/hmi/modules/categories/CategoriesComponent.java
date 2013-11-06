/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.categories;

import hmi.patterns.AbstractComponent;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class CategoriesComponent extends AbstractComponent {

    public CategoriesComponent() {
        this.model = new CategoriesModel();
        this.view = new CategoriesView();
        this.controller = new CategoriesController(this.model, this.view);
        this.view.setAbstractController(this.controller);
        this.model.addObserver(this.view);
    }
}
