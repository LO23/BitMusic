/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
            JTabbedPane tabbedPane = WindowComponent.getInstance().getCentralAreaComponent().getView().getTabbedPane();
            String tabTitle = TabController.this.getView().getTitle();
            tabbedPane.removeTabAt(tabbedPane.indexOfTab(tabTitle));

            // Est-ce que l'objet TabComponent est bien totalement supprimé ?
        }
    }

    private Action editer = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            Song song = ((TabModel.TabTableModel)table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Éditer de la Song : " + song.getSongId());
        }
    };

    private Action infos = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            Song song = ((TabModel.TabTableModel)table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Infos de la Song : " + song.getSongId());
        }
    };

    private Action noter = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            Song song = ((TabModel.TabTableModel)table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Noter de la Song : " + song.getSongId());
        }
    };

    private Action sauvegarder = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            Song song = ((TabModel.TabTableModel)table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Sauvegarder de la Song : " + song.getSongId());
        }
    };

    public Action getEditer() {
        return this.editer;
    }

    public Action getInfos() {
        return this.infos;
    }

    public Action getNoter() {
        return this.noter;
    }

    public Action getSauvegarder() {
        return this.sauvegarder;
    }
}
