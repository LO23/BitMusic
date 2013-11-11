/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class EditSongPopUpView extends AbstractView<EditSongPopUpController> {

    private static final String type = "POPUP";

    public EditSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- EditSongPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

}
