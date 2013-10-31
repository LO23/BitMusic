/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.connection;

import hmi.patterns.AbstractModuleComponent;
import hmi.patterns.AbstractView;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class ConnectionComponent extends AbstractModuleComponent {
    
    public ConnectionComponent() {
        this.model = new ConnectionModel();
        this.controller = new ConnectionController(this.model);
        this.view = new ConnectionView(this.controller); 
        model.addObserver(view);
        view.setVisible(true);
    }
   
}
