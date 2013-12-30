/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.data.Grade;
import bitmusic.music.data.Song;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controller class of RateSongPopUp
 * @author IHM
 */
public final class RateSongPopUpController extends AbstractController<RateSongPopUpModel, RateSongPopUpView> {

    /**
     * Constructor of RateSongPopUpController
     * @param model
     * @param view
     */
    public RateSongPopUpController(final RateSongPopUpModel model, final RateSongPopUpView view) {
        super(model, view);
    }

    /**
     * Listener on cancel button
     */
    public class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Annuler");
            WindowComponent win = WindowComponent.getInstance();
            int parentTabId = RateSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
        }
    }
    /**
     * Listener on submit button
     */
     public class ValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton valider");

            Song song = RateSongPopUpController.this.getModel().getSong();

            Integer grade = 0;
            if (RateSongPopUpController.this.getView().getSongRater1().isSelected()) {
                grade = 1;
            }
            else if (RateSongPopUpController.this.getView().getSongRater2().isSelected()) {
                grade = 2;
            }
            else if (RateSongPopUpController.this.getView().getSongRater3().isSelected()) {
                grade = 3;
            }
            else if (RateSongPopUpController.this.getView().getSongRater4().isSelected()) {
                grade = 4;
            }
            else if (RateSongPopUpController.this.getView().getSongRater5().isSelected()) {
                grade =5;
            }

            WindowComponent win = WindowComponent.getInstance();
            String currentUserId = win.getApiProfile().getCurrentUser().getUserId();
            Boolean isRate = false;

            if (song.getOwnerId().equals(currentUserId)) {
                //Musique locale
                isRate = win.getApiMusic().addGradeFromHmi(RateSongPopUpController.this.getModel().getSong().getSongId(), grade);
            }
            else {
                //Musique distante
                isRate = win.getApiMusic().addGradeFromNetwork(RateSongPopUpController.this.getModel().getSong().getSongId(), new Grade(currentUserId, grade));
            }

            if (!isRate){
                JOptionPane.showMessageDialog(
                        RateSongPopUpController.this.getView(),
                        "Le fichier n'a pas pu être importé !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

            int parentTabId = RateSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
        }
    }
     /**
      * Listener on delete button
      */
     public class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton delete");

            Song song = RateSongPopUpController.this.getModel().getSong();
            WindowComponent win = WindowComponent.getInstance();
            String currentUserId = win.getApiProfile().getCurrentUser().getUserId();

            win.getApiMusic().deleteGrade(song.getSongId(), currentUserId);
            int parentTabId = RateSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
        }
     }
}
