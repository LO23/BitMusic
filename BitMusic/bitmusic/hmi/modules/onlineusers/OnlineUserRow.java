/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.profile.classes.User;
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

        OnlineUsersController controller = WindowComponent.getInstance().getOnlineUsersComponent().getController();
        this.infosBtn.addActionListener(controller.new InfosListener());
        this.userSongsBtn.addActionListener(controller.new UserSongsListener());
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
