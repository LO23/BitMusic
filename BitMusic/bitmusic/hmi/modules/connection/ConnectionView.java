/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.util.ArrayList;
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
    private final JLabel connectionLabel = new JLabel("<html><u>Connexion à l'application BitMusic</u></htlm>");
    private final JLabel loginLabel = new JLabel("Pseudo");
    private final JLabel passwordLabel = new JLabel("Mot de passe");
    private final JButton connectButton = new JButton("Se connecter");
    private final JButton resetButton = new JButton("Réinitialiser");
    private final JButton createUserButton = new JButton("Créer un compte");
    private JTextField loginField = new JTextField("");
    private JPasswordField passwordField = new JPasswordField("");

    private ArrayList<JTextField> listCompulsoryFields = new ArrayList<>();

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

        this.listCompulsoryFields.add(loginField);
        this.listCompulsoryFields.add(passwordField);

        this.resetButton.addActionListener(this.getController().new ResetListener());
        this.connectButton.addActionListener(this.getController().new ConnectionListener());
        this.createUserButton.addActionListener(this.getController().new CreateNewUserListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createUserButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordLabel)
                                    .addComponent(loginLabel))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwordField)
                                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(connectButton)
                    .addComponent(createUserButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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

    public ArrayList<JTextField> getListCompulsoryFields() {
        return listCompulsoryFields;
    }

    public void setListCompulsoryFields(ArrayList<JTextField> listCompulsoryFields) {
        this.listCompulsoryFields = listCompulsoryFields;
    }



}
