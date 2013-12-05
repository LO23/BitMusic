/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.centralarea;

import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.modules.tab.TabView;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaView extends AbstractView<CentralAreaController> {

    private static final String type = "CENTER";

    private ArrayList<TabComponent> listTabComponent = new ArrayList();

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

    public TabComponent getTabComponent(int tabId) {
        for (int i = 0; i < this.listTabComponent.size(); i++) {
            if (listTabComponent.get(i).getView().getTabId().equals(tabId)) {
                return this.listTabComponent.get(i);
            }
        }
        return null;
    }

    public ArrayList<TabComponent> getListTabComponent() {
        return this.listTabComponent;
    }

    public void setListTabComponent(ArrayList<TabComponent> listTabComponent) {
        this.listTabComponent = listTabComponent;
    }

    public void addTabComponent(TabComponent tabComponent) {
        // Ajout du TabComponent à la ArrayList
        this.listTabComponent.add(tabComponent);

        // Ajout du Tab dans le tabbedPane
        TabView tabView = tabComponent.getView();
        String tabTitle = tabView.getTitle();
        this.tabbedPane.addTab(tabTitle, tabView.getPanel());

        // Positionnement du Tab dans le tabbedPane
        Integer indexTab = tabbedPane.indexOfTab(tabTitle);
        JPanel panelTab = tabView.getPanelTab();
        this.tabbedPane.setTabComponentAt(indexTab, panelTab);

        // Incrémentation du compteur de Tabs
        this.tabCounter++;
    }

    public void removeTabComponent(Integer tabId) {
        boolean tabFound = false;
        for (int i = 0; i < this.listTabComponent.size(); i++) {
            if (listTabComponent.get(i).getView().getTabId().equals(tabId)) {
                TabComponent tabToRemove = this.listTabComponent.get(i);
                // Suppression du TabComponent de la ArrayList et du Tab du tabbedPane
                this.listTabComponent.remove(tabToRemove);
                this.tabbedPane.remove(tabToRemove.getView().getPanel());
                tabFound = true;
            }
        }
        if (!tabFound) {
            System.out.println("Aucun tab trouvé avec le numéro tabId " + tabId);
        }
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
