/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private ImageIcon avatarImage;
    private JLabel avatarLabel;

    /**
     *
     */
    public MyProfileView() {
        super();
    }

    /**
     *
     * @return
     */
    public JButton getMyProfileButton() {
        return myProfileButton;
    }

    /**
     *
     * @return
     */
    public JButton getMySongsButton() {
        return mySongsButton;
    }

    /**
     *
     * @return
     */
    public JButton getDisconnectButton() {
        return logoutButton;
    }

    /**
     *
     * @return
     */
    public JButton getImportSongButton() {
        return importSongButton;
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- MyProfileView.initPanel()");

        ImageIcon avatar;
        String avatarPath = WindowComponent.getInstance().getApiProfile().getCurrentUser().getAvatarPath();
        if (avatarPath == "") {
            this.avatarImage = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/myprofile/images/defaultAvatar_120.png"));
        } else {
            this.avatarImage = new ImageIcon(avatarPath);
        }
        this.avatarLabel = new JLabel("", this.avatarImage, JLabel.CENTER);

        this.avatarImage.setDescription("Votre avatar");
        this.avatarPanel.add(avatarLabel, BorderLayout.CENTER);

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

    /**
     *
     * @return
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- MyProfileView.update() -> " + str);

        // On "force" l'actualisation immédiate de la View (utile dans le cas d'un changement d'avatar)
        ImageIcon avatar;
        String avatarPath = WindowComponent.getInstance().getApiProfile().getCurrentUser().getAvatarPath();
        if (avatarPath == "") {
            this.avatarImage = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/myprofile/images/defaultAvatar_120.png"));
        } else {
            this.avatarImage = new ImageIcon(avatarPath);
        }
        this.avatarLabel.setIcon(this.avatarImage);
    }
}

