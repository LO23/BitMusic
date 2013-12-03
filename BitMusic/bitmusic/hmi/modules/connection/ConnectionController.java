/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.accountcreation.AccountCreationPopUpComponent;
import bitmusic.profile.utilities.ProfileExceptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class ConnectionController extends AbstractController<ConnectionModel, ConnectionView> {

    private JDialog popUp;

    public ConnectionController(final ConnectionModel model, final ConnectionView view) {
        super(model, view);
    }

    public JDialog getPopUp() {
        return this.popUp;
    }

    public void setPopUp(JDialog popUp) {
        this.popUp = popUp;
    }

    public class ConnectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Connection");

            ConnectionModel model = ConnectionController.this.getModel();
            ConnectionView view = ConnectionController.this.getView();

            Boolean isRightPass = false;

            try {
                isRightPass = model.doConnection(view.getLoginField().getText(), view.getPasswordField().getText());
            } catch (ProfileExceptions ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        view,
                        "Erreur de vérification du mot de passe",
                        "Erreur de profile",
                        JOptionPane.WARNING_MESSAGE);
            }

            if ( !ConnectionController.this.checkAllCompulsoryFields() ){
                JOptionPane.showMessageDialog(
                        view,
                        "Tous les champs obligatoires doivent être renseignés !",
                        "Attention aux champs",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if ( isRightPass ) {
                WindowComponent win = WindowComponent.getInstance();
                // On enlève la ConnectionView des "objets utilisés"
                win.getWindowView().removeView(view);

                //On initialise tous les composants dans la vue principale
                win.initAllComponents();
            }
            else {
                JOptionPane.showMessageDialog(
                        view,
                        "Connexion refusée : pseudo et/ou mot de passe incorrect(s)",
                        "Connexion refusée",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Reset");

            // Pas besoin du Model ici : on agit directement sur la View
            ConnectionController.super.getView().getLoginField().setText("");
            ConnectionController.super.getView().getPasswordField().setText("");
        }
    }

    public class CreateNewUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton CreateNewUser");

            WindowComponent win = WindowComponent.getInstance();
            AccountCreationPopUpComponent accountCreationPopUpComponent = new AccountCreationPopUpComponent();

            popUp = new JDialog(win.getWindowView(), "Créer un compte", true);
            popUp.add(accountCreationPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();
        }
    }

    public boolean checkAllCompulsoryFields() {
        ArrayList<JTextField> listCompulsoryFields = this.getView().getListCompulsoryFields();

        for (int i=0; i<listCompulsoryFields.size(); i++){
            if ( listCompulsoryFields.get(i).getText().length() <= 0 ) {
                return false;
            }
        }

        return true;
    }
}
