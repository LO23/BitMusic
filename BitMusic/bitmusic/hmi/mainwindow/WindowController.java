/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.network.exception.NetworkException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowController {

    private WindowModel windowModel;
    private WindowView windowView;

    public WindowController(WindowModel model, WindowView view) {
        this.windowModel = model;
        this.windowView = view;
    }

    public class WindowComponentListener implements WindowListener {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("- Fermeture de l'application en cours...");
            try {
                WindowController.this.getWindowModel().logOut();
            } catch (NetworkException ex) {
                Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Fermeture du pool de threads qui tourne en arrière-plan (géré par Network)
            WindowComponent.getInstance().getApiNetwork().shutdownExecutorService();

            WindowController.this.getWindowView().dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e){}

        @Override
        public void windowActivated(WindowEvent e){}

        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}
    }

    public WindowModel getWindowModel() {
        return this.windowModel;
    }

    public void setWindowModel(WindowModel windowModel) {
        this.windowModel = windowModel;
    }

    public WindowView getWindowView() {
        return this.windowView;
    }

    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }


}
