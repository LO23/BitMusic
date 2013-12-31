/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.accountcreation.AccountCreationPopUpComponent;
import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Controller class of connection
 * @author IHM
 */
public final class ConnectionController extends AbstractController<ConnectionModel, ConnectionView> {

    private JDialog popUp;

    /**
     * Constructor of ConnectionController
     * @param model
     * @param view
     */
    public ConnectionController(final ConnectionModel model, final ConnectionView view) {
        super(model, view);
    }

    /**
     * Returns a pop up
     * @return popUp
     */
    public JDialog getPopUp() {
        return this.popUp;
    }

    /**
     * Updates a pop up
     * @param popUp
     */
    public void setPopUp(JDialog popUp) {
        this.popUp = popUp;
    }

    /**
     * Listener of connection button
     */
    public class ConnectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Connection");

            ConnectionModel model = ConnectionController.this.getModel();
            ConnectionView view = ConnectionController.this.getView();

            if ( !ConnectionController.this.checkAllCompulsoryFields() ){
                JOptionPane.showMessageDialog(
                        view,
                        "Tous les champs obligatoires doivent être renseignés !",
                        "Attention aux champs",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Boolean isRightPass = false;

            try {
                isRightPass = model.doConnection(view.getLoginField().getText(), view.getPasswordField().getText());
            } catch (ProfileExceptions ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
                //TODO : à supprimer quand Profile aura supprimé son exception !
                JOptionPane.showMessageDialog(
                        view,
                        "Erreur de vérification du mot de passe",
                        "Erreur de profile",
                        JOptionPane.WARNING_MESSAGE);
            }


            if ( isRightPass ) {
                WindowComponent win = WindowComponent.getInstance();
                // On enlève la ConnectionView des "objets utilisés"
                win.getWindowView().removeView(view);

                //On initialise tous les composants dans la vue principale
                win.initAllComponents();
                //On démarre le network
                win.startNetwork();
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
    /**
     * Listener on enterkey button
     */
    public class EnterKeyListener implements KeyListener {
        /**
         * if the enterkey button is typed
         * @param ke
         */
        @Override
        public void keyTyped(KeyEvent ke) {}

        /**
         * if the enterkey button is pressed
         * @param ke
         */
        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode()==KeyEvent.VK_ENTER){
                ConnectionController.this.new ConnectionListener().actionPerformed(null);
            }
        }

        /**
         * if the enterkey is released
         * @param ke
         */
        @Override
        public void keyReleased(KeyEvent ke) {}

    }

    /**
     * Listener on reset button
     */
    public class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Reset");

            // Pas besoin du Model ici : on agit directement sur la View
            ConnectionController.super.getView().getLoginField().setText("");
            ConnectionController.super.getView().getPasswordField().setText("");
        }
    }

    /**
     * Listener on create user button
     */
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

    /**
     * Checks all the compulsory fields
     * @return
     */
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
