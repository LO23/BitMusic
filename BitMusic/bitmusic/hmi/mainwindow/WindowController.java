/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.network.exception.NetworkException;

import bitmusic.profile.utilities.ProfileExceptions;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author IHM
 */
public class WindowController {

    private WindowModel windowModel;
    private WindowView windowView;

    /**
     * Constructor of WindowController
     * @param model
     * @param view
     */
    public WindowController(WindowModel model, WindowView view) {
        this.windowModel = model;
        this.windowView = view;
    }

    /**
     * Listener on main window
     */
    public class WindowComponentListener implements WindowListener {
        @Override
        /**
         * Listener on the close button of the window
         * Closes the pool threads working in background
         */
        public void windowClosing(WindowEvent e) {
            System.out.println("- Fermeture de l'application en cours...");
            try {
                WindowController.this.getWindowModel().logOut();
            } catch (NetworkException ex) {
                Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ProfileExceptions ex) {
                Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Fermeture du pool de threads qui tourne en arrière-plan (géré par Network)
            // Uniquement si le module network a été lanca (après connexion réussie)
            bitmusic.network.main.ApiHmiImpl apiNetwork = WindowComponent.getInstance().getApiNetwork();
            if ( apiNetwork != null )
                apiNetwork.shutdownExecutorService();

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

    /**
     *
     * @return windowModel
     */
    public WindowModel getWindowModel() {
        return this.windowModel;
    }

    /**
     *
     * @param windowModel
     */
    public void setWindowModel(WindowModel windowModel) {
        this.windowModel = windowModel;
    }

    /**
     *
     * @return windowView
     */
    public WindowView getWindowView() {
        return this.windowView;
    }

    /**
     *
     * @param windowView
     */
    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }


}
