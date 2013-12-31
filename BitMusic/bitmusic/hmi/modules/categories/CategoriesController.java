/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.categories;

import bitmusic.hmi.patterns.AbstractController;

/**
 *
 * @author IHM
 */
public final class CategoriesController extends AbstractController<CategoriesModel, CategoriesView> {

    /**
     * Constructor of CategoriesController
     * @param model
     * @param view
     */
    public CategoriesController(final CategoriesModel model, final CategoriesView view) {
        super(model, view);
    }
}
