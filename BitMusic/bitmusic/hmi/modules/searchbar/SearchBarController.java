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

            if (view.getNoneButton().isSelected()) {
                requestFilter = FILTER_NONE;
            }
            else if (view.getTitleButton().isSelected()) {
                requestFilter = FILTER_TITLE;
            }
            else if (view.getAuthorButton().isSelected()) {
                requestFilter = FILTER_AUTHOR;
            }
            else {
                requestFilter = FILTER_TAG;
            }

            // Vérification qu'une recherche identique n'a pas déjà été faite
            CentralAreaComponent centralAreaComponent = win.getCentralAreaComponent();

            TabComponent tabToFocusOn = null;

            ArrayList<TabComponent> listTabComponents = centralAreaComponent.getView().getListTabComponent();
            for (int i = 0; i < listTabComponents.size(); i++) {
                Boolean sameFilter = listTabComponents.get(i).getModel().getRequestFilter().equals(requestFilter);
                Boolean sameOrigin = listTabComponents.get(i).getModel().getRequestOrigin().equals(requestOrigin);
                Boolean sameText = listTabComponents.get(i).getModel().getRequestText().equals(requestText);

                if (sameFilter && sameOrigin && sameText) {
                    tabToFocusOn = listTabComponents.get(i);
                }
            }

            // Si ce n'est pas le cas alors on crée un nouveau Tab
            if (tabToFocusOn == null) {
                tabToFocusOn = new TabComponent();

                // Stockage des détails de la requête dans le TabComponent
                tabToFocusOn.getModel().setRequestFilter(requestFilter);
                tabToFocusOn.getModel().setRequestOrigin(requestOrigin);
                tabToFocusOn.getModel().setRequestText(requestText);

                // Ajout du Tab dans le CentralAreaComponent (qui ajoute en même temps la vue)
                centralAreaComponent.getView().addTabComponent(tabToFocusOn);
            }

            ArrayList<Song> songResults = new ArrayList();
            int tabId = tabToFocusOn.getView().getTabId();

            if (view.getNoneButton().isSelected()) {
                songResults = model.searchSongsWithoutFilter(tabId, requestText);
            }
            else if (view.getTitleButton().isSelected()) {
                songResults = model.searchSongsWithTitleFilter(tabId, requestText);
            }
            else if (view.getAuthorButton().isSelected()) {
                songResults = model.searchSongsWithAuthorFilter(tabId, requestText);
            }
            else {
                songResults = model.searchSongsWithTagFilter(tabId, requestText);
            }

            // On actualise les Songs à l'intérieur du Tab (ancien ou nouveau, peu importe !)
            tabToFocusOn.getModel().getModeleTable().setSong(songResults);

            // Met le focus sur le Tab de notre requête
            centralAreaComponent.getView().getTabbedPane().setSelectedComponent(tabToFocusOn.getView().getPanel());
        }
    }
}
