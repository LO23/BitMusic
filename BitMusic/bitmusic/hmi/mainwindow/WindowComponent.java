/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.mainwindow;

import hmi.modules.connection.ConnectionComponent;
import hmi.patterns.AbstractComponent;
import hmi.patterns.AbstractModuleComponent;


/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowComponent extends AbstractComponent {
    private WindowModel model;
    private WindowView view;
    private WindowController controller;
    
    public WindowComponent() {
        this.model = new WindowModel();
        this.controller = new WindowController(this.model);
        this.view = new WindowView(this.controller);
        this.model.addObserver(this.view);
        
        AbstractModuleComponent connectionComponent = new ConnectionComponent();
        this.view.addPanel(connectionComponent.getView().getPanel());
    }

}
