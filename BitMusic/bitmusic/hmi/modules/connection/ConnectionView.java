/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.connection;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import hmi.others.AbstractView;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class ConnectionView extends AbstractView {
    private ConnectionController connectionController;

    public ConnectionView(ConnectionController connectionController) {
        initPanel();
    }

    @Override
    protected void initPanel() {
        JPanel window = new JPanel();
        //JFrame frame = new JFrame();
        //thi.setSize(500, 500);
        
        Dimension d = new Dimension(80, 20);
        
        String connection = "Connexion";
        String pseudo = "Pseudo: ";
        String password = "Mot de passe: ";
        String connect = "Se connecter";
        String reset = "Reinitialiser";
        String createAccount = "Creer un compte";
        
        JLabel titleLabel = new JLabel(connection);
        
        JLabel passwordLabel = new JLabel(password);
        JLabel pseudoLabel = new JLabel(pseudo);
        titleLabel.setSize(d);
        pseudoLabel.setSize(d);
        passwordLabel.setSize(d);       
        
        JButton connectButton = new JButton(connect);
        JButton resetButton = new JButton(reset);
        JButton createAccountButton = new JButton(createAccount);
        connectButton.setSize(d);
        resetButton.setSize(d);
        createAccountButton.setSize(d);
        
        JTextField pseudoTextField = new JTextField("");
        pseudoTextField.setColumns(10);
        JTextField passwordTextField = new JTextField("kkajk");
        //passwordTextField.setSize(d);
        passwordTextField.setColumns(10);
        
        window.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //window.setLayout(new GridLayout(3, 2, 20, 20));
        window.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        
        //window.set
        window.add(titleLabel);
        window.add(pseudoLabel);
        window.add(pseudoTextField);
        window.add(passwordLabel);
        window.add(passwordTextField);
        window.add(connectButton);
        window.add(resetButton);
        window.add(createAccountButton);
        
        this.add(window);
    }
    
}
