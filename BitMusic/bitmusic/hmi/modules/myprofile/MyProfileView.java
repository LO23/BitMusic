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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author unkedeuxke
 */
public final class MyProfileView extends AbstractView<MyProfileController> {

    private static final String type = "NORTH";

    private final JButton myProfileButton = new JButton("Mon Profil");
    private final JButton mySongsButton = new JButton("Mes morceaux");
    private final JButton disconnectButton = new JButton("Déconnexion");
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
        return disconnectButton;
    }

    public JButton getImportSongButton() {
        return importSongButton;
    }

    @Override
    public void initPanel() {
        System.out.println("--- MyProfileView.initPanel()");

        Dimension d = new Dimension(80, 20);

        this.myProfileButton.setSize(d);
        this.mySongsButton.setSize(d);
        this.disconnectButton.setSize(d);
        this.importSongButton.setSize(d);



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

