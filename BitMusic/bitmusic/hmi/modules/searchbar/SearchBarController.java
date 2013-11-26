/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaView;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.data.Song;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ButtonModel;

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

            String textSearched = view.getSearchField().getText();
            String filterChoosen;
            ArrayList<Song> songResults = new ArrayList();

            if (view.getNoneButton().isSelected()) {
                filterChoosen = "none";
                songResults = model.searchSongsWithoutFilter(textSearched);
            } else if (view.getTitleButton().isSelected()) {
                filterChoosen = "title";
                songResults = model.searchSongsWithTitleFilter(textSearched);
            } else if (view.getAuthorButton().isSelected()) {
                filterChoosen = "author";
                songResults = model.searchSongsWithAuthorFilter(textSearched);
            } else {
                filterChoosen = "tag";
                songResults = model.searchSongsWithTagFilter(textSearched);
            }

            // Vérification qu'une recherche identique n'a pas déjà été faite
            WindowComponent win = WindowComponent.getInstance();
            CentralAreaView centralAreaView = win.getCentralAreaComponent().getView();
            // ...
            // TODO
            // ...

            // Si c'est le cas : simple actualisation des Song à l'intérieur
            // ...
            // TODO
            // ...

            // Sinon : création d'un nouveau tab
            TabComponent tabComponent = new TabComponent();

            // Stockage des détails de la requête dans le TabComponent
            tabComponent.getModel().setRequestOrigin("SearchBar");
            tabComponent.getModel().setRequestText(textSearched);
            tabComponent.getModel().setRequestFilter(filterChoosen);

            // Attache des Songs obtenue dans la TabView
            tabComponent.getModel().getModeleTable().setSong(songResults);

            // Ajout du Tab dans le CentralAreaComponent
            centralAreaView.addTab(tabComponent.getView());
        }
    }
}
