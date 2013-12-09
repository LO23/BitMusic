/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationsuser;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.profile.classes.User;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author unkedeuxke
 */
public final class InfosUserPopUpView extends AbstractView<InfosUserPopUpController> {

    private final String type = "POPUP";
    private final JLabel infosLabel = new JLabel("<html><u>Informations Utilisateur</u></html>");
    private JLabel firstnameLabel = new JLabel("");
    private JLabel lastnameLabel = new JLabel("");
    private JLabel oldLabel = new JLabel("");
    private JLabel inscriptionLabel = new JLabel("");
    

    private final JPanel avatarPanel = new JPanel();
    private final ImageIcon avatarImage = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/myprofile/images/defaultAvatar_120.png"));
    private JLabel avatarLabel = new JLabel("", this.avatarImage, JLabel.CENTER);

    public InfosUserPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- InfosUserPopUpView.initPanel()");

        this.avatarImage.setDescription("Votre avatar");
        this.avatarPanel.add( avatarLabel, BorderLayout.CENTER );

        User userTemp = this.getController().getModel().getUser();
        this.firstnameLabel.setText(userTemp.getFirstName());
        this.lastnameLabel.setText(userTemp.getLastName());
        this.oldLabel.setText(userTemp.getTransformedBirthday());
        //this.inscriptionLabel.setText(userTemp.get?);
        //this.avatarLabel.setIcon(new ImageIcon(userTemp.getAvatarPath()));

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstnameLabel)
                    .addComponent(lastnameLabel)
                    .addComponent(oldLabel)
                    .addComponent(inscriptionLabel))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(firstnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oldLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inscriptionLabel))
                    .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- InfosUserPopUpView.update() -> " + str);
    }
}
