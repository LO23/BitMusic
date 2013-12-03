/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpComponent;
import bitmusic.hmi.popup.modifyprofile.ModifyProfilePopUpComponent;
import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
import bitmusic.profile.utilities.ProfileExceptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;

/**
 *
 * @author unkedeuxke
 */
public final class MyProfileController extends AbstractController<MyProfileModel, MyProfileView> {

    private JDialog popUp;

    public MyProfileController(final MyProfileModel model, final MyProfileView view) {
        super(model, view);
    }

    public JDialog getPopUp() {
        return this.popUp;
    }

    public void setPopUp(JDialog popUp) {
        this.popUp = popUp;
    }

    public class LogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("- Fermeture de l'application en cours...");

            WindowComponent win = WindowComponent.getInstance();
            try {
                win.getWindowModel().logOut();
            } catch (NetworkException ex) {
                Logger.getLogger(MyProfileController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ProfileExceptions ex) {
                Logger.getLogger(MyProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Fermeture du pool de threads qui tourne en arrière-plan (géré par Network)
            WindowComponent.getInstance().getApiNetwork().shutdownExecutorService();

            win.getWindowView().dispose();
        }
    }

    public class ImportNewSongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton ImportSong");

            WindowComponent win = WindowComponent.getInstance();
            ImportSongPopUpComponent importSongPopUpComponent = new ImportSongPopUpComponent();

            popUp = new JDialog(win.getWindowView(), "Importer une musique", true);
            popUp.add(importSongPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();

        }
    }

    public class ModifyProfileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton myProfile");

            WindowComponent win = WindowComponent.getInstance();
            ModifyProfilePopUpComponent modifyProfilePopUpComponent = new ModifyProfilePopUpComponent();

            popUp = new JDialog(win.getWindowView(), "Mon Profil", true);
            popUp.add(modifyProfilePopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();
        }
    }

    public class MySongsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton MySongs");

            WindowComponent win = WindowComponent.getInstance();
            MyProfileView view = MyProfileController.this.getView();
            MyProfileModel model = MyProfileController.this.getModel();

            // Récupération des Songs correspondant à la recherche
            String requestOrigin = ORIGIN_MY_PROFILE;
            String requestText = "";
            String requestFilter = "";

            ArrayList<Song> songResults = new ArrayList();
            songResults = win.getApiProfile().getCurrentUser().getLocalSongs().getlibrary();

            // Vérification qu'une recherche identique n'a pas déjà été faite
            CentralAreaComponent centralAreaComponent = win.getCentralAreaComponent();

            TabComponent tabToFocusOn = null;

            Boolean sameTab = false;
            ArrayList<TabComponent> listTabComponents = centralAreaComponent.getView().getListTabComponent();
            for (int i = 0; i < listTabComponents.size(); i++) {
                Boolean sameFilter = listTabComponents.get(i).getModel().getRequestFilter().equals(requestFilter);
                Boolean sameOrigin = listTabComponents.get(i).getModel().getRequestOrigin().equals(requestOrigin);
                Boolean sameText = listTabComponents.get(i).getModel().getRequestText().equals(requestText);

                if (sameFilter && sameOrigin && sameText) {
                    sameTab = true;
                    tabToFocusOn = listTabComponents.get(i);
                }
            }

            // Si c'est le cas : simple actualisation des Song à l'intérieur
            if (sameTab) {
                System.out.println("Un même tab existe déjà, on l'actualise !");

                tabToFocusOn.getModel().getModeleTable().setSong(songResults);
            } // Sinon : création d'un nouveau Tab
            else {
                tabToFocusOn = new TabComponent();

                // Stockage des détails de la requête dans le TabComponent
                tabToFocusOn.getModel().setRequestFilter(requestFilter);
                tabToFocusOn.getModel().setRequestOrigin(requestOrigin);
                tabToFocusOn.getModel().setRequestText(requestText);

                // Attache des Songs obtenue dans la TabView
                tabToFocusOn.getModel().getModeleTable().setSong(songResults);

                // Ajout du Tab dans le CentralAreaComponent (qui ajoute en même temps la vue)
                centralAreaComponent.getView().addTabComponent(tabToFocusOn);
            }

            // Met le focus sur le Tab de notre requête (qu'on l'ait créé ou pas)
            centralAreaComponent.getView().getTabbedPane().setSelectedComponent(tabToFocusOn.getView().getPanel());
        }
    }
}
