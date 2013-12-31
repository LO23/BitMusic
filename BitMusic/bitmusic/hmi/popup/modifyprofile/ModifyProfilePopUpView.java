/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.modifyprofile;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.profile.classes.User;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * View class of ModifyProfilePopUp
 * @author IHM
 */
public final class ModifyProfilePopUpView extends AbstractView<ModifyProfilePopUpController> {

    private final String type = "POPUP";
    private final JLabel myProfileLabel = new JLabel("<html><u> Edition de mon profil</u></html>");
    private final JLabel firstNameLabel = new JLabel("Prénom ");
    private JTextField firstNameField = new JTextField("");
    private final JLabel lastNameLabel = new JLabel("Nom ");
    private JTextField lastNameField = new JTextField("");
    //private final JLabel birthLabel = new JLabel("Date de Naissance");
    //private JTextField birthField = new JTextField("");
    //private final JLabel birthFormatLabel = new JLabel("(Format : jj/mm/aaaa)");
    private final JLabel avatarLabel = new JLabel("Avatar");
    private final JButton avatarBrowseButton = new JButton("Parcourir...");
    private JTextField avatarField = new JTextField("");
    private final JButton submitButton = new JButton("Soumettre");
    private final JButton cancelButton = new JButton("Annuler");

    /**
     * Constructor of ModifyProfilePopUpView
     */
    public ModifyProfilePopUpView() {
        super();
    }

    /**
     * Initializes the view of ModifyProfilePopUp
     */
    @Override
    public void initPanel() {
        System.out.println("--- ModifyProfilePopUpView.initPanel()");

        // Remplissage avec les valeurs déjà enregistrées
        User ourProfile = WindowComponent.getInstance().getApiProfile().getCurrentUser();
        this.lastNameField.setText(ourProfile.getLastName());
        this.firstNameField.setText(ourProfile.getFirstName());
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //String strdate = sdf.format(ourProfile.getBirthDate().getTime());
        //this.birthField.setText(strdate);
        this.avatarField.setText(ourProfile.getAvatarPath());

        this.avatarBrowseButton.addActionListener(this.getController().new AvatarBrowseListener());
        this.cancelButton.addActionListener(this.getController().new CancelListener());
        this.submitButton.addActionListener(this.getController().new ModifyMyProfileListener());

        this.avatarField.setEditable(false);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                //.addComponent(birthLabel)
                                .addComponent(avatarLabel)
                                .addComponent(lastNameLabel)
                                .addComponent(firstNameLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                //.addComponent(birthField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(avatarField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(avatarBrowseButton)
                                //.addComponent(birthFormatLabel)
                            ))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(submitButton)))
                    .addComponent(myProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                /*.addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthLabel)
                    .addComponent(birthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthFormatLabel)
                )*/
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avatarLabel)
                    .addComponent(avatarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avatarBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(submitButton))
                .addContainerGap())
        );

    }

    /**
     * Returns the type of the PopUp
     * The type of the PopUp refers to its location in the screen
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Updates the view of ModifyProfilePopUpView
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ModifyProfilePopUpView.update() -> " + str);

        User ourProfile = WindowComponent.getInstance().getApiProfile().getCurrentUser();
        this.lastNameField.setText(ourProfile.getLastName());
        this.firstNameField.setText(ourProfile.getFirstName());
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //String strdate = sdf.format(ourProfile.getBirthDate().getTime());
        //this.birthField.setText(strdate);
        this.avatarField.setText(ourProfile.getAvatarPath());

        WindowComponent.getInstance().getMyProfileComponent().getModel().notifyObservers("Profile update");
    }

    /**
     * Returns first name of an user
     * @return JTextField firstNameField
     */
    public JTextField getFirstNameField() {
        return firstNameField;
    }

    /**
     * Updates first name of an user
     * @param firstNameField
     */
    public void setFirstNameField(JTextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    /**
     * Returns last name of an user
     * @return JTextField lastNameField
     */
    public JTextField getLastNameField() {
        return lastNameField;
    }

    /**
     * Updates last name of an user
     * @param lastNameField
     */
    public void setLastNameField(JTextField lastNameField) {
        this.lastNameField = lastNameField;
    }

    /**
     *
     * @return
     */
    /*public JTextField getBirthField() {
        return birthField;
    }*/

    /**
     *
     * @param birthField
     */
    /*public void setBirthField(JTextField birthField) {
        this.birthField = birthField;
    }*/

    /**
     * Returns avatar of an user
     * @return avatarField
     */
    public JTextField getAvatarField() {
        return avatarField;
    }

    /**
     * Updates avatar of an user
     * @param avatarField
     */
    public void setAvatarField(JTextField avatarField) {
        this.avatarField = avatarField;
    }

}