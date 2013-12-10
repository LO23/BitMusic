/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.commentsong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.informationssong.InfosSongPopUpController;
import bitmusic.hmi.popup.informationssong.InfosSongPopUpModel;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author unkedeuxke
 */
public final class CommentSongPopUpController extends AbstractController<CommentSongPopUpModel, CommentSongPopUpView> {

    public CommentSongPopUpController(final CommentSongPopUpModel model, final CommentSongPopUpView view) {
        super(model, view);
    }

    public class ValidateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("---- Clic sur le bouton Valider");

            WindowComponent win = WindowComponent.getInstance();
            CommentSongPopUpView view = CommentSongPopUpController.this.getView();
            Boolean canComment = true;

            String comment = view.getCommentField().getText();
            if(comment.isEmpty()) {
                canComment =  false;
            }

            if(canComment) {
                //Appel à l'API pour commenter un morceau

                CommentSongPopUpModel model = CommentSongPopUpController.this.getModel();

                if (!comment.equals("")) {
                    // add the comment to the song
                    Song song = model.getSong();
                    boolean added = win.getApiMusic().addCommentFromHmi(song.getSongId(), comment);
                    if(added==true) {
                        System.out.println("---- Commentaire ajouté : " + comment);

                        // ouverture d'une boite de dialogue pour confirmer l'ajout du commentaire
                        JOptionPane.showMessageDialog( view,"Validé !","Commentaire bien ajouté ! ",
                            JOptionPane.OK_OPTION);
                    }
                }
            }

            else {
                JOptionPane.showMessageDialog(
                        view,
                        "Veuillez laisser un commentaire !",
                        "Champs commentaire vide !",
                        JOptionPane.WARNING_MESSAGE);
            }

            // close the pop up now
            int parentTabId = CommentSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
            // TO COMPLETE

        }

    }

    public class ResetListener implements ActionListener    {
        @Override
        public void actionPerformed(ActionEvent e)  {
            System.out.println("---- Clic sur le bouton Reset");

            CommentSongPopUpController.this.getView().getCommentField().setText("");
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
