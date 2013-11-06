/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.patterns;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractComponent {

    protected AbstractModel model;
    protected AbstractView view;
    protected AbstractController controller;

    public AbstractComponent() {

    }

    public AbstractModel getModel() {
        return this.model;
    }

    public void setModel(AbstractModel model) {
        this.model = model;
    }

    public AbstractView getView() {
        return this.view;
    }

    public void setView(AbstractView view) {
        this.view = view;
    }

    public AbstractController getController() {
        return this.controller;
    }

    public void setController(AbstractController controller) {
        this.controller = controller;
    }
}
