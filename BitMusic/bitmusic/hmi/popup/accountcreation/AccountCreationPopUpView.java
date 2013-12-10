/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.toedter.calendar.JDateChooser;
/**
 * <b> AccountCreationPopUpView est la classe de la vue de la fenêtre de connexion</br>
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

    /**
     * Constructeur de la vue
     */
    public AccountCreationPopUpView() {
        super();
    }

    /**
     *
     */
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

    /**
     * Le type de la PopUp correspend à son emplacement dans l'écran
     * @return Le type de la popup
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Mis à jour de la vue
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- AccountCreationPopUp.update() -> " + str);
    }

    /**
     * Retourne le login de l'utilisateur.
     * @return Le login de l'utilisateur, sous forme d'un JTextField.
     */
    public JTextField getLoginField() {
        return loginField;
    }

    /**
     * Met à jour le login de l'utilisateur.
     * @param loginField
     *                  Le nouveau Login de l'utilisateur.
     */
    public void setLoginField(JTextField loginField) {
        this.loginField = loginField;
    }

    /**
     * Retourne la date de naissance de l'utilisateur.
     * @return La date de naissance de l'utilisateur, sous forme d'un JTextField.
     */
    public JTextField getBirthdateField() {
        return birthdateField;
    }

    /**
     * Met à jour la date de naissance de l'utilisateur.
     * @param birthdateField
     *                      Date de naissance de l'utilisateur.
     */
    public void setBirthdateField(JTextField birthdateField) {
        this.birthdateField = birthdateField;
    }

    /**
     * Retourne le mot de passe saisi.
     * @return Le mot de passe saisi, sous forme d'un JTextField.
     */
    public JTextField getPasswordField() {
        return passwordField;
    }

    /**
     * Met à jour le mot de passe de l'utilisateur.
     * @param passwordField
     *                      Mot de passe de l'utilisateur.
     */
    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Retourne la confirmation du mot de passe saisi.
     * @return la confirmation du mot de passe saisi, sous forme d'un JTextField.
     */
    public JTextField getConfirmField() {
        return confirmField;
    }

    /**
     * Met à jour la confirmation du mot de passe.
     * @param confirmField
     *                    Champs de confirmation du mot de passe.
     */
    public void setConfirmField(JTextField confirmField) {
        this.confirmField = confirmField;
    }

    /**
     * Retourne le prénom de l'utilisateur.
     * @return le prénom de l'utilisateur sous forme d'un JTextField.
     */
    public JTextField getFirstnameField() {
        return firstnameField;
    }

    /**
     * Met à jour le prénom de l'utilisateur.
     * @param firstnameField
     *                      Nom de l'utilisateur.
     */
    public void setFirstnameField(JTextField firstnameField) {
        this.firstnameField = firstnameField;
    }

    /**
     * Retourne le nom de l'utilisateur.
     * @return le nom de l'utilisateur sous forme d'un JTextField
     */
    public JTextField getLastnameField() {
        return lastnameField;
    }

    /**
     * Met à jour le nom de l'utilisateur
     * @param lastnameField
     *                  Nom de l'utilisateur.
     */
    public void setLastnameField(JTextField lastnameField) {
        this.lastnameField = lastnameField;
    }

    /**
     * Retourne le path de l'avatar.
     * @return le path de l'avatar sous forme d'un JTextField.
     */
    public JTextField getAvatarField() {
        return avatarField;
    }

    /**
     * Met à jour le path de l'avatar
     * @param avatarField
     *              Path de l'avatar
     */
    public void setAvatarField(JTextField avatarField) {
        this.avatarField = avatarField;
    }

    /**
     *
     * @return
     */
    public ArrayList<JTextField> getListCompulsoryFields() {
        return listCompulsoryFields;
    }

    /**
     *
     * @param listCompulsoryFields
     */
    public void setListCompulsoryFields(ArrayList<JTextField> listCompulsoryFields) {
        this.listCompulsoryFields = listCompulsoryFields;
    }


}
