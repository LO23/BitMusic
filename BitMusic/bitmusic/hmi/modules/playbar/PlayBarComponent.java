/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.playbar;

import hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarComponent extends AbstractComponent {

    public PlayBarComponent() {
        this.model = new PlayBarModel();
        this.view = new PlayBarView();
        this.controller = new PlayBarController(this.model, this.view);
        this.view.setAbstractController(this.controller);
        this.model.addObserver(this.view);
    }
}
