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
import javax.swing.JFileChooser;
import javax.swing.JLabel;

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
            JLabel path = new JLabel();
            int returnVal = file.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("---- OK");
                path.setText(file.getSelectedFile().getPath());
            }
        }
    }
}
