/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.modifyprofile;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class ModifyProfilePopUpView extends AbstractView<ModifyProfilePopUpController> {

    private static final String type = "POPUP";

    public ModifyProfilePopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- ModifyProfilePopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

}
