/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.accountcreation.AccountCreationPopUpComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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

            if (model.doConnection(view.getLoginField().getText(), view.getPasswordField().getText()) == true) {
                WindowComponent win = WindowComponent.getInstance();
                // On enlève la ConnectionView des "objets utilisés"
                win.getWindowView().removeView(view);

                //On initialise tous les composants dans la vue principale
                win.initAllComponents();
            } else {
                JOptionPane.showMessageDialog(view, "Connexion refusée : pseudo et/ou mot de passe incorrect(s)", "Connexion refusée", JOptionPane.ERROR_MESSAGE);
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
            popUp.show();
        }
    }
}
