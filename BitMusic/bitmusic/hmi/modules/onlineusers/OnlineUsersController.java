/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.popup.informationsuser.InfosUserPopUpComponent;
import bitmusic.music.data.Song;
import bitmusic.profile.classes.User;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JTable;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersController extends AbstractController<OnlineUsersModel, OnlineUsersView> {

    private JDialog popUp;

    public OnlineUsersController(final OnlineUsersModel model, final OnlineUsersView view) {
        super(model, view);
    }

    private Action infos = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            User user = ((OnlineUsersModel.OnlineUsersTableModel)table.getModel()).getUserAt(row);
            System.out.println("---- Clic sur Infos du User : " + user.getLogin());

            WindowComponent win = WindowComponent.getInstance();
            InfosUserPopUpComponent infosUserPopUpComponent = new InfosUserPopUpComponent(user);

            popUp = new JDialog(win.getWindowView(), "Afficher informations utilisateur", true);
            popUp.add(infosUserPopUpComponent.getView().getPanel());
            popUp.pack();
            popUp.setLocationRelativeTo(null);
            popUp.show();
        }
    };

    private Action mp3 = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable)e.getSource();
            int row = Integer.valueOf( e.getActionCommand() );
            User user = ((OnlineUsersModel.OnlineUsersTableModel)table.getModel()).getUserAt(row);
            System.out.println("---- Clic sur MP3 du User : " + user.getLogin());

            WindowComponent win = WindowComponent.getInstance();
            OnlineUsersView view = OnlineUsersController.this.getView();
            OnlineUsersModel model = OnlineUsersController.this.getModel();

            // Récupération des Songs de l'utilisateur
            String requestOrigin = ORIGIN_ONLINE_USERS;
            String requestText = user.getUserId();
            String requestFilter = FILTER_USER;

            ArrayList<Song> songResults = new ArrayList();
            songResults = model.searchSongsFromUserId(requestText);

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
            }
            // Sinon : création d'un nouveau Tab
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
    };

    public Action getInfos() {
        return infos;
    }

    public Action getMp3() {
        return mp3;
    }
}
