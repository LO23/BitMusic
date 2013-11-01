/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.patterns;

import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractComponent {

    protected ArrayList<AbstractModuleComponent> listComponent;

    public AbstractComponent() {
        this.listComponent = new ArrayList<>();
    }

    protected void addComponent(AbstractModuleComponent component) {
        this.listComponent.add(component);
    }

    protected void removeComponent(AbstractModuleComponent component) {
        this.listComponent.remove(component);
    }
}
