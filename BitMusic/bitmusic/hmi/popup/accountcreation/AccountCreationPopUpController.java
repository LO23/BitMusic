/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationPopUpController extends AbstractController<AccountCreationPopUpModel, AccountCreationPopUpView> {

    public AccountCreationPopUpController(final AccountCreationPopUpModel model, final AccountCreationPopUpView view) {
        super(model, view);
    }
    public class AvatarBrowseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Parcourir");
            JFileChooser file = new JFileChooser();
            JLabel path = new JLabel();
            int returnVal = file.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("---- OK");
                path.setText(file.getSelectedFile().getPath());
            }
        }
    }

    /**
     *
     */
    public class HintTextFieldListener extends JTextField implements FocusListener {

        private final String hint = "dd/MM/yyyy";
        private boolean showingHint;


        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Focus Gained");
            if(this.getText().isEmpty())
            {
                this.setText("");
                super.setText("");
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("Focus Lost");
            if(this.getText().isEmpty())
            {
                this.setText(hint);
                super.setText(hint);
                showingHint = true;
            }
        }
        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
            }
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getConnectionComponent().getController().getPopUp().dispose();
        }
    }
}
