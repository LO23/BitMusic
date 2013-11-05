/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.mainwindow;

import hmi.modules.connection.ConnectionComponent;
import hmi.patterns.AbstractModuleComponent;
import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowComponent {

    private WindowModel model;
    private WindowView view;
    private WindowController controller;

    private ArrayList<AbstractModuleComponent> listComponent = new ArrayList<>();

    public WindowComponent() {
        this.model = new WindowModel();
        this.view = new WindowView();
        this.controller = new WindowController(this.model, this.view);
        this.view.setWindowController(this.controller);
        this.model.addObserver(this.view);

        ConnectionComponent connectionComponent = new ConnectionComponent();
        this.addComponent(connectionComponent);
        this.view.addView(connectionComponent.getView());
    }

    protected void addComponent(AbstractModuleComponent component) {
        this.listComponent.add(component);
    }

    protected void removeComponent(AbstractModuleComponent component) {
        this.listComponent.remove(component);
    }
}
