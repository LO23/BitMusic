/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowView extends JFrame implements Observer {

    private WindowController windowController;

    public WindowView() {
        
    }

    public WindowController getWindowController() {
        return this.windowController;
    }

    public void setWindowController(WindowController windowController) {
        this.windowController = windowController;
    }

    public void initFrame() {
        System.out.println("-- WindowView.initFrame()");
        this.setTitle("BitMusic");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addView(AbstractView view) {

        if (view.getType() == "CONNECTION"){
            this.getContentPane().add(view.getPanel());
            pack();
            this.setVisible(true);
        }
        else {
            JPanel contentPanel = new JPanel(new BorderLayout());
            this.getContentPane().add(contentPanel);

            if (view.getType() == "WEST") {
                contentPanel.add(view.getPanel(), BorderLayout.WEST);

            }
            else if (view.getType() == "SOUTH") {
               contentPanel.add(view.getPanel(), BorderLayout.SOUTH);
            }
            else if (view.getType() == "NORTH") {
                contentPanel.add(view.getPanel(), BorderLayout.NORTH);
            }
            else if (view.getType() == "EAST") {
                contentPanel.add(view.getPanel(), BorderLayout.CENTER);
            }
            else if (view.getType() == "CENTER"){
               contentPanel.add(view.getPanel(), BorderLayout.CENTER);
            }
            else {
                System.out.println("Error le type du panel (north, south, east... non définie");
            }
        }
    }

    public void removeView(AbstractView view) {
        this.getContentPane().remove(view.getPanel()); // TODO : détruire l'objet ? (ex : ConnectionComponent)
    }
}
