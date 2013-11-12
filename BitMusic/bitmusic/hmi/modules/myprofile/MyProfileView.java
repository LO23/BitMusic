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

    public MyProfileView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- MyProfileView.initPanel()");

        Dimension d = new Dimension(80, 20);

        JLabel createAccountLabel = new JLabel("Créer un compte");
        createAccountLabel.setSize(d);

        JLabel loginLabel = new JLabel("Pseudo (*)");
        loginLabel.setSize(d);

        JLabel passwordLabel = new JLabel("Mot de passe (*)");
        passwordLabel.setSize(d);

        JLabel confirmationLabel = new JLabel("Confirmation (*)");
        confirmationLabel.setSize(d);

        JLabel prenomLabel = new JLabel("Prénom ");
        prenomLabel.setSize(d);

        JLabel nomLabel = new JLabel("Nom ");
        nomLabel.setSize(d);

        JButton connectButton = new JButton("Se connecter");
        connectButton.setSize(d);

        JButton resetButton = new JButton("Réinitialiser");
        resetButton.setSize(d);

        JTextField loginField = new JTextField("");
        loginField.setColumns(10);

        JPasswordField passwordField = new JPasswordField("");
        passwordField.setColumns(10);

        JPasswordField confirmationField = new JPasswordField("");
        confirmationField.setColumns(10);

        JTextField prenomField = new JTextField("");
        prenomField.setColumns(10);

        JTextField nomField = new JTextField("");
        nomField.setColumns(10);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(createAccountLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(passwordLabel)
                    .addComponent(confirmationLabel)
                    .addComponent(prenomLabel)
                    .addComponent(nomLabel)
                    .addComponent(connectButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(loginField)
                    .addComponent(passwordField)
                    .addComponent(confirmationField)
                    .addComponent(prenomField)
                    .addComponent(nomField)
                    .addComponent(resetButton)
                )

        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
               .addComponent(createAccountLabel)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmationLabel)
                    .addComponent(confirmationField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomLabel)
                    .addComponent(prenomField)
               )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nomField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(resetButton)
               )

        );

        layout.linkSize(SwingConstants.HORIZONTAL, loginLabel, loginField);
        layout.linkSize(SwingConstants.HORIZONTAL, passwordLabel, passwordField);
        layout.linkSize(SwingConstants.HORIZONTAL, confirmationLabel, confirmationField);
        layout.linkSize(SwingConstants.HORIZONTAL, prenomLabel, prenomField);
        layout.linkSize(SwingConstants.HORIZONTAL, nomLabel, nomField);

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

