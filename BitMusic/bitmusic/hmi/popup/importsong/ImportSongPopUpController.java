/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author unkedeuxke
 */
public final class ImportSongPopUpController extends AbstractController<ImportSongPopUpModel, ImportSongPopUpView> {

    public ImportSongPopUpController(final ImportSongPopUpModel model, final ImportSongPopUpView view) {
        super(model, view);
    }

    public class FileBrowseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Parcourir");
            JFileChooser file = new JFileChooser();

            int returnVal = file.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("---- OK");
                ImportSongPopUpController.this.getView().getFileField().setText(file.getSelectedFile().getPath());
            }
        }
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent.getInstance().getMyProfileComponent().getController().getPopUp().dispose();
        }
    }

    public class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");

            if ( ImportSongPopUpController.this.checkAllCompulsoryFields() ){
                
            }
        }
    }

    public boolean checkAllCompulsoryFields(){
        ArrayList<JTextField> listCompulsoryFields = this.getView().getListCompulsoryFields();

        for (int i=0; i<listCompulsoryFields.size(); i++){
            if ( listCompulsoryFields.get(i).getText().length() <= 0 ) {
                JOptionPane.showMessageDialog(this.getView(),
                        "Tous les champs obligatoires doivent être renseignés !",
                        "Attention aux champs", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        return true;
    }
}
