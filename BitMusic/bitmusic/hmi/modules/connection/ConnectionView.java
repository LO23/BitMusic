/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.connection;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import hmi.patterns.AbstractController;
import hmi.patterns.AbstractView;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class ConnectionView extends AbstractView {

    public ConnectionView(AbstractController abstractController) {
        super(abstractController);
        this.initPanel();
    }

    @Override
    protected void initPanel() {
        this.panel = new JPanel();
        Dimension d = new Dimension(80, 20);
        
        JLabel connectionLabel = new JLabel("Connexion");
        connectionLabel.setSize(d);
        
        JLabel loginLabel = new JLabel("Pseudo");
        loginLabel.setSize(d);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setSize(d);
        
        JButton connectButton = new JButton("Se connecter");
        connectButton.setSize(d);
        
        JButton resetButton = new JButton("Réinitialiser");
        resetButton.setSize(d);
        
        JButton createUserButton = new JButton("Créer un compte");
        createUserButton.setSize(d);
        
        JTextField loginField = new JTextField("");
        loginField.setColumns(10);
        
        JPasswordField passwordField = new JPasswordField("");
        passwordField.setColumns(10);
        
        GroupLayout layout = new GroupLayout(this.panel);
        this.panel.setLayout(layout);
        
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
