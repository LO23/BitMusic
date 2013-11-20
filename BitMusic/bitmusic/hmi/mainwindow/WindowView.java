/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.modules.tab.TabView;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.hmi.patterns.Observer;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowView extends JFrame implements Observer {

    private WindowController windowController;
    private JPanel contentPanel = new JPanel(new BorderLayout());
    private final JPanel jpanelNorth = new JPanel (new GridBagLayout());
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private int count = 0;

    public WindowView() {

    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
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
            //Toolkit toolkit = Toolkit.getDefaultToolkit();
            //Dimension dim = toolkit.getScreenSize();
            //this.setSize(dim.width, dim.height-20);
            //this.setLocationRelativeTo(null);
            this.setVisible(true);
            pack();
        }
    }

    public void removeView(AbstractView view) {
        if ("CONNECTION".equals(view.getType())){
            this.getContentPane().remove(view.getPanel());
        } else {
            this.contentPanel.remove(view.getPanel());
        }
    }

    public void addTabbedPane(JTabbedPane tabbedPane) {
        this.getContentPane().add(contentPanel);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);
        this.setVisible(true);
        pack();

    }

    public void removeTabbedPane(JTabbedPane tabbedPane) {
        this.contentPanel.remove(tabbedPane);
    }

    public void addTabToTabbedPane(TabView tabView){

        String title = "Tab #" + count;
        count++;

        tabbedPane.addTab(title, tabView.getPanel());
        int index = tabbedPane.indexOfTab(title);

        JPanel panelTab = new JPanel(new GridBagLayout());
        panelTab.setOpaque(false);
        JLabel labelTitle = new JLabel(title);
        JButton btnClose = new JButton("x");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        panelTab.add(labelTitle, gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        panelTab.add(btnClose, gbc);

        tabbedPane.setTabComponentAt(index, panelTab);

        //On ajoute une action pour supprimer CE tab quand on appuiera sur quitter
        MyCloseActionListener myCloseActionHandler = new MyCloseActionListener(title);
        btnClose.addActionListener(myCloseActionHandler);
    }


    //TODO : mettre dans le WindowController mais cela pose le problème qu'on ne peut pas passer d'argument
    // on ne sait donc pas quel tab supprimer...
    public class MyCloseActionListener implements ActionListener {

        private String tabName;

        public MyCloseActionListener(String tabName) {
            this.tabName = tabName;
        }

        public String getTabName() {
            return tabName;
        }

        public void actionPerformed(ActionEvent evt) {

            int index = tabbedPane.indexOfTab(getTabName());

            if (index >= 0) {
                tabbedPane.removeTabAt(index);
            }
        }
    }


    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- WindowView.update()");
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }

    public void setGridBagConstraints(GridBagConstraints gridBagConstraints) {
        this.gridBagConstraints = gridBagConstraints;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }


}
