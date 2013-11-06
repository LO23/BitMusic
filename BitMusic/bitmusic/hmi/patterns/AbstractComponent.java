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

    public final AbstractModel getModel() {
        return this.model;
    }

    public final void setModel(final AbstractModel model) {
        this.model = model;
    }

    public final AbstractView getView() {
        return this.view;
    }

    public final void setView(final AbstractView view) {
        this.view = view;
    }

    public final AbstractController getController() {
        return this.controller;
    }

    public final void setController(final AbstractController controller) {
        this.controller = controller;
    }
}
