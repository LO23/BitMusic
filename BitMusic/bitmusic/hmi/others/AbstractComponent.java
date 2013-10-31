/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.others;

import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractComponent {
    protected AbstractModel model;
    protected AbstractView view;
    protected AbstractController controller;

    protected ArrayList<AbstractComponent> listComponent = new ArrayList<>();

    protected void addComponent(AbstractComponent component) {
        listComponent.add(component);
    }

    protected void removeComponent(AbstractComponent component) {
        listComponent.remove(component);
    }

}
