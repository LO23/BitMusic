/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpView;
import bitmusic.hmi.popup.modifyprofile.ModifyProfilePopUpController;
import bitmusic.profile.utilities.ProfileExceptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationPopUpController extends AbstractController<AccountCreationPopUpModel, AccountCreationPopUpView> {

    public AccountCreationPopUpController(final AccountCreationPopUpModel model, final AccountCreationPopUpView view) {
        super(model, view);
    }

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

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getConnectionComponent().getController().getPopUp().dispose();
        }
    }

    public class CreateNewUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Créer");

            WindowComponent win = WindowComponent.getInstance();
            AccountCreationPopUpView view = AccountCreationPopUpController.this.getView();
            Boolean canCreate = true;
            Boolean canClose = true;

            //login password firstname lastname birth avatar
            String login = view.getLoginField().getText();
            String password = view.getPasswordField().getText();
            String confirm = view.getConfirmField().getText();
            String firstname = view.getFirstnameField().getText();
            String lastname = view.getLastnameField().getText();
            String birthdate = view.getBirthdateField().getText();
            String avatar = view.getAvatarField().getText();

            if ( !password.equals(confirm) ) {
                canClose = false;
                canCreate = false;
                JOptionPane.showMessageDialog(
                        view,
                        "Les deux mots de passe entrés ne concordent pas !",
                        "Erreur dans la date",
                        JOptionPane.WARNING_MESSAGE);
            }

            else if ( AccountCreationPopUpController.this.checkAllCompulsoryFields() ){
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                //Permet de vérifier aisément si le format de la date est correcte !
                try {
                    cal.setTime(sdf.parse(birthdate));
                } catch (ParseException ex) {
                    Logger.getLogger(ModifyProfilePopUpController.class.getName()).log(Level.SEVERE, null, ex);
                    canClose = false;
                    canCreate = false;
                    JOptionPane.showMessageDialog(
                        view,
                        "Le format de la date n'est pas valide !",
                        "Erreur dans la date",
                        JOptionPane.WARNING_MESSAGE);
                }

                if ( canCreate ) {
                    try {
                        //login password firstname lastname birth avatar
                        win.getApiProfile().createUser(login, password, firstname, lastname, cal, avatar);
                    } catch (ProfileExceptions ex) {
                        Logger.getLogger(AccountCreationPopUpController.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(
                            view,
                            "Erreur : le compte n'a pas pu être créé !",
                            "Erreur dans la création",
                            JOptionPane.WARNING_MESSAGE);
                    }
                }

                if ( canClose ) {
                    win.getConnectionComponent().getController().getPopUp().dispose();
                }

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
}
