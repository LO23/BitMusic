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
import hmi.patterns.AbstractView;
import hmi.patterns.Observer;
import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowView extends JFrame implements Observer {

    private AbstractController windowController;
    private JPanel mainPanel = new JPanel(); 
    private ArrayList<AbstractView> listView = new ArrayList<>();

    public WindowView(AbstractController abstractController) {
        this.windowController = abstractController;
        this.initFrame();
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

    public void addPanel(JPanel panel) {
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
    
    public void addView(AbstractView view) {
        this.listView.add(view);
        this.addPanel(view.getPanel());
    }
    
    public void removeView(AbstractView view) {
        this.listView.remove(view);
    }
}
