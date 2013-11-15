/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class ConnectionView extends AbstractView<ConnectionController> {

    private final String type = "CONNECTION";
    private final JLabel connectionLabel = new JLabel("Connexion");
    private final JLabel loginLabel = new JLabel("Pseudo");
    private final JLabel passwordLabel = new JLabel("Mot de passe");
    private final JButton connectButton = new JButton("Se connecter");
    private final JButton resetButton = new JButton("Réinitialiser");
    private final JButton createUserButton = new JButton("Créer un compte");
    private final JTextField loginField = new JTextField("");
    private final JPasswordField passwordField = new JPasswordField("");

    public ConnectionView() {
        super();
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void initPanel() {
        System.out.println("--- ConnectionView.initPanel()");

        final Dimension d = new Dimension(80, 20);

        this.connectionLabel.setSize(d);
        this.loginLabel.setSize(d);
        this.passwordLabel.setSize(d);
        this.connectButton.setSize(d);
        this.resetButton.setSize(d);
        this.createUserButton.setSize(d);

        this.loginField.setColumns(10);
        this.passwordField.setColumns(10);

        this.connectButton.addActionListener(this.getController().new ConnectionListener());
        this.resetButton.addActionListener(this.getController().new ResetListener());
        this.createUserButton.addActionListener(this.getController().new CreateNewUserListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(connectionLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(passwordLabel)
                    .addComponent(connectButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(loginField)
                    .addComponent(passwordField)
                    .addComponent(resetButton)
                )
                .addComponent(createUserButton)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
               .addComponent(connectionLabel)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(resetButton)
               )
               .addComponent(createUserButton)
        );

        layout.linkSize(SwingConstants.HORIZONTAL, loginLabel, loginField);
        layout.linkSize(SwingConstants.HORIZONTAL, passwordLabel, passwordField);
    }

    public JLabel getConnectionLabel() {
        return this.connectionLabel;
    }

    public JLabel getLoginLabel() {
        return this.loginLabel;
    }

    public JLabel getPasswordLabel() {
        return this.passwordLabel;
    }

    public JButton getConnectButton() {
        return this.connectButton;
    }

    public JButton getResetButton() {
        return this.resetButton;
    }

    public JButton getCreateUserButton() {
        return this.createUserButton;
    }

    public JTextField getLoginField() {
        return this.loginField;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ConnectionView.update()");
    }
}
