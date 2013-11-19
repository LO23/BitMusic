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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowView extends JFrame implements Observer {

    private WindowController windowController;
    private JPanel contentPanel = new JPanel(new BorderLayout());
    private final JPanel jpanelNorth = new JPanel (new GridBagLayout());
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel.add(jpanelNorth, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void addView(AbstractView view) {

        if ("CONNECTION".equals(view.getType())){
            this.getContentPane().add(view.getPanel());
            pack();
            this.setVisible(true);
        } else {
            this.getContentPane().add(contentPanel);
            switch (view.getType()) {
                case "WEST":
                    contentPanel.add(view.getPanel(), BorderLayout.WEST);
                    break;
                case "SOUTH":
                    contentPanel.add(view.getPanel(), BorderLayout.SOUTH);
                    break;
                case "NORTH":
                    if (view.getClass().getSimpleName().equalsIgnoreCase("MyProfileView")) {
                        gridBagConstraints.fill = GridBagConstraints.NONE;
                        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
                        gridBagConstraints.weightx = 1;
                        jpanelNorth.add(view.getPanel(), gridBagConstraints);
                    }
                    if (view.getClass().getSimpleName().equalsIgnoreCase("SearchBarView")) {
                        gridBagConstraints.fill = GridBagConstraints.NONE;
                        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
                        gridBagConstraints.weightx = 1;
                        jpanelNorth.add(view.getPanel(), gridBagConstraints);
                    }
                    break;
                case "EAST":
                    contentPanel.add(view.getPanel(), BorderLayout.EAST);
                    break;
                case "CENTER":
                    contentPanel.add(view.getPanel(), BorderLayout.CENTER);
                    break;
                default:
                    System.out.println("Error : type du panel (north, south, east...) non défini !");
                    break;
            }
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dim = toolkit.getScreenSize();
            this.setSize(dim.width, dim.height-20);
            //this.setLocationRelativeTo(null);
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
}
