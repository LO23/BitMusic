/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.rightclicksong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class RightClickSongPopUpView extends AbstractView<RightClickSongPopUpController> {

    private final String type = "POPUP";
    private int parentTabId;

    /**
     *
     * @param parentTabId
     */
    public RightClickSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- RightClickSongPopUpView.initPanel()");

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
        System.out.println("----- RightClickSongPopUpView.update() -> " + str);
    }

    /**
     *
     * @return
     */
    public int getParentTabId() {
        return parentTabId;
    }
    
}
