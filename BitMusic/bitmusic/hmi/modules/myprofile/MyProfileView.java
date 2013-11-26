/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author unkedeuxke
 */
public final class MyProfileView extends AbstractView<MyProfileController> {

    private static final String type = "NORTH";

    private final JButton myProfileButton = new JButton("Editer mon profil");
    private final JButton mySongsButton = new JButton("Mes morceaux");
    private final JButton logoutButton = new JButton("Déconnexion");
    private final JButton importSongButton = new JButton("Importer un titre");
    private final JPanel avatarPanel = new JPanel();
    private final ImageIcon avatarImage = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/myprofile/images/defaultAvatar_120.png"));
    private JLabel avatarLabel = new JLabel("", this.avatarImage, JLabel.CENTER);
    // TODO : récupérer l'image de l'avatar (pas en dur)

    public MyProfileView() {
        super();
    }

    public JButton getMyProfileButton() {
        return myProfileButton;
    }

    public JButton getMySongsButton() {
        return mySongsButton;
    }

    public JButton getDisconnectButton() {
        return logoutButton;
    }

    public JButton getImportSongButton() {
        return importSongButton;
    }

    @Override
    public void initPanel() {
        System.out.println("--- MyProfileView.initPanel()");

        this.avatarImage.setDescription("Votre avatar");
        this.avatarPanel.add( avatarLabel, BorderLayout.CENTER );

        this.myProfileButton.addActionListener(this.getController().new ModifyProfileListener());
        this.logoutButton.addActionListener(this.getController().new LogoutListener());
        this.importSongButton.addActionListener(this.getController().new ImportNewSongListener());
        this.mySongsButton.addActionListener(this.getController().new MySongsListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

                layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mySongsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mySongsButton)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importSongButton)
                    .addComponent(myProfileButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- MyProfileView.update()");
    }
}

