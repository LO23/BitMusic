/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.tab;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.editsong.EditSongPopUpComponent;
import bitmusic.hmi.popup.informationssong.InfosSongPopUpComponent;
import bitmusic.hmi.popup.ratesong.RateSongPopUpComponent;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.io.File.separator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author unkedeuxke
 */
public final class TabController extends AbstractController<TabModel, TabView> {

    private JDialog popUp;

    /**
     *
     * @param model
     * @param view
     */
    public TabController(final TabModel model, final TabView view) {
        super(model, view);
    }

    /**
     *
     */
    public class CloseTabListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int tabId = TabController.this.getView().getTabId();
            WindowComponent.getInstance().getCentralAreaComponent().getView().removeTabComponent(tabId);
        }
    }

    /**
     *
     */
    public class DoubleClickListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                JTable table = (JTable) e.getSource();
                int row = table.getSelectedRow();
                Song song = ((TabModel.TabTableModel) table.getModel()).getSongAt(row);
                WindowComponent.getInstance().getPlayBarComponent().getModel().setSong(song);
                // TODO here : double cliks triggers the song playing

                System.out.println("---- Double click de la Song : " + song.getSongId());
            }
        }
    }

    private Action editer = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int row = Integer.valueOf(e.getActionCommand());
            Song song = ((TabModel.TabTableModel) table.getModel()).getSongAt(row);
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

    private Action supprimer = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int row = Integer.valueOf(e.getActionCommand());
            Song song = ((TabModel.TabTableModel) table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Supprimer de la Song : " + song.getSongId());

            WindowComponent win = WindowComponent.getInstance();
            win.getApiMusic().deleteSong(song.getSongId());

            TabController.this.getModel().notifyObservers("Suppression d'une Song");
        }
    };

    private Action infos = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int row = Integer.valueOf(e.getActionCommand());
            Song song = ((TabModel.TabTableModel) table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Infos de la Song : " + song.getSongId());

            WindowComponent win = WindowComponent.getInstance();
            InfosSongPopUpComponent infosSongPopUpComponent = new InfosSongPopUpComponent(song, TabController.this.getView().getTabId());

            popUp = new JDialog(win.getWindowView(), "Informations d'un morceau", true);
            popUp.add(infosSongPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();

        }
    };

    private Action noter = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int row = Integer.valueOf(e.getActionCommand());
            Song song = ((TabModel.TabTableModel) table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Noter de la Song : " + song.getSongId());

            WindowComponent win = WindowComponent.getInstance();
            RateSongPopUpComponent rateSongPopUpComponent = new RateSongPopUpComponent(song, TabController.this.getView().getTabId());

            popUp = new JDialog(win.getWindowView(), "Informations d'un morceau", true);
            popUp.add(rateSongPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();
        }
    };

    private Action sauvegarder = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int row = Integer.valueOf(e.getActionCommand());
            Song song = ((TabModel.TabTableModel) table.getModel()).getSongAt(row);
            System.out.println("---- Clic sur Sauvegarder de la Song : " + song.getSongId());

            WindowComponent win = WindowComponent.getInstance();
            String currentUserId = win.getApiProfile().getCurrentUser().getUserId();
            String songOwnerId = song.getOwnerId();

            // Si song locale : on ne peut pas la sauvegarder
            if (currentUserId.equals(songOwnerId)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Erreur !",
                        "Impossible de sauvegarder une musique locale",
                        JOptionPane.QUESTION_MESSAGE);
            } else {
                // Demande du nom souhaité pour le fichier
                String fileName = JOptionPane.showInputDialog(
                        null,
                        "Nom souhaité ? (sans l'extension)",
                        "Enregistrement d'un morceau",
                        JOptionPane.QUESTION_MESSAGE);
                while (fileName.matches(".*\\W.*")) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Les caractères spéciaux ne sont pas autorisés !",
                            "Attention aux caractères spéciaux",
                            JOptionPane.WARNING_MESSAGE);

                    fileName = JOptionPane.showInputDialog(
                        null,
                        "Nom souhaité ? (sans l'extension)",
                        "Enregistrement d'un morceau",
                        JOptionPane.QUESTION_MESSAGE);
                }

                // Création du sélecteur de répertoire
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setDialogTitle("Choix du répertoire de destination");

                int returnVal = chooser.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String directoryPath = chooser.getSelectedFile().getPath();
                    String destination = directoryPath + separator + fileName + ".mp3";

                    // Appel de la méthode concernée dans Music
                    win.getApiMusic().saveSong(songOwnerId, song.getSongId(), destination);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Erreur !",
                            "Erreur lors de la récupération du répertoire de sauvegarde",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        }
    };

    /**
     *
     * @return
     */
    public Action getEditer() {
        return this.editer;
    }

    /**
     *
     * @return
     */
    public Action getInfos() {
        return this.infos;
    }

    /**
     *
     * @return
     */
    public Action getNoter() {
        return this.noter;
    }

    /**
     *
     * @return
     */
    public Action getSauvegarder() {
        return this.sauvegarder;
    }

    public Action getSupprimer() {
        return this.supprimer;
    }

    /**
     *
     * @return
     */
    public JDialog getPopUp() {
        return popUp;
    }

    /**
     *
     * @param popUp
     */
    public void setPopUp(JDialog popUp) {
        this.popUp = popUp;
    }

}
