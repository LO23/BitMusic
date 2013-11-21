/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersController extends AbstractController<OnlineUsersModel, OnlineUsersView> {

    public OnlineUsersController(final OnlineUsersModel model, final OnlineUsersView view) {
        super(model, view);
    }

    public class InfosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("- Infos d'un utilisateur demandées");

            // TODO
        }
    }

    public class UserSongsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("- Morceaux d'un utilisateur demandées");

            // TODO
        }
    }
}
