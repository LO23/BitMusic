/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.modules.connection.ConnectionComponent;
import bitmusic.hmi.modules.myprofile.MyProfileComponent;
import bitmusic.hmi.patterns.AbstractComponent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowComponent {

    private WindowModel model;
    private WindowView view;
    private WindowController controller;

    private ArrayList<AbstractComponent> listComponent = new ArrayList<>();

    private WindowComponent() {
        this.model = new WindowModel();
        this.view = new WindowView();
        this.controller = new WindowController(this.model, this.view);
        this.view.setWindowController(this.controller);
        this.view.initFrame();
        this.model.addObserver(this.view);

        //ConnectionComponent connectionComponent = new ConnectionComponent();
        //this.addComponent(connectionComponent);
        //this.view.addView(connectionComponent.getView());
        
        MyProfileComponent myProfileComponent = new MyProfileComponent();
        this.addComponent(myProfileComponent);
        this.view.addView(myProfileComponent.getView());
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

    public void addComponent(AbstractComponent component) {
        this.listComponent.add(component);
    }

    public ArrayList<AbstractComponent> getComponent(String componentClass) {
        ArrayList<AbstractComponent> matches = new ArrayList<>();

        Iterator<AbstractComponent> iterator = this.listComponent.iterator();
        while (iterator.hasNext()) {
            AbstractComponent current = iterator.next();
            if (current.getClass().getSimpleName().equals(componentClass)) {
                matches.add(current);
            }
        }
        return matches;
    }

    public void removeComponent(AbstractComponent component) {
        this.listComponent.remove(component);
    }
}
