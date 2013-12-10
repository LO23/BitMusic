/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.managecategory;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class ManageCategoryPopUpView extends AbstractView<ManageCategoryPopUpController> {

    private final String type = "POPUP";

    /**
     *
     */
    public ManageCategoryPopUpView() {
        super();
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- ManageCategoryPopUpView.initPanel()");

        // TODO
    }

    /**
     *
     * @return
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
        System.out.println("----- ManageCategoryPopUpView.update() -> " + str);
    }
}
