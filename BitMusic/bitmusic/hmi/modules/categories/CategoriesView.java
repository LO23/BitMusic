/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.categories;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author IHM
 */
public final class CategoriesView extends AbstractView<CategoriesController> {

    private static final String type = "WEST";

    /**
     * Constructor of CategoriesView
     */
    public CategoriesView() {
        super();
    }

    /**
     * Initializes the view
     */
    @Override
    public void initPanel() {
        System.out.println("--- CategoriesView.initPanel()");

        // TODO
    }

    /**
     *
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- CategoriesView.update() -> " + str);
    }
}
