/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.informationsuser.InfosUserPopUpComponent;
import bitmusic.profile.classes.User;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersController extends AbstractController<OnlineUsersModel, OnlineUsersView> {

    private JDialog popUp;

    public OnlineUsersController(final OnlineUsersModel model, final OnlineUsersView view) {
        super(model, view);
    }

    private Action infos = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            User user = ((OnlineUsersModel.OnlineUsersTableModel)table.getModel()).getUserAt(row);
            System.out.println("---- Clic sur Infos du User : " + user.getLogin());

            WindowComponent win = WindowComponent.getInstance();
            InfosUserPopUpComponent infosUserPopUpComponent = new InfosUserPopUpComponent(user);

            popUp = new JDialog(win.getWindowView(), "Afficher informations utilisateur", true);
            popUp.add(infosUserPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();
        }
    };

    private Action mp3 = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            User user = ((OnlineUsersModel.OnlineUsersTableModel)table.getModel()).getUserAt(row);
            System.out.println("---- Clic sur MP3 du User : " + user.getLogin());
        }
    };

    public Action getInfos() {
        return infos;
    }

    public Action getMp3() {
        return mp3;
    }
}
