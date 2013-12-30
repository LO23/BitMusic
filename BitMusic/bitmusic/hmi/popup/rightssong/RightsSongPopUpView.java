/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.rightssong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 * View class of RightsSongPopUp
 * @author IHM
 */
public final class RightsSongPopUpView extends AbstractView<RightsSongPopUpController> {

    private final String type = "POPUP";
    private int parentTabId;

    /**
     * Constructor of RightsSongPopUpView
     * @param parentTabId
     */
    public RightsSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
    }

    /**
     * Initializes the view of RightsSongPopUp
     */
    @Override
    public void initPanel() {
        System.out.println("--- RightsSongPopUpView.initPanel()");

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
     * Updates the view of RightsSongPopUp
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- RightsSongPopUpView.update() -> " + str);
    }

    /**
     * Returns the parent id of the current tab
     * @return int parentTabId
     */
    public int getParentTabId() {
        return parentTabId;
    }

}
