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

    private WindowComponent() {
        this.model = new WindowModel();
        this.view = new WindowView();
        this.controller = new WindowController(this.model, this.view);
        this.view.setWindowController(this.controller);
        this.model.addObserver(this.view);

        ConnectionComponent connectionComponent = new ConnectionComponent();
        this.addComponent(connectionComponent);
        this.view.addView(connectionComponent.getView());
    }

    /** Holder */
    private static class WindowComponentHolder {
        /** Instance unique non préinitialisée */
        private final static WindowComponent instance = new WindowComponent();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static WindowComponent getInstance() {
            return WindowComponentHolder.instance;
    }

    public void addComponent(AbstractModuleComponent component) {
        this.listComponent.add(component);
    }

    public void removeComponent(AbstractModuleComponent component) {
        this.listComponent.remove(component);
    }
}
