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
import java.awt.GridLayout;
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

    private final JButton myProfileButton = new JButton("Mon Profil");
    private final JButton mySongsButton = new JButton("Mes morceaux");
    private final JButton logoutButton = new JButton("Déconnexion");
    private final JButton importSongButton = new JButton("Importer un titre");
    private final ImageIcon avatarImage = new ImageIcon(this.getClass().getResource("/images/avatar3.png"));
    private JLabel avatarLabel;
    // TO DO : ajouter l'image de l'avatar

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


        this.mySongsButton.setSize(d);
        this.logoutButton.setSize(d);
        this.logoutButton.addActionListener(this.getController().new LogoutListener());

        this.importSongButton.setSize(d);
        this.importSongButton.addActionListener(this.getController().new ImportNewSongListener());

        /*GridLayout layout = new GridLayout(0,2);
        layout.setHgap(5);
        layout.setVgap(5);

        this.getPanel().setLayout(layout);

        this.getPanel().add(this.myProfileButton);
        this.getPanel().add(this.mySongsButton);
        this.getPanel().add(this.logoutButton);
        this.getPanel().add(this.importSongButton);
        System.out.println("--- ImageIcon.init(), size : " + avatarImage.getIconHeight());
        this.getPanel().add(this.avatarLabel);*/


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
                    .addComponent(this.importSongButton))

        );

        layout.setAutoCreateGaps(true);
        layout.linkSize(SwingConstants.HORIZONTAL, this.myProfileButton, this.mySongsButton);
        layout.linkSize(SwingConstants.HORIZONTAL, this.myProfileButton, this.logoutButton);
        layout.linkSize(SwingConstants.HORIZONTAL, this.myProfileButton, this.importSongButton);
        // TOFINISH
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

