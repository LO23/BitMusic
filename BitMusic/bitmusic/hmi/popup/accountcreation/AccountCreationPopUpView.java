/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import com.toedter.calendar.JDateChooser;
/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationPopUpView extends AbstractView<AccountCreationPopUpController> {

    private static final String type = "CENTER";
    private final JLabel accountCreationLabel = new JLabel("<html><u>Création d'un nouveau compte utilisateur</u></html>");
    private final JButton cancelButton = new JButton("Annuler");
    private final JButton resetButton = new JButton("Reinitialiser");
    private final JButton browseButton = new JButton("Parcourir...");
    private final JButton createUserButton = new JButton("Créer");
    private final JLabel birthdateLabel = new JLabel("Date de naissance (*)");
    private final JLabel loginLabel = new JLabel("Pseudo (*)");
    private final JLabel passwordLabel = new JLabel("Mot de passe (*)");
    private final JLabel confirmLabel = new JLabel("Confirmation (*)");
    private final JLabel firstnameLabel = new JLabel("Prénom");
    private final JLabel lastnameLabel = new JLabel("Nom");
    private final JLabel avatarLabel = new JLabel("Avatar");
    private final JLabel infosLabel = new JLabel("(*) Champs obligatoires");
    private final JLabel dateFormatLabel = new JLabel("(Format : dd/mm/aaaa)");
    private JTextField loginField = new JTextField("");
    private JTextField birthdateField = new JTextField("");
    private JTextField passwordField = new JPasswordField("");
    private JTextField confirmField = new JPasswordField("");
    private JTextField firstnameField = new JTextField("");
    private JTextField lastnameField = new JTextField("");
    private JTextField avatarField = new JTextField("");

    private ArrayList<JTextField> listCompulsoryFields = new ArrayList();


    public AccountCreationPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- AccountCreationPopUpView.initPanel()");

        this.listCompulsoryFields.add(loginField);
        this.listCompulsoryFields.add(birthdateField);
        this.listCompulsoryFields.add(passwordField);
        this.listCompulsoryFields.add(confirmField);

        this.browseButton.addActionListener(this.getController().new AvatarBrowseListener());
        this.cancelButton.addActionListener(this.getController().new CancelListener());
        this.createUserButton.addActionListener(this.getController().new CreateNewUserListener());
        this.resetButton.addActionListener(this.getController().new ResetListener());
        this.avatarField.setEditable(false);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

         layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accountCreationLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infosLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(createUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(birthdateLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstnameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastnameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avatarLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(birthdateField)
                            .addComponent(loginField)
                            .addComponent(firstnameField)
                            .addComponent(lastnameField)
                            .addComponent(avatarField)
                            .addComponent(passwordField)
                            .addComponent(confirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFormatLabel)
                            .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmLabel)
                    .addComponent(confirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameLabel)
                    .addComponent(firstnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameLabel)
                    .addComponent(lastnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateLabel)
                    .addComponent(birthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFormatLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avatarLabel)
                    .addComponent(avatarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(resetButton)
                    .addComponent(createUserButton))
                .addGap(18, 18, 18)
                .addComponent(infosLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- AccountCreationPopUp.update()");
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public void setLoginField(JTextField loginField) {
        this.loginField = loginField;
    }

    public JTextField getBirthdateField() {
        return birthdateField;
    }

    public void setBirthdateField(JTextField birthdateField) {
        this.birthdateField = birthdateField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public JTextField getConfirmField() {
        return confirmField;
    }

    public void setConfirmField(JTextField confirmField) {
        this.confirmField = confirmField;
    }

    public JTextField getFirstnameField() {
        return firstnameField;
    }

    public void setFirstnameField(JTextField firstnameField) {
        this.firstnameField = firstnameField;
    }

    public JTextField getLastnameField() {
        return lastnameField;
    }

    public void setLastnameField(JTextField lastnameField) {
        this.lastnameField = lastnameField;
    }

    public JTextField getAvatarField() {
        return avatarField;
    }

    public void setAvatarField(JTextField avatarField) {
        this.avatarField = avatarField;
    }

    public ArrayList<JTextField> getListCompulsoryFields() {
        return listCompulsoryFields;
    }

    public void setListCompulsoryFields(ArrayList<JTextField> listCompulsoryFields) {
        this.listCompulsoryFields = listCompulsoryFields;
    }


}
