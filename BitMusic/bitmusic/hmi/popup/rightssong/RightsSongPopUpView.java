/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.rightssong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class RightsSongPopUpView extends AbstractView<RightsSongPopUpController> {

    private final String type = "POPUP";
    private int parentTabId;

    /**
     *
     * @param parentTabId
     */
    public RightsSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- RightsSongPopUpView.initPanel()");

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
        System.out.println("----- RightsSongPopUpView.update() -> " + str);
    }

    /**
     *
     * @return
     */
    public int getParentTabId() {
        return parentTabId;
    }
    
}
