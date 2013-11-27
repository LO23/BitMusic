/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.centralarea;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.modules.tab.TabView;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaView extends AbstractView<CentralAreaController> {

    private static final String type = "CENTER";

    private JTabbedPane tabbedPane = new JTabbedPane();
    private Integer tabCounter = 0;

    public CentralAreaView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- CentralAreaView.initPanel()");

        this.getPanel().add(this.tabbedPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public int addTab(TabView tabView){
        // Ajout du tab au tabbedPane
        String tabTitle = tabView.getTitle();
        this.tabbedPane.addTab(tabTitle, tabView.getPanel());

        // Positionnement du tab dans le tabbedPane
        Integer indexTab = tabbedPane.indexOfTab(tabTitle);
        JPanel panelTab = tabView.getPanelTab();
        this.tabbedPane.setTabComponentAt(indexTab, panelTab);

        // Incrémentation du compteur de tabs
        this.tabCounter++;

        return this.tabCounter-1;
    }

    public void removeTab(TabView tabView) {
        //Suppression du tabbedPane
        this.tabbedPane.remove(tabView.getPanel());
    }

    public JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }

    public void setTabbedPane(final JTabbedPane newTabbedPane) {
        this.tabbedPane = newTabbedPane;
    }

    public Integer getTabCounter() {
        return this.tabCounter;
    }

    public void setTabCounter(final Integer newTabCounter) {
        this.tabCounter = newTabCounter;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- CentralAreaView.update()");
    }
}
