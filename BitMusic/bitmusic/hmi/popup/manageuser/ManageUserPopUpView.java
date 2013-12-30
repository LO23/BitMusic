/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.manageuser;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 * View class of ManageUserPopUp
 * @author IHM
 */
public final class ManageUserPopUpView extends AbstractView<ManageUserPopUpController> {

    private final String type = "POPUP";

    /**
     * Constructor of ManageUserPopUpView
     */
    public ManageUserPopUpView() {
        super();
    }

    /**
     * Initializes the view of ManageUserPopUp
     */
    @Override
    public void initPanel() {
        System.out.println("--- ManageUserPopUpView.initPanel()");

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
     * Updates the view of ManageUserPopUp
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ManageUserPopUpView.update() -> " + str);
    }
}
