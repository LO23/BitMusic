/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    private final ImageIcon avatarImage = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/myprofile/images/defaultAvatar_120.png"));
    private JLabel avatarLabel;
    // TODO : récupérer l'image de l'avatar (pas en dur)

    public MyProfileView() {
        super();
        this.avatarImage.setDescription("Votre avatar");
        this.avatarLabel = new JLabel("", this.avatarImage, JLabel.CENTER);
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

        final Dimension d = new Dimension(80, 10);

        this.myProfileButton.setSize(d);
        this.myProfileButton.addActionListener(this.getController().new ModifyProfileListener());

        this.mySongsButton.setSize(d);

        this.logoutButton.setSize(d);
        this.logoutButton.addActionListener(this.getController().new LogoutListener());

        this.importSongButton.setSize(d);
        this.importSongButton.addActionListener(this.getController().new ImportNewSongListener());

        this.avatarLabel.setToolTipText("Avatar");
        this.avatarLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.avatarLabel.setAlignmentY(CENTER_ALIGNMENT);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.myProfileButton)
                    .addComponent(this.mySongsButton)
                    .addComponent(this.importSongButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.logoutButton)
                    .addComponent(this.avatarLabel)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.myProfileButton)
                    .addComponent(this.logoutButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   // .addComponent(this.logoutButton)
                    .addComponent(this.avatarLabel)
                    .addComponent(this.mySongsButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.importSongButton)
                )
        );

        layout.setAutoCreateGaps(true);
        layout.linkSize(SwingConstants.HORIZONTAL, this.myProfileButton, this.mySongsButton);
        layout.linkSize(SwingConstants.HORIZONTAL, this.myProfileButton, this.logoutButton);
        layout.linkSize(SwingConstants.HORIZONTAL, this.myProfileButton, this.importSongButton);
        // TO FINISH
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

