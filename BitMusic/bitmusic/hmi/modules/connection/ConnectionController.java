/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.onlineusers.OnlineUsersComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.api.ApiHmi;
import bitmusic.profile.User;
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
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Connection");

            ConnectionModel model = ConnectionController.this.getModel();

            if (model.doConnection() == true) {
                // On enlève le ConnectionComponent et la ConnectionView des "objets utilisés"
                WindowComponent.getInstance().removeComponent(WindowComponent.getInstance().getComponent("ConnectionComponent").get(0));
                WindowComponent.getInstance().getWindowView().removeView(ConnectionController.this.getView());
                // TODO : les supprimer ? (object = null;)

                // Création du OnlineUsersComponent et attache du Component et de la View aux "objets utilisés"
                OnlineUsersComponent onlineUsersComponent = new OnlineUsersComponent();
                WindowComponent.getInstance().addComponent(onlineUsersComponent);
                WindowComponent.getInstance().getWindowView().addView(onlineUsersComponent.getView());

                // TODO : Appel d'une méthode du model qui fait appel à une méthode de API network
                //         pour récupérer une liste des utilisateurs connectés
                ApiHmi apiHmi = new ApiHmi();
                apiHmi.notifyNewConnection(new User("MonLogin","MonMdP"));
            } else {
                JOptionPane.showMessageDialog(ConnectionController.this.getView(), "Connexion refusée : pseudo et/ou mot de passe incorrect(s)", "Connexion refusée", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Reset");

            // Pas besoin du Model ici : on agit directement sur la View
            ConnectionController.super.getView().getLoginField().setText("");
            ConnectionController.super.getView().getPasswordField().setText("");
        }
    }

    public class CreateNewUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton CreateNewUser");

            ConnectionModel model = ConnectionController.this.getModel();
            // TODO : implémenter la logique (appels aux méthodes du Model, ex : model.method())
        }
    }
}
