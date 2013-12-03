/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author unkedeuxke
 */
public final class RateSongPopUpController extends AbstractController<RateSongPopUpModel, RateSongPopUpView> {

    public RateSongPopUpController(final RateSongPopUpModel model, final RateSongPopUpView view) {
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
}
