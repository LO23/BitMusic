/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.connection;

import hmi.patterns.AbstractComponent;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class ConnectionComponent extends AbstractComponent {

    public ConnectionComponent() {
        this.model = new ConnectionModel();
        this.view = new ConnectionView();
        this.controller = new ConnectionController(this.model, this.view);
        this.view.setAbstractController(this.controller);
        this.model.addObserver(this.view);
    }
}
