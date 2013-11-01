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

/**
 *
 * @author hebergui, unkedeuxke
 */
public class ConnectionView extends AbstractView {
    private ConnectionController connectionController;
    
    public ConnectionView(AbstractController connectionController) {
        initPanel();
    }
    
    @Override
    protected void initPanel() {
        System.out.println("[ConnectionView] - Création de la connectionView");
        
        this.panel = new JPanel();
        Dimension d = new Dimension(80, 20);
        
        JLabel connectionLabel = new JLabel("Connexion");
        connectionLabel.setSize(d);
        this.panel.add(connectionLabel);
        
        JLabel loginLabel = new JLabel("Pseudo");
        loginLabel.setSize(d);
        this.panel.add(loginLabel);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setSize(d);  
        this.panel.add(passwordLabel);
        
        JButton connectButton = new JButton("Se connecter");
        connectButton.setSize(d);
        this.panel.add(connectButton);
        
        JButton resetButton = new JButton("Réinitialiser");
        resetButton.setSize(d);
        this.panel.add(resetButton);
        
        JButton createUserButton = new JButton("Créer un compte");
        createUserButton.setSize(d);
        this.panel.add(createUserButton);
        
        JTextField loginField = new JTextField("");
        loginField.setColumns(10);
        this.panel.add(loginField);
        
        JPasswordField passwordField = new JPasswordField("");
        passwordField.setColumns(10);
        this.panel.add(passwordField);
        
        
        //panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
    }
    
}
