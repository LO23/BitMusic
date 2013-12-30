/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationsuser;

import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class of infosUserPopUp
 * @author IHM
 */
public final class InfosUserPopUpController extends AbstractController<InfosUserPopUpModel, InfosUserPopUpView> {

    /**
     * Contructor of InfosUserPopUpController
     * @param model
     * @param view
     */
    public InfosUserPopUpController(final InfosUserPopUpModel model, final InfosUserPopUpView view) {
        super(model, view);
    }

    /**
     * Listener on cancel button
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
