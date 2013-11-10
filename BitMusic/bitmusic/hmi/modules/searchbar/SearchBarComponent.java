/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class SearchBarComponent extends AbstractComponent {

    public SearchBarComponent() {
        this.model = new SearchBarModel();
        this.view = new SearchBarView();
        this.controller = new SearchBarController(this.model, this.view);
        this.view.setController(this.controller);
        this.model.addObserver(this.view);
    }
}
