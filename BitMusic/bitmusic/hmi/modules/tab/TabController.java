/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.editsong.EditSongPopUpComponent;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author unkedeuxke
 */
public final class TabController extends AbstractController<TabModel, TabView> {

    private JDialog popUp;

    public TabController(final TabModel model, final TabView view) {
        super(model, view);
    }

    public class CloseTabListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int tabId = TabController.this.getView().getTabId();
            WindowComponent.getInstance().getCentralAreaComponent().getView().removeTabComponent(tabId);
        }
    }

    public class DoubleClickListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            if (e.getClickCount() == 2){
                JTable table = (JTable)e.getSource();
                int row = table.getSelectedRow();
                Song song = ((TabModel.TabTableModel)table.getModel()).getSongAt(row);
                WindowComponent.getInstance().getPlayBarComponent().getModel().setSong(song);

                System.out.println("---- Double click de la Song : " + song.getSongId());
            }
        }
    }

    private Action editer = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            Song song = ((TabModel.TabTableModel)table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Éditer de la Song : " + song.getSongId());

            WindowComponent win = WindowComponent.getInstance();
            EditSongPopUpComponent editSongPopUpComponent = new EditSongPopUpComponent(song, TabController.this.getView().getTabId());

            popUp = new JDialog(win.getWindowView(), "Editer un morceau", true);
            popUp.add(editSongPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();

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

    public JDialog getPopUp() {
        return popUp;
    }

    public void setPopUp(JDialog popUp) {
        this.popUp = popUp;
    }

    
}
