/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.others;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractView extends JPanel implements Observer {
    protected JPanel panel = new JPanel();
    protected Dimension dim;
    protected final Font comics30 = new Font("Comics Sans MS", Font.BOLD, 30);
    protected final Font comics40 = new Font("Comics Sans MS", Font.BOLD, 40);
    protected final Font comics20 = new Font("Comics Sans MS", Font.BOLD, 20);
    protected final Font arial = new Font("Arial", Font.BOLD, 15);
    protected final Font dialog = new Font("Dialog", Font.BOLD + Font.ITALIC, 15);

    protected abstract void initPanel();	
}
