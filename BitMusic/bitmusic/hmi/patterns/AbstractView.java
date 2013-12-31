/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

/**
 * Class of AbstractView
 * @author IHM
 * @param <C>
 */
public abstract class AbstractView<C extends AbstractController> extends JPanel implements Observer {

    private C abstractController;

    private JPanel panel = new JPanel();
    private Dimension dim;
    private final Font comics30 = new Font("Comics Sans MS", Font.BOLD, 30);
    private final Font comics40 = new Font("Comics Sans MS", Font.BOLD, 40);
    private final Font comics20 = new Font("Comics Sans MS", Font.BOLD, 20);
    private final Font arial = new Font("Arial", Font.BOLD, 15);
    private final Font dialog = new Font("Dialog", Font.BOLD + Font.ITALIC, 15);

    /**
     * Initializes the view
     */
    protected abstract void initPanel();

    /**
     * Returns the type of the PopUp
     * The type of the PopUp refers to its location in the screen
     * @return type
     */
    public abstract String getType();

    /**
     * Constructor of AbstractView
     */
    public AbstractView() {
        super();
    }

    /**
     * Returns controller
     * @return abstractController
     */
    public final C getController() {
        return this.abstractController;
    }

    /**
     * Updates controller
     * @param abstractController
     */
    public final void setController(final C abstractController) {
        this.abstractController = abstractController;
    }

    /**
     * Returns the panel
     * @return JPanel panel
     */
    public final JPanel getPanel() {
        return this.panel;
    }

    /**
     * Updates the panel
     * @param panel
     */
    public final void setPanel(final JPanel panel) {
        this.panel = panel;
    }

    /**
     * Returns the dimension
     * @return Dimension dim
     */
    public final Dimension getDim() {
        return this.dim;
    }

    /**
     * Updates the dimension
     * @param dim
     */
    public final void setDim(final Dimension dim) {
        this.dim = dim;
    }

    /**
     * Updates the view
     * @param obj
     * @param str
     */
    @Override
    public abstract void update(Observable obj, String str);
}
