/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarView extends AbstractView<PlayBarController> {

    public PlayBarView() {
        super();
        this.initPanel();
    }

    @Override
    public void initPanel() {
        System.out.println("--- PlayBarView.initPanel()");

        // TODO
    }
}
