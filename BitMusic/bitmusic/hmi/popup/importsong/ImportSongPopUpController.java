/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Controller class of ImportSongPopUp
 * @author IHM
 */
public final class ImportSongPopUpController extends AbstractController<ImportSongPopUpModel, ImportSongPopUpView> {

    /**
     * Contructor of ImportSongPopUpController
     * @param model
     * @param view
     */
    public ImportSongPopUpController(final ImportSongPopUpModel model, final ImportSongPopUpView view) {
        super(model, view);
    }

    /**
     * Listener on browse button
     * This listener allows to chose the song to import
     * Due to a filter, only mp3 files can be chosen
     * @see JFileChooser
     * @see FileNameExtensionFilter
     */
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
                ImportSongPopUpController.this.getView().getFileField().setText(chooser.getSelectedFile().getPath());
            }
        }
    }

    /**
     * Listener on add tag button
     * Adds a tag to the song to import
     */
    public class AddNewTagListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Ajouter");
            ImportSongPopUpView view = ImportSongPopUpController.this.getView();
            ImportSongPopUpModel model = ImportSongPopUpController.this.getModel();
            String newTag = view.getNewTagField().getText();

            if ( newTag.length() !=0 ) {
                model.addTag(newTag);
                view.getNewTagField().setText("");
            }
        }
    }

    /**
     * Listener on cancel button
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getMyProfileComponent().getController().getPopUp().dispose();
        }
    }

    /**
     * Listener on submit button
     * If all the compulsory fields aren't checked, an error message is shown.
     * If all the compulsory fields are checked, we use the API of musique module.
     * And finally, we update the user pofil
     * If the importation fails, a warning message is shown
     */
    public class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Submit");
            WindowComponent win = WindowComponent.getInstance();
            ImportSongPopUpView view = ImportSongPopUpController.this.getView();
            List<String> tag = view.getTagList().getSelectedValuesList();

            Boolean isImport = false;

            if (!ImportSongPopUpController.this.checkAllCompulsoryFields()){
                JOptionPane.showMessageDialog(
                        view,
                        "Tous les champs obligatoires doivent être renseignés !",
                        "Attention aux champs",
                        JOptionPane.WARNING_MESSAGE);
            }
            else {
                isImport = win.getApiMusic().importSong(
                        view.getFileField().getText(),
                        view.getTitleField().getText(),
                        view.getArtistField().getText(),
                        view.getAlbumField().getText(),
                        new LinkedList<String>(view.getTagList().getSelectedValuesList()),
                        null);

                if (isImport) {
                    win.getMyProfileComponent().getController().new MySongsListener().actionPerformed(null); // ligne à supprimer si possible
                }
                else {
                    JOptionPane.showMessageDialog(
                        view,
                        "Le fichier n'a pas pu être importé !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                }
                win.getMyProfileComponent().getController().getPopUp().dispose();
            }

        }
    }

    /**
     * Checks if all the compulsory fields are filled
     * @return boolean
     */
    public boolean checkAllCompulsoryFields(){
        ArrayList<JTextField> listCompulsoryFields = this.getView().getListCompulsoryFields();

        for (int i=0; i<listCompulsoryFields.size(); i++){
            if ( listCompulsoryFields.get(i).getText().length() <= 0 ) {
                return false;
            }
        }

        return true;
    }
}
