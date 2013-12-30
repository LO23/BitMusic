/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.managecategory;

import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class of ManageCategoryPopUp
 * @author IHM
 */
public final class ManageCategoryPopUpController extends AbstractController<ManageCategoryPopUpModel, ManageCategoryPopUpView> {

    /**
     * Constructor of ManageCategoryPopUpController
     * @param model
     * @param view
     */
    public ManageCategoryPopUpController(final ManageCategoryPopUpModel model, final ManageCategoryPopUpView view) {
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
