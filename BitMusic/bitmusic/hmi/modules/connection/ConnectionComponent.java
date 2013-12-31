/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author IHM
 */
public final class ConnectionComponent extends AbstractComponent<ConnectionModel, ConnectionView, ConnectionController> {

    /**
     * Constructor of ConnectionComponent
     */
    public ConnectionComponent() {
        this.model = new ConnectionModel();
        this.view = new ConnectionView();
        this.controller = new ConnectionController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
