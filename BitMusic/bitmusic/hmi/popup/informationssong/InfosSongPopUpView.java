/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpView extends AbstractView<InfosSongPopUpController> {

    private static final String type = "POPUP";

    public InfosSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- InfosSongPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- InfosSongPopUpView.update()");
    }
}
