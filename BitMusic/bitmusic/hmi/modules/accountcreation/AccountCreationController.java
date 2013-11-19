/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.accountcreation;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.connection.ConnectionComponent;
import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationController extends AbstractController<AccountCreationModel, AccountCreationView> {

    public AccountCreationController(final AccountCreationModel model, final AccountCreationView view) {
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

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");

            AccountCreationModel model = AccountCreationController.this.getModel();
            WindowComponent win = WindowComponent.getInstance();

            // On enlève la AccountCreationView des "objets utilisés"
            win.getWindowView().removeView(AccountCreationController.this.getView());
            // TODO : pourquoi elle ne se supprime pas ??? (superposition)

            // Attache de la ConnectionView aux "objets utilisés"
            win.getWindowView().addView(win.getConnectionComponent().getView());
        }
    }
}
