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
public abstract class AbstractController {

    private AbstractModel abstractModel;
    private AbstractView abstractView;

    public AbstractController(final AbstractModel abstractModel, final AbstractView abstractView) {
        this.abstractModel = abstractModel;
        this.abstractView = abstractView;
    }

    public final AbstractModel getAbstractModel() {
        return this.abstractModel;
    }

    public final void setAbstractModel(final AbstractModel abstractModel) {
        this.abstractModel = abstractModel;
    }

    public final AbstractView getAbstractView() {
        return this.abstractView;
    }

    public final void setAbstractView(final AbstractView abstractView) {
        this.abstractView = abstractView;
    }
}
