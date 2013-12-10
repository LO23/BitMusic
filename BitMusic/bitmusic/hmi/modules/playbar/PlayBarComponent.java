/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarComponent extends AbstractComponent<PlayBarModel, PlayBarView, PlayBarController> {

    /**
     *
     */
    public PlayBarComponent() {
        this.model = new PlayBarModel();
        this.view = new PlayBarView();
        this.controller = new PlayBarController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
