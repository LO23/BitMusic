/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.profile.classes.User;
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

    public class ConnectUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- ConnectUserListener");
            WindowComponent.getInstance().getApiHmi().notifyNewConnection(new User("TestLogin","TestPswd"));
        }
    }
}
