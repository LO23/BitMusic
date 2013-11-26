/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.commentsong.CommentSongPopUpController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author unkedeuxke
 */
public final class EditSongPopUpController extends AbstractController<EditSongPopUpModel, EditSongPopUpView> {

    public EditSongPopUpController(final EditSongPopUpModel model, final EditSongPopUpView view) {
        super(model, view);
    }

    public class ResetButtonListener implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e)  {
            System.out.println("---- Clic sur le bouton reset");
            
            EditSongPopUpController.this.getView().getTitleField().setText("");
            EditSongPopUpController.this.getView().getArtisteField().setText("");
            EditSongPopUpController.this.getView().getAlbumField().setText("");
        }
    }

    public class FileBrowseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton parcourir");
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
            // À décommenter dès que la PopUp est implémentée dans le XXXXXXXXComponent (créant la PopUp)
            //WindowComponent.getInstance().getXXXXXXXXComponent().getController().getPopUp().dispose();
        }
    }
}
