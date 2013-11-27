/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.data.Song;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author unkedeuxke
 */
public final class SearchBarController extends AbstractController<SearchBarModel, SearchBarView> {

    public SearchBarController(final SearchBarModel model, final SearchBarView view) {
        super(model, view);
    }

    public class ResearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Rechercher");

            WindowComponent win = WindowComponent.getInstance();
            SearchBarView view = SearchBarController.this.getView();
            SearchBarModel model = SearchBarController.this.getModel();

            // Récupération des Songs correspondant à la recherche
            String requestOrigin = ORIGIN_SEARCH_BAR;
            String requestText = view.getSearchField().getText();
            String requestFilter;

            ArrayList<Song> songResults = new ArrayList();
            if (view.getNoneButton().isSelected()) {
                requestFilter = FILTER_NONE;
                songResults = model.searchSongsWithoutFilter(requestText);
            } else if (view.getTitleButton().isSelected()) {
                requestFilter = FILTER_TITLE;
                songResults = model.searchSongsWithTitleFilter(requestText);
            } else if (view.getAuthorButton().isSelected()) {
                requestFilter = FILTER_AUTHOR;
                songResults = model.searchSongsWithAuthorFilter(requestText);
            } else {
                requestFilter = FILTER_TAG;
                songResults = model.searchSongsWithTagFilter(requestText);
            }

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
    }
}
