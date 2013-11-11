/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class RateSongPopUpView extends AbstractView<RateSongPopUpController> {

    private static final String type = "POPUP";

    public RateSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- RateSongPopUpView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- RateSongPopUpView.update()");
    }
}
