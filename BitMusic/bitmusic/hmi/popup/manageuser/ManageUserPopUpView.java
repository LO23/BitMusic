/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.manageuser;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class ManageUserPopUpView extends AbstractView<ManageUserPopUpController> {

    private final String type = "POPUP";

    public ManageUserPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- ManageUserPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ManageUserPopUpView.update()");
    }
}
