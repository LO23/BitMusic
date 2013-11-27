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

            // Récupération des Songs correspondant à la recherche
            SearchBarView view = SearchBarController.this.getView();
            SearchBarModel model = SearchBarController.this.getModel();

            String requestFilter;
            String requestOrigin = ORIGIN_SEARCH_BAR;
            String requestText = view.getSearchField().getText();

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
            WindowComponent win = WindowComponent.getInstance();
            CentralAreaComponent centralAreaComponent = win.getCentralAreaComponent();

            TabComponent tabComponent = null;
            Boolean sameTab = false;

            ArrayList<TabComponent> listTabComponents = centralAreaComponent.getView().getListTabComponent();
            for (int i=0; i<listTabComponents.size(); i++  ) {
                Boolean sameFilter = listTabComponents.get(i).getModel().getRequestFilter().equals(requestFilter);
                Boolean sameOrigin = listTabComponents.get(i).getModel().getRequestOrigin().equals(requestOrigin);
                Boolean sameText = listTabComponents.get(i).getModel().getRequestText().equals(requestText);

                if ( sameFilter && sameOrigin && sameText ) {
                    sameTab = true;
                    tabComponent = listTabComponents.get(i);
                }
            }

            // Si c'est le cas : simple actualisation des Song à l'intérieur
            if ( sameTab ) {
                System.out.println("Un même tag existe déjà !");
                // TODO
            }
            // Sinon : création d'un nouveau tab
            else {
                tabComponent = new TabComponent();

                // Stockage des détails de la requête dans le TabComponent
                tabComponent.getModel().setRequestFilter(requestFilter);
                tabComponent.getModel().setRequestOrigin(requestOrigin);
                tabComponent.getModel().setRequestText(requestText);

                // Attache des Songs obtenue dans la TabView
                tabComponent.getModel().getModeleTable().setSong(songResults);

                // Ajout du Tab dans le CentralAreaComponent (qui ajoute en même temps la vue)
                centralAreaComponent.getView().addTabComponent(tabComponent);
            }

        //Met le focus sur le bon tab (qu'il soit nouveau ou non...)
        centralAreaComponent.getView().getTabbedPane().setSelectedComponent(tabComponent.getView().getPanel());

        }
    }
}
