/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.patterns;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractView extends JPanel implements Observer {

    private AbstractController abstractController;

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

    public AbstractController getAbstractController() {
        return this.abstractController;
    }

    public void setAbstractController(AbstractController abstractController) {
        this.abstractController = abstractController;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Dimension getDim() {
        return this.dim;
    }

    public void setDim(Dimension dim) {
        this.dim = dim;
    }
}
