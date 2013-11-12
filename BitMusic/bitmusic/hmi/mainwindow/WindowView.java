/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.hmi.patterns.Observer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowView extends JFrame implements Observer, WindowListener {

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

        if ("CONNECTION".equals(view.getType())){
            this.getContentPane().add(view.getPanel());
            pack();
            this.setVisible(true);
        }
        else {
            JPanel contentPanel = new JPanel(new BorderLayout());
            this.getContentPane().add(contentPanel);
            switch (view.getType()) {
                case "WEST":
                    contentPanel.add(view.getPanel(), BorderLayout.WEST);
                    break;
                case "SOUTH":
                    contentPanel.add(view.getPanel(), BorderLayout.SOUTH);
                    break;
                case "NORTH":
                    contentPanel.add(view.getPanel(), BorderLayout.NORTH);
                    break;
                case "EAST":
                    contentPanel.add(view.getPanel(), BorderLayout.EAST);
                    break;
                case "CENTER":
                    contentPanel.add(view.getPanel(), BorderLayout.CENTER);
                    break;
                default:
                    System.out.println("Error le type du panel (north, south, east... non définie");
                    break;
            }
            pack();
            this.setVisible(true);
        }
    }

    public void removeView(AbstractView view) {
        this.getContentPane().remove(view.getPanel()); // TODO : détruire l'objet ? (ex : ConnectionComponent)
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- WindowView.update()");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.windowController.getWindowModel().notifyObservers("DECONNECTION");
        this.dispose();
        System.out.println("----- WindowView.windowClosing()");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
