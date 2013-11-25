/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationsuser;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author unkedeuxke
 */
public final class InfosUserPopUpView extends AbstractView<InfosUserPopUpController> {

    private final String type = "POPUP";
    private final JLabel infosLabel = new JLabel("<html></u>Informations Utilisateur</u></html>");
    private JLabel firstnameLabel = new JLabel("Prénom");
    private JLabel lastnameLabel = new JLabel("Nom");
    private JLabel oldLabel = new JLabel("Age");
    private JLabel inscriptionLabel = new JLabel("inscrit depuis le 25/11/2013");

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
        System.out.println("----- InfosUserPopUpView.update()");
    }
}
