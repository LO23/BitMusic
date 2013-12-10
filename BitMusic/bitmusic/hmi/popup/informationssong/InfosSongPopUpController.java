/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.tab.TabController;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.commentsong.CommentSongPopUpComponent;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpController extends AbstractController<InfosSongPopUpModel, InfosSongPopUpView> {


    public static JDialog popUp;

    /**
     *
     * @param model
     * @param view
     */

    public InfosSongPopUpController(final InfosSongPopUpModel model, final InfosSongPopUpView view) {
        super(model, view);
    }

    /**
     *
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            // À décommenter dès que la PopUp est implémentée dans le XXXXXXXXComponent (créant la PopUp)
            //WindowComponent.getInstance().getXXXXXXXXComponent().getController().getPopUp().dispose();
        }
    }

    public class CommentPopUpOpenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Commenter");
            WindowComponent win = WindowComponent.getInstance();
            // ouvrir  la pop up CommentSongPopUp

            Song song = InfosSongPopUpController.this.getModel().getSong();
            CommentSongPopUpComponent commentSongPopUpComponent = new CommentSongPopUpComponent(song, InfosSongPopUpController.this.getView().getParentTabId());

            popUp = new JDialog(win.getWindowView(), "Informations d'un morceau", true);
            popUp.add(commentSongPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();
            // À décommenter dès que la PopUp est implémentée dans le XXXXXXXXComponent (créant la PopUp)
            int parentTabId = InfosSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
        }
    }

    public JDialog getPopUp() {
        return popUp;
    }
}
