/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaView;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.importsong.ImportSongPopUpComponent;
import bitmusic.hmi.popup.modifyprofile.ModifyProfilePopUpComponent;
import bitmusic.music.data.Song;
import bitmusic.network.exception.NetworkException;
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
             TabComponent tabComponent = new TabComponent();


//             if (win.getApiProfile().getCurrentUser().getLocalSongs().getlibrary().isEmpty()) {
//                 ArrayList<Song> songList = new ArrayList();
//                songList.add(new Song("","Make me","Avicii","BOUILLA", new LinkedList()));
//                songList.add(new Song("","Wake me up","Avicii","BOUILLA2",new LinkedList()));
//                tabComponent.getModel().getModeleTable().setSong(songList);
//             } else {
//                 tabComponent.getModel().getModeleTable().setSong(WindowComponent.getInstance().getApiProfile().getCurrentUser().getLocalSongs().getlibrary());
//             }


             CentralAreaView centralAreaView = win.getCentralAreaComponent().getView();
             centralAreaView.addTab(tabComponent.getView());
         }
    }
}
