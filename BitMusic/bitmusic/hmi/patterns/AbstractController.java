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
public abstract class AbstractController<M extends AbstractModel, V extends AbstractView> {

    private M model;
    private V view;

    public AbstractController(final M model, final V view) {
        this.model = model;
        this.view = view;
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
}
