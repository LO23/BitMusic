/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.rightclicksong;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class RightClickSongPopUpView extends AbstractView<RightClickSongPopUpController> {

    private static final String type = "POPUP";

    public RightClickSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- RightClickSongPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

}
