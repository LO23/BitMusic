/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpController extends AbstractController<InfosSongPopUpModel, InfosSongPopUpView> {

    public InfosSongPopUpController(final InfosSongPopUpModel model, final InfosSongPopUpView view) {
        super(model, view);
    }

    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            // À décommenter dès que la PopUp est implémentée dans le XXXXXXXXComponent (créant la PopUp)
            //WindowComponent.getInstance().getXXXXXXXXComponent().getController().getPopUp().dispose();
        }
    }

    public class CommentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent win = WindowComponent.getInstance();
            String comment = InfosSongPopUpController.this.getView().getCommentField().getText();
            InfosSongPopUpModel model = InfosSongPopUpController.this.getModel();

            if (!comment.equals("")) {
                // add the comment to the song
                Song song = model.getSong();
                boolean added = win.getApiMusic().addCommentFromHmi(song.getSongId(), comment);
                if(added==true) {
                    System.out.println("---- Commentaire ajouté : " + comment);
                }
            }

            // À décommenter dès que la PopUp est implémentée dans le XXXXXXXXComponent (créant la PopUp)
            int parentTabId = InfosSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();        }
    }
}
