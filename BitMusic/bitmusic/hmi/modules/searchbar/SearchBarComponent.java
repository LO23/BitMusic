/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author IHM
 */
public final class SearchBarComponent extends AbstractComponent<SearchBarModel, SearchBarView, SearchBarController> {

    /**
     * Constructor of SearchBarComponent
     */
    public SearchBarComponent() {
        this.model = new SearchBarModel();
        this.view = new SearchBarView();
        this.controller = new SearchBarController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
