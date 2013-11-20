/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;

/**
 *
 * @author unkedeuxke
 */
public final class TabController extends AbstractController<TabModel, TabView> {

    public TabController(final TabModel model, final TabView view) {
        super(model, view);
    }

    public class CloseTabListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // On supprime le tab de tabbedPane
            JTabbedPane tabbedPane = WindowComponent.getInstance().getWindowView().getTabbedPane();
            String tabTitle = TabController.this.getView().getTitle();
            tabbedPane.removeTabAt(tabbedPane.indexOfTab(tabTitle));
        }
    }
}
