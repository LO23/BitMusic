/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarView extends AbstractView<PlayBarController> {

    private static final String type = "SOUTH";

    public PlayBarView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- PlayBarView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- PlayBarView.update()");
    }
}
