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

    private final JLabel myProfileLabel = new JLabel("<html><u> Présentation de mon profil</u></html>");
    private final JLabel prenomLabel = new JLabel("Prénom ");
    private JTextField prenomField = new JTextField("");
    private final JLabel nomLabel = new JLabel("Nom ");
    private JTextField nomField = new JTextField("");
    private final JLabel birthLabel = new JLabel("Date de Naissance (*)");
    private final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private JFormattedTextField dateTextField = new JFormattedTextField(format);
    private final JLabel avatarLabel = new JLabel("Avatar");
    private final JButton avatarBrowseButton = new JButton("Parcourir...");
    private JTextField avatarField = new JTextField("");
    private final JButton submitButton = new JButton("Soumettre");
    private final JButton cancelButton = new JButton("Annuler");

    private final String type = "POPUP";

    public ModifyProfilePopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- ModifyProfilePopUpView.initPanel()");

        this.dateTextField.setText("dd/MM/yyyy");

        this.avatarBrowseButton.addActionListener(this.getController().new AvatarBrowseListener());
        this.cancelButton.addActionListener(this.getController().new CancelListener());
        this.dateTextField.addFocusListener(this.getController().new HintTextFieldListener());


        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

                layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthLabel)
                                    .addComponent(avatarLabel)
                                    .addComponent(nomLabel)
                                    .addComponent(prenomLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateTextField)
                                    .addComponent(avatarField)
                                    .addComponent(nomField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(prenomField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(submitButton)))
                        .addGap(18, 18, 18)
                        .addComponent(avatarBrowseButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myProfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomLabel)
                    .addComponent(prenomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthLabel)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avatarLabel)
                    .addComponent(avatarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avatarBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(submitButton))
                .addContainerGap())
        );

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