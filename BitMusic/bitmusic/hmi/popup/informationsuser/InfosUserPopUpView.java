/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationsuser;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class InfosUserPopUpView extends AbstractView<InfosUserPopUpController> {

    private static final String type = "POPUP";

    public InfosUserPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- InfosUserPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

}
