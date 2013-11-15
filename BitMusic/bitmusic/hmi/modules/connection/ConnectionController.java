/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.onlineusers.OnlineUsersComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.modules.accountcreation.AccountCreationComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class ConnectionController extends AbstractController<ConnectionModel, ConnectionView> {

    public ConnectionController(final ConnectionModel model, final ConnectionView view) {
        super(model, view);
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
                win.getWindowView().removeView(ConnectionController.this.getView());

                // TODO : Création des différents Components...

                // Création du OnlineUsersComponent et attache de la View aux "objets utilisés"
                win.setOnlineUsersComponent(new OnlineUsersComponent());
                win.getWindowView().addView(win.getOnlineUsersComponent().getView());

                // Récupérer une liste des utilisateurs déjà connectés et la passer au OnlineUsersModel
                // TODO : en attente de la disponibilité de la méthode dans l'API
                // ArrayList<User> currentOnlineUsers = win.getApiNetwork().getListUser();
                // onlineUsersComponent.getModel().setListUsersOnline(currentOnlineUsers);

                // NB : Pas besoin de prévenir Network qu'on s'est connecté, Profile le fait lors de l'appel à doConnection()
                // => on est censé recevoir un notifyNewConnection() de Network pour notre propre connection

            } else {
                JOptionPane.showMessageDialog(ConnectionController.this.getView(), "Connexion refusée : pseudo et/ou mot de passe incorrect(s)", "Connexion refusée", JOptionPane.ERROR_MESSAGE);
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

    /// listener du bouton 'creer un compte'
    public class CreateNewUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton CreateNewUser");

            ConnectionModel model = ConnectionController.this.getModel();
            WindowComponent win = WindowComponent.getInstance();

            // On enlève la ConnectionView des "objets utilisés"
            win.getWindowView().removeView(ConnectionController.this.getView());

            // Création du OnlineUsersComponent et attache de la View aux "objets utilisés"
            win.setAccountCreationComponent(new AccountCreationComponent());
            win.getWindowView().addView(win.getAccountCreationComponent().getView());
        }
    }
}
