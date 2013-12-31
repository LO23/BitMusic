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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View class of main window
 * @author IHM
 */
public class WindowView extends JFrame implements Observer {

    private WindowController windowController;
    private JPanel contentPanel = new JPanel(new BorderLayout());
    private final JPanel jpanelNorth = new JPanel (new GridBagLayout());
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /**
     *
     */
    public WindowView() {

    }

    /**
     *
     * @return windowController
     */
    public WindowController getWindowController() {
        return this.windowController;
    }

    /**
     *
     * @param windowController
     */
    public void setWindowController(WindowController windowController) {
        this.windowController = windowController;
    }

    /**
     * Initializes the view of main window
     */
    public void initFrame() {
        System.out.println("-- WindowView.initFrame()");

        this.setTitle("BitMusic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel.add(jpanelNorth, BorderLayout.NORTH);
    }

    /**
     * Adds a view according to its type
     * @param view
     */
    public void addView(AbstractView view) {
        if ("CONNECTION".equals(view.getType())){
            this.getContentPane().add(view.getPanel());
        } else {
            this.getContentPane().add(contentPanel);
            String type = view.getType();
            if (type.equals("WEST")) {
                contentPanel.add(view.getPanel(), BorderLayout.WEST);
            } else if (type.equals("SOUTH")) {
                contentPanel.add(view.getPanel(), BorderLayout.SOUTH);
            } else if(type.equals("NORTH")) {
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
            } else if(type.equals("EAST")) {
                contentPanel.add(view.getPanel(), BorderLayout.EAST);
            } else if(type.equals("CENTER")) {
                contentPanel.add(view.getPanel(), BorderLayout.CENTER);
            } else {
                System.out.println("Error : type du panel (north, south, east...) non défini !");
            }
        }
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * Removes a view
     * @param view
     */
    public void removeView(AbstractView view) {
        if ("CONNECTION".equals(view.getType())){
            this.getContentPane().remove(view.getPanel());
        } else {
            this.contentPanel.remove(view.getPanel());
        }
    }

    /**
     * Updates a view
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- WindowView.update() -> " + str);
    }

    /**
     *
     * @return contentPanel
     */
    public JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     *
     * @param contentPanel
     */
    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    /**
     *
     * @return gridBagConstraints
     */
    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }

    /**
     *
     * @param gridBagConstraints
     */
    public void setGridBagConstraints(GridBagConstraints gridBagConstraints) {
        this.gridBagConstraints = gridBagConstraints;
    }
}
