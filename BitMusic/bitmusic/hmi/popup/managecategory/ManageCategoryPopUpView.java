/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.managecategory;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 * View class of ManageCatogoryPopUp
 * @author IHM
 */
public final class ManageCategoryPopUpView extends AbstractView<ManageCategoryPopUpController> {

    private final String type = "POPUP";

    /**
     * Constructor of ManageCategoryPopUpView
     */
    public ManageCategoryPopUpView() {
        super();
    }

    /**
     * Initializes the view
     */
    @Override
    public void initPanel() {
        System.out.println("--- ManageCategoryPopUpView.initPanel()");

        // TODO
    }

    /**
     * Returns the type of the PopUp
     * The type of the PopUp refers to its location in the screen
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Updates the view
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ManageCategoryPopUpView.update() -> " + str);
    }
}
