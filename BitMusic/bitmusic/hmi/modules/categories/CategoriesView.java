/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.categories;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class CategoriesView extends AbstractView<CategoriesController> {

    private static final String type = "EAST";

    public CategoriesView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- CategoriesView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

}
