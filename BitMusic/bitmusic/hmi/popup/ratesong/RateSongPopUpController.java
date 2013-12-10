/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.editsong.EditSongPopUpController;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author unkedeuxke
 */
public final class RateSongPopUpController extends AbstractController<RateSongPopUpModel, RateSongPopUpView> {

    /**
     *
     * @param model
     * @param view
     */
    public RateSongPopUpController(final RateSongPopUpModel model, final RateSongPopUpView view) {
        super(model, view);
    }

    /**
     *
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

     public class ValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton valider");

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
            win.getApiMusic().addGradeFromHmi(RateSongPopUpController.this.getModel().getSong().getSongId(), grade);
            int parentTabId = RateSongPopUpController.this.getView().getParentTabId();
            win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().dispose();
        }
    }
}
