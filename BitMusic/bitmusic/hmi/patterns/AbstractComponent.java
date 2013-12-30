/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 * Class of abstract component
 * @author IHM
 * @param <M>
 * @param <C>
 * @param <V>
 */
public abstract class AbstractComponent<M extends AbstractModel, V extends AbstractView, C extends AbstractController> {

    /**
     *
     */
    protected M model;

    /**
     *
     */
    protected V view;

    /**
     *
     */
    protected C controller;

    /**
     *
     */
    public AbstractComponent() {

    }

    /**
     * Returns the model
     * @return model
     */
    public final M getModel() {
        return this.model;
    }

    /**
     * Updates the model
     * @param model
     */
    public final void setModel(final M model) {
        this.model = model;
    }

    /**
     * Returns the view
     * @return view
     */
    public final V getView() {
        return this.view;
    }

    /**
     * Updates the view
     * @param view
     */
    public final void setView(final V view) {
        this.view = view;
    }

    /**
     * Returns the controller
     * @return controller
     */
    public final C getController() {
        return this.controller;
    }

    /**
     * Updates the controller
     * @param controller
     */
    public final void setController(final C controller) {
        this.controller = controller;
    }
}
