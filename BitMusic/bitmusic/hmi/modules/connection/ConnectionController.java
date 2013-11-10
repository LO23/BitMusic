/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.hmi.patterns.AbstractView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class ConnectionController extends AbstractController {

    public ConnectionController(final AbstractModel abstractModel, final AbstractView abstractView) {
        super(abstractModel, abstractView);
    }

    public static class ConnectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Connection");
            // TODO : implémenter la logique (appels aux méthodes du Model)
        }
    }

    public static class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Reset");
            // TODO : implémenter la logique (appels aux méthodes du Model)
        }
    }

    public static class CreateNewUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton CreateNewUser");
            // TODO : implémenter la logique (appels aux méthodes du Model)
        }
    }
}
