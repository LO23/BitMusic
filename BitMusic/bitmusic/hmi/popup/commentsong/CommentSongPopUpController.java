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
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Controller class of SongPopUp
 * @author IHM
 */
public final class CommentSongPopUpController extends AbstractController<CommentSongPopUpModel, CommentSongPopUpView> {

    /**
     * Constructor of SongPopUp
     * @param model
     * @param view
     */
    public CommentSongPopUpController(final CommentSongPopUpModel model, final CommentSongPopUpView view) {
        super(model, view);
    }

    /**
     * Listener class on validate button
     * Submits a comment
     */
    public class ValidateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("---- Clic sur le bouton Valider");

            WindowComponent win = WindowComponent.getInstance();
            CommentSongPopUpView view = CommentSongPopUpController.this.getView();

            String comment = view.getCommentField().getText();
            CommentSongPopUpModel model = CommentSongPopUpController.this.getModel();

            if (!comment.equals("")) {
                Boolean isComment = false;
                Song song = model.getSong();
                String currentUserId = win.getApiProfile().getCurrentUser().getUserId();

                if (song.getOwnerId().equals(currentUserId)){
                    isComment = win.getApiMusic().addCommentFromHmi(song.getSongId(), comment);
                }
                else {
                    isComment = true;
                    try {
                        win.getApiNetwork().addComment(song, new Comment(win.getApiProfile().getCurrentUser().getLogin(), comment));
                    } catch (NetworkException ex) {
                        isComment = false;
                    }
                }

                if(!isComment) {
                    JOptionPane.showMessageDialog(
                        view,
                        "Le commentaire n'a pas été ajouté !",
                        "Erreur !",
                        JOptionPane.WARNING_MESSAGE);
                }

                //On ferme la mauvaise popup puisque la popup de commentSong
                // ne devrait pas être ouverte à partir de InfosSong...
                // cela fonctionne puisqu'on ferme la popup mère de commentSOng
                // mais c'est deprecated !
                InfosSongPopUpController.popUp.dispose();
            }
            else {
                JOptionPane.showMessageDialog(
                        view,
                        "Champs commentaire vide !",
                        "Erreur !",
                        JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    /**
     * Listener on reset button
     * Resets all the fields
     */
    public class ResetListener implements ActionListener    {
        @Override
        public void actionPerformed(ActionEvent e)  {
            System.out.println("---- Clic sur le bouton Reset");

            CommentSongPopUpController.this.getView().getCommentField().setText("");
        }
    }

    /**
     * Listener class on cancel button
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            // À décommenter dès que la PopUp est implémentée dans le XXXXXXXXComponent (créant la PopUp)
            //WindowComponent.getInstance().getXXXXXXXXComponent().getController().getPopUp().dispose();
        }
    }
}
