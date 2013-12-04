/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.centralarea;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaComponent extends AbstractComponent<CentralAreaModel, CentralAreaView, CentralAreaController> {

    public CentralAreaComponent() {
        this.model = new CentralAreaModel();
        this.view = new CentralAreaView();
        this.controller = new CentralAreaController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }

    public void CentralAreaInit() {
        System.out.println("---- Affichage par défaut de MySongs");

        WindowComponent win = WindowComponent.getInstance();

        // Récupération des Songs correspondant à la recherche
        String requestOrigin = this.getController().getORIGIN_MY_PROFILE();
        String requestText = "";
        String requestFilter = "";

        ArrayList<Song> songResults = win.getApiProfile().getCurrentUser().getSongs().getlibrary();
        //songResults = win.getApiProfile().getCurrentUser().getLocalSongs().getlibrary(); //getLocalSongs = getSongs... ! lol

        // Aucune recherche identique n'a pu être faite (car lancement de l'application)
        // Création d'un nouveau Tab
        TabComponent tabToFocusOn = new TabComponent();

        // Stockage des détails de la requête dans le TabComponent
        tabToFocusOn.getModel().setRequestFilter(requestFilter);
        tabToFocusOn.getModel().setRequestOrigin(requestOrigin);
        tabToFocusOn.getModel().setRequestText(requestText);

        // Attache des Songs obtenue dans la TabView
        tabToFocusOn.getModel().getModeleTable().setSong(songResults);

        // Ajout du Tab dans le CentralAreaComponent (qui ajoute en même temps la vue)
        this.getView().addTabComponent(tabToFocusOn);

        // Met le focus sur le Tab de notre requête
        this.getView().getTabbedPane().setSelectedComponent(tabToFocusOn.getView().getPanel());
    }
}
