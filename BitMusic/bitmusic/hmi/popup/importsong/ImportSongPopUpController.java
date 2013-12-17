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
 * Classe du controlleur de ImportSongPopUp
 * @author IHM
 */
public final class ImportSongPopUpController extends AbstractController<ImportSongPopUpModel, ImportSongPopUpView> {

    /**
     * Contructeur de ImportSongPopUpController
     * @param model
     * @param view
     */
    public ImportSongPopUpController(final ImportSongPopUpModel model, final ImportSongPopUpView view) {
        super(model, view);
    }

    /**
     * Listener sur le bouton parcourir permettant de selectionner le path du morceau à importer
     * Après récupération du path du fichier, grâce à un filtre, on vérifie si le fichier choisi est de type mp3
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
     * Listener sur le bouton ajouter un tag
     * Cela permet d'ajouter un tag au morceau à importer
     * Si le tag peut être pris en compte(c'est à dire n'est pas une chaine vide), il est ajouté au modèle et la vue est mise à jour
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
     * Listener sur le bouton annuler de la PopUp
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getMyProfileComponent().getController().getPopUp().dispose();
        }
    }

    /**
     * Listener sur le bouton valider
     * Si tous les champs obligatoires ne sont pas saisis, un message d'avertissement est declenché
     * Si tous les champs obligatoires sont mentionnés, on fait appel à l'API du module Musique
     * En passant comme paramètres : titre, artiste, album, path et tags du morceau
     * Et finalement, on met à jour le profil de l'utilisateur
     * Si l'importation du morceau échoue, un message d'avertissement est declenché
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
     * Fonction verifiant si tous les champs obligatoires ont été mentionnés
     * @return true si tous les champs obligatoires ont été mentionnés
     * @return false sinon
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
