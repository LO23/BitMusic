/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.modules.connection.ConnectionController.ConnectionListener;
import bitmusic.hmi.modules.connection.ConnectionController.CreateNewUserListener;
import bitmusic.hmi.modules.connection.ConnectionController.ResetListener;
import bitmusic.hmi.patterns.AbstractView;
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

    private static final String type = "CONNECTION";
    
    public ConnectionView() {
        super();
        this.initPanel();
    }
    
    public String getType(){
        return type;
    }
    
    @Override
    public void initPanel() {
        System.out.println("--- ConnectionView.initPanel()");
        Dimension d = new Dimension(80, 20);

        JLabel connectionLabel = new JLabel("Connexion");
        connectionLabel.setSize(d);

        JLabel loginLabel = new JLabel("Pseudo");
        loginLabel.setSize(d);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setSize(d);

        JButton connectButton = new JButton("Se connecter");
        connectButton.setSize(d);
        connectButton.addActionListener(new ConnectionListener());

        JButton resetButton = new JButton("Réinitialiser");
        resetButton.setSize(d);
        resetButton.addActionListener(new ResetListener());

        JButton createUserButton = new JButton("Créer un compte");
        createUserButton.setSize(d);
        createUserButton.addActionListener(new CreateNewUserListener());

        JTextField loginField = new JTextField("");
        loginField.setColumns(10);

        JPasswordField passwordField = new JPasswordField("");
        passwordField.setColumns(10);

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
}
