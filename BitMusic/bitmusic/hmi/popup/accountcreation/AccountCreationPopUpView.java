/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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
    private final JLabel createAccountLabel = new JLabel("Créer un compte");
    private final JLabel loginLabel = new JLabel("Pseudo (*)");
    private final JLabel passwordLabel = new JLabel("Mot de passe (*)");
    private final JLabel confirmationLabel = new JLabel("Confirmation (*)");
    private final JLabel prenomLabel = new JLabel("Prénom ");
    private final JLabel nomLabel = new JLabel("Nom ");
    private final JLabel birthLabel = new JLabel("Date de Naissance (*)");
    private final JLabel avatarLabel = new JLabel("Avatar");
    private final JButton validateButton = new JButton("Valider");
    private final JButton resetButton = new JButton("Réinitialiser");
    private final JButton cancelButton = new JButton("Annuler");
    private final JTextField loginField = new JTextField("");
    private final JPasswordField passwordField = new JPasswordField("");
    private final JPasswordField confirmationField = new JPasswordField("");
    private final JTextField prenomField = new JTextField("");
    private final JTextField nomField = new JTextField("");
    private final JButton avatarbrowseButton = new JButton("Parcourir...");
//    private final JDateChooser picker = new JDateChooser();

    public AccountCreationPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- AccountCreationPopUpView.initPanel()");

        final Dimension d = new Dimension(80, 20);

        this.createAccountLabel.setSize(d);
        this.loginLabel.setSize(d);
        this.passwordLabel.setSize(d);
        this.confirmationLabel.setSize(d);
        this.prenomLabel.setSize(d);
        this.nomLabel.setSize(d);
        this.birthLabel.setSize(d);
        this.avatarLabel.setSize(d);

        this.validateButton.setSize(d);
        this.resetButton.setSize(d);
        this.cancelButton.setSize(d);

        this.loginField.setColumns(10);
        this.passwordField.setColumns(10);
        this.confirmationField.setColumns(10);
        this.prenomField.setColumns(10);
        this.nomField.setColumns(10);

        this.avatarbrowseButton.setSize(d);
//        final JLabel path = new JLabel();
        avatarbrowseButton.addActionListener(this.getController().new AvatarBrowseListener());
//        file.showSaveDialog(this);

        this.cancelButton.addActionListener(this.getController().new CancelListener());

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
                    .addComponent(birthLabel)
                    .addComponent(avatarLabel)
                    .addComponent(validateButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(loginField)
                    .addComponent(passwordField)
                    .addComponent(confirmationField)
                    .addComponent(prenomField)
                    .addComponent(nomField)
//                    .addComponent(picker)
                    .addComponent(avatarbrowseButton)
                    .addComponent(resetButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
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
                    .addComponent(birthLabel)
                    //.addComponent(picker)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(avatarLabel)
                    .addComponent(avatarbrowseButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(validateButton)
                    .addComponent(resetButton)
                    .addComponent(cancelButton)
                )
        );

        layout.linkSize(SwingConstants.HORIZONTAL, loginLabel, loginField);
        layout.linkSize(SwingConstants.HORIZONTAL, passwordLabel, passwordField);
        layout.linkSize(SwingConstants.HORIZONTAL, confirmationLabel, confirmationField);
        layout.linkSize(SwingConstants.HORIZONTAL, prenomLabel, prenomField);
        layout.linkSize(SwingConstants.HORIZONTAL, nomLabel, nomField);
//        layout.linkSize(SwingConstants.HORIZONTAL, birthLabel, picker);
        layout.linkSize(SwingConstants.HORIZONTAL, avatarLabel, avatarbrowseButton);

        // TO FINISH AND TEST
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- AccountCreationPopUp.update()");
    }
}
