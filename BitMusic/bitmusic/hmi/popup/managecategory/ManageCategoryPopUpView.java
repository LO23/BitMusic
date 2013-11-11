/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.managecategory;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class ManageCategoryPopUpView extends AbstractView<ManageCategoryPopUpController> {

    private static final String type = "POPUP";

    public ManageCategoryPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- ManageCategoryPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

}
