/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.accountcreation;

import bitmusic.hmi.api.ApiHmi;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.connection.ConnectionController;
import bitmusic.hmi.modules.connection.ConnectionModel;
import bitmusic.hmi.modules.onlineusers.OnlineUsersComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.profile.classes.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationController extends AbstractController<AccountCreationModel, AccountCreationView> {

    public AccountCreationController(final AccountCreationModel model, final AccountCreationView view) {
        super(model, view);
    }
}
