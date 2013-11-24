/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.modifyprofile;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author unkedeuxke
 */
public final class ModifyProfilePopUpView extends AbstractView<ModifyProfilePopUpController> {

    private final JLabel myProfileLabel = new JLabel("Mon profil");
    private final JLabel prenomLabel = new JLabel("Prénom ");
    private final JTextField prenomField = new JTextField("");
    private final JLabel nomLabel = new JLabel("Nom ");
    private final JTextField nomField = new JTextField("");
    private final JLabel birthLabel = new JLabel("Date de Naissance (*)");
    private final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private final JFormattedTextField dateTextField = new JFormattedTextField(format);
    private final JLabel avatarLabel = new JLabel("Avatar");
    private final JButton avatarbrowseButton = new JButton("Parcourir...");
    private final JButton submitButton = new JButton("Soumettre");
    private final JButton cancelButton = new JButton("Annuler");

    private final String type = "POPUP";

    public ModifyProfilePopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- ModifyProfilePopUpView.initPanel()");

       final Dimension d = new Dimension(80, 20);


        this.myProfileLabel.setSize(d);

        this.prenomLabel.setSize(d);
        this.prenomField.setColumns(10);
        this.nomLabel.setSize(d);
        this.nomField.setColumns(10);
        this.birthLabel.setSize(d);
        this.dateTextField.setColumns(10);
        this.dateTextField.setText("dd/MM/yyyy");
        this.avatarLabel.setSize(d);
        this.avatarbrowseButton.setSize(d);

        this.submitButton.setSize(d);
        this.cancelButton.setSize(d);



        avatarbrowseButton.addActionListener(this.getController().new AvatarBrowseListener());

        this.cancelButton.addActionListener(this.getController().new CancelListener());

        this.dateTextField.addFocusListener(this.getController().new HintTextFieldListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(myProfileLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(prenomLabel)
                    .addComponent(nomLabel)
                    .addComponent(birthLabel)
                    .addComponent(avatarLabel)
                    .addComponent(submitButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(prenomField)
                    .addComponent(nomField)
                    .addComponent(dateTextField)
                    .addComponent(avatarbrowseButton)

                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                )

        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(myProfileLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
                    .addComponent(dateTextField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(avatarLabel)
                    .addComponent(avatarbrowseButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton))

                    .addComponent(cancelButton)
                )
        );


        layout.linkSize(SwingConstants.HORIZONTAL, prenomLabel, prenomField);
        layout.linkSize(SwingConstants.HORIZONTAL, nomLabel, nomField);
        layout.linkSize(SwingConstants.HORIZONTAL, birthLabel, dateTextField);
        layout.linkSize(SwingConstants.HORIZONTAL, avatarLabel, avatarbrowseButton);
        layout.linkSize(SwingConstants.HORIZONTAL, submitButton, cancelButton);


    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ModifyProfilePopUpView.update() ->" + str);


    }

}