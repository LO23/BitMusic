/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractComponent<M extends AbstractModel, V extends AbstractView, C extends AbstractController> {

    protected M model;
    protected V view;
    protected C controller;

    public AbstractComponent() {

    }

    public final M getModel() {
        return this.model;
    }

    public final void setModel(final M model) {
        this.model = model;
    }

    public final V getView() {
        return this.view;
    }

    public final void setView(final V view) {
        this.view = view;
    }

    public final C getController() {
        return this.controller;
    }

    public final void setController(final C controller) {
        this.controller = controller;
    }
}
