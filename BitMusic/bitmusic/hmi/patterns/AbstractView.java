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
 *
 * @author hebergui, unkedeuxke
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

    protected abstract void initPanel();

    public AbstractView() {
        super();
    }

    public final C getController() {
        return this.abstractController;
    }

    public final void setController(final C abstractController) {
        this.abstractController = abstractController;
    }

    public final JPanel getPanel() {
        return this.panel;
    }

    public final void setPanel(final JPanel panel) {
        this.panel = panel;
    }

    public final Dimension getDim() {
        return this.dim;
    }

    public final void setDim(final Dimension dim) {
        this.dim = dim;
    }
}
