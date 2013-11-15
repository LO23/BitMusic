/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;

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
    // TO DO : ajouter l'image de l'avatar

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

        final Dimension d = new Dimension(80, 20);

        this.myProfileButton.setSize(d);
        this.mySongsButton.setSize(d);
        this.logoutButton.setSize(d);
        this.importSongButton.setSize(d);

        this.myProfileButton.addActionListener(this.getController().new LogoutListener());

        GridLayout layout = new GridLayout(0,2);
        this.getPanel().setLayout(layout);
        this.getPanel().add(myProfileButton);
        this.getPanel().add(mySongsButton);
        this.getPanel().add(logoutButton);
        this.getPanel().add(importSongButton);


        /*GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(myProfileButton)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mySongsButton)
                ).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                .addComponent(disconnectButton)
                    .addComponent(importSongButton)
        );*/
        // TODO
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

