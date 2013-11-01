/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.mainwindow;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import hmi.patterns.AbstractController;
import hmi.patterns.Observer;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowView extends JFrame implements Observer {

    private AbstractController windowController;
    private JPanel mainPanel;

    public WindowView(AbstractController windowController) {
        this.setTitle("BitMusic");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addPanel(JPanel panel) {
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}
