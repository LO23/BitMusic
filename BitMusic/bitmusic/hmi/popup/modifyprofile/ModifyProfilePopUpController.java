/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.modifyprofile;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author unkedeuxke
 */
public final class ModifyProfilePopUpController extends AbstractController<ModifyProfilePopUpModel, ModifyProfilePopUpView> {

    public ModifyProfilePopUpController(final ModifyProfilePopUpModel model, final ModifyProfilePopUpView view) {
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
                ModifyProfilePopUpController.this.getView().getAvatarField().setText(chooser.getSelectedFile().getPath());
            }
        }
    }


    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getMyProfileComponent().getController().getPopUp().dispose();
        }
    }

    public class ModifyMyProfileLister implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Submit");

            WindowComponent win = WindowComponent.getInstance();
            ModifyProfilePopUpView view = ModifyProfilePopUpController.this.getView();

            String prenom = view.getPrenomField().getText();
            String nom = view.getNomField().getText();
            String birthDate = view.getDateTextField().getText();
            String avatar = view.getAvatarField().getText();
            Boolean hasChanged = new Boolean(false);
            Boolean canModify = true;

            //Laisser ce if en première position !
            if ( birthDate.length() > 0 ) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                canModify = true;
                sdf.setLenient(false);
                //Permet de vérifier aisément si le format de la date est correcte !
                try {
                    cal.setTime(sdf.parse(birthDate));
                } catch (ParseException ex) {
                    Logger.getLogger(ModifyProfilePopUpController.class.getName()).log(Level.SEVERE, null, ex);
                    canModify = false;
                    JOptionPane.showMessageDialog(
                        view,
                        "<html>Le format de la date n'est pas valide !<br>Aucune modification n'a été effectuée !</html>",
                        "Erreur dans la date",
                        JOptionPane.WARNING_MESSAGE);
                }
                //win.getApiProfile().getCurrentUser().setBirthDate(cal);
                hasChanged = true;
            }

            if ( prenom.length() > 0 && canModify) {
                win.getApiProfile().getCurrentUser().setFirstName(prenom);
                hasChanged = true;
            }


            if ( nom.length() > 0 && canModify ) {
                win.getApiProfile().getCurrentUser().setLastName(nom);
                hasChanged = true;
            }

            if ( avatar.length() > 0 && canModify ) {
                win.getApiProfile().getCurrentUser().setAvatarPath(avatar);
                hasChanged = true;
            }

            if ( canModify ) {
                WindowComponent.getInstance().getMyProfileComponent().getController().getPopUp().dispose();
                //TODO : avertir les vues qui utilisent ces infos qu'il y a eu un changement !!
                // Je pense par exemple à l'image de l'avatar sur la vu MyProfile
            }

        }
    }

}
