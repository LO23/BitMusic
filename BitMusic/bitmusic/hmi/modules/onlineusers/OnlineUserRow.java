/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.profile.classes.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author unkedeuxke
 */
public class OnlineUserRow {
    private User user;
    private JButton infosBtn;
    private JButton userSongsBtn;

    public OnlineUserRow(final User user) {
        this.user = user;
        this.infosBtn = new JButton("i");
        this.userSongsBtn = new JButton("MP3");

        this.infosBtn.addActionListener(this.new InfosListener());
        this.userSongsBtn.addActionListener(this.new UserSongsListener());
    }

    public class InfosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("- Infos d'un utilisateur demandées");

            // TODO : déclencher l'ouverture d'une PopUp avec les infos du User
            // WindowComponent win = WindowComponent.getInstance();
        }
    }

    public class UserSongsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("- Morceaux d'un utilisateur demandées");

            // TODO : déclencher l'ouverture d'un TabComponent où les morceaux du User sont demandés
            // WindowComponent win = WindowComponent.getInstance();
        }
    }

    public User getUser() {
        return this.user;
    }

    public JButton getInfosBtn() {
        return this.infosBtn;
    }

    public JButton getUserSongsBtn() {
        return this.userSongsBtn;
    }
}
