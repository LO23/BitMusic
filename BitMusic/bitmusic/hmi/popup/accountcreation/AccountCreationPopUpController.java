/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.profile.utilities.ProfileExceptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe du controlleur de la AccountCreationPopUp
 * @author IHM
 */
public final class AccountCreationPopUpController extends AbstractController<AccountCreationPopUpModel, AccountCreationPopUpView> {

    /**
     * Constructeur
     * @param model
     *              Modèle
     * @param view
     *              Vue
     */
    public AccountCreationPopUpController(final AccountCreationPopUpModel model, final AccountCreationPopUpView view) {
        super(model, view);
    }

    /**
     * Listener sur le bouton Parcourir pour la récupération de l'avatar
     */
    public class AvatarBrowseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Parcourir");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers images", "bmp", "BMP", "png", "PNG", "jpg", "JPG", "jpeg", "JPEG");
            chooser.setFileFilter(filter);

            int returnVal = chooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("---- OK");
                AccountCreationPopUpController.this.getView().getAvatarField().setText(chooser.getSelectedFile().getPath());
            }
        }
    }

    /**
     * Listener sur le bouton Annuler pour l'annulation
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getConnectionComponent().getController().getPopUp().dispose();
        }
    }

    /**
     * Listener sur le bouton créer pour la création d'un nouvel utilisateur.
     */
    public class CreateNewUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Créer");

            WindowComponent win = WindowComponent.getInstance();
            AccountCreationPopUpView view = AccountCreationPopUpController.this.getView();

            //login password firstname lastname birth avatar
            String login = view.getLoginField().getText();
            String password = view.getPasswordField().getText();
            String confirm = view.getConfirmField().getText();
            String firstname = view.getFirstnameField().getText();
            String lastname = view.getLastnameField().getText();
            String birthdate = view.getBirthdateField().getText();
            String avatar = view.getAvatarField().getText();

            //Avatar par défault
            if ( avatar.length() <= 0 ) {
                try {
                    String current = new java.io.File(".").getCanonicalPath();
                    avatar = current +
                            File.separator +
                            "Bitmusic" +
                            File.separator +
                            "bitmusic" +
                            File.separator +
                            "hmi" +
                            File.separator +
                            "modules" +
                            File.separator +
                            "myprofile" +
                            File.separator +
                            "images" +
                            File.separator +
                            "defaultAvatar_120.png";
                    //System.out.println("----> " + avatar);
                } catch (IOException ex) {
                    //Logger.getLogger(AccountCreationPopUpController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(
                        view,
                        "Création impossible !",
                        "Erreur d'accès fichier",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if ( !password.equals(confirm) ) {
                JOptionPane.showMessageDialog(
                    view,
                    "Les deux mots de passe entrés ne concordent pas !",
                    "Erreur de mot de passe",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if ( !AccountCreationPopUpController.this.checkAllCompulsoryFields() ) {
                JOptionPane.showMessageDialog(
                    view,
                    "Tous les champs obligatoires doivent être renseignés !",
                    "Attention aux champs",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);

            // Permet de vérifier si le format de la date est correct
            try {
                cal.setTime(sdf.parse(birthdate));
            } catch (ParseException ex) {
                //Logger.getLogger(ModifyProfilePopUpController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                    view,
                    "Le format de la date n'est pas valide !",
                    "Erreur de date",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                //login password firstname lastname birth avatar
                win.getApiProfile().createUser(login, password, firstname, lastname, cal, avatar);
                win.getConnectionComponent().getController().getPopUp().dispose();
            } catch (ProfileExceptions ex) {
                //Logger.getLogger(AccountCreationPopUpController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                    view,
                    "Erreur : le compte n'a pas pu être créé !",
                    "Erreur de création",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     *
     * @return
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

    /**
     * Listener sur le bouton Réinitialiser pour réinitialiser tous les champs
     */
    public class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Reset");

            // Pas besoin du Model ici : on agit directement sur la View
            AccountCreationPopUpController.this.getView().getAvatarField().setText("");
            AccountCreationPopUpController.this.getView().getBirthdateField().setText("");
            AccountCreationPopUpController.this.getView().getConfirmField().setText("");
            AccountCreationPopUpController.this.getView().getFirstnameField().setText("");
            AccountCreationPopUpController.this.getView().getLastnameField().setText("");
            AccountCreationPopUpController.this.getView().getLoginField().setText("");
            AccountCreationPopUpController.this.getView().getPasswordField().setText("");
        }
    }
}
