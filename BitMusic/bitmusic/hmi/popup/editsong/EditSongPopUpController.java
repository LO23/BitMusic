/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpModel;
import bitmusic.hmi.popup.importsong.ImportSongPopUpView;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author unkedeuxke
 */
public final class EditSongPopUpController extends AbstractController<EditSongPopUpModel, EditSongPopUpView> {

    public EditSongPopUpController(final EditSongPopUpModel model, final EditSongPopUpView view) {
        super(model, view);
    }

    public class FileBrowseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Parcourir");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers MP3", "mp3", "MP3");
            chooser.setFileFilter(filter);

            int returnVal = chooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("---- OK");
                EditSongPopUpController.this.getView().getFileField().setText(chooser.getSelectedFile().getPath());
            }
        }
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent win = WindowComponent.getInstance();
            int parentTabId = EditSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
        }
    }

    public class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Editer");
            WindowComponent win = WindowComponent.getInstance();
            EditSongPopUpView view = EditSongPopUpController.this.getView();
            EditSongPopUpModel model = EditSongPopUpController.this.getModel();
            List<String> tag = view.getTagList().getSelectedValuesList();

            if (EditSongPopUpController.this.checkAllCompulsoryFields()){
                Song song = model.getSong();

//                win.getApiMusic().modifySong(
//                        song.getSongId(),
//                        view.getFileField().getText(),
//                        view.getTitleField().getText(),
//                        view.getArtistField().getText(),
//                        view.getAlbumField().getText(),
//                        new LinkedList<String>(view.getTagList().getSelectedValuesList()),
//                        null);

                int parentTabId = EditSongPopUpController.this.getView().getParentTabId();
                win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
            }
            else {
                JOptionPane.showMessageDialog(
                        view,
                        "Tous les champs obligatoires doivent être renseignés !",
                        "Attention aux champs",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    public boolean checkAllCompulsoryFields(){
        ArrayList<JTextField> listCompulsoryFields = this.getView().getListCompulsoryFields();

        for (int i=0; i<listCompulsoryFields.size(); i++){
            if ( listCompulsoryFields.get(i).getText().length() <= 0 ) {
                return false;
            }
        }

        return true;
    }

    public class AddNewTagListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Ajouter");
            EditSongPopUpView view = EditSongPopUpController.this.getView();
            EditSongPopUpModel model = EditSongPopUpController.this.getModel();
            String newTag = view.getNewTagField().getText();

            if ( newTag.length() !=0 ) {
                model.addTag(newTag);
                view.getNewTagField().setText("");
            }
        }
    }
}
