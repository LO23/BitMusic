/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author unkedeuxke
 */
public final class MyProfileController extends AbstractController<MyProfileModel, MyProfileView> {

    public MyProfileController(final MyProfileModel model, final MyProfileView view) {
        super(model, view);
    }

    public class LogoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Disconnect");
            System.out.println("---- Deconnexion en cours");
            // Pas besoin du Model ici : on agit directement sur la View
             MyProfileModel model = MyProfileController.this.getModel();

             model.notifyObservers("LOGOUT");

            // WindowComponent.getInstance().getWindowView().dispose();
        }
    }
}
