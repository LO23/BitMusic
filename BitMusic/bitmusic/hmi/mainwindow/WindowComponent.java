/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.api.ApiHmiImpl;
import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.music.api.ApiMusicImpl;
import bitmusic.network.main.Controller;
import bitmusic.hmi.modules.accountcreation.AccountCreationComponent;
import bitmusic.hmi.modules.categories.CategoriesComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaComponent;
import bitmusic.hmi.modules.connection.ConnectionComponent;
import bitmusic.hmi.modules.myprofile.MyProfileComponent;
import bitmusic.hmi.modules.onlineusers.OnlineUsersComponent;
import bitmusic.hmi.modules.playbar.PlayBarComponent;
import bitmusic.hmi.modules.searchbar.SearchBarComponent;
import bitmusic.hmi.modules.tab.TabComponent;
import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowComponent {

    private WindowModel model;
    private WindowView view;
    private WindowController controller;

    private ApiHmiImpl apiHmi;
    private ApiProfileImpl apiProfile;
    private ApiMusicImpl apiMusic;
    private bitmusic.network.main.ApiHmiImpl apiNetwork;

    private AccountCreationComponent accountCreationComponent;
    private CategoriesComponent categoriesComponent;
    private ConnectionComponent connectionComponent;
    private MyProfileComponent myProfileComponent;
    private OnlineUsersComponent onlineUsersComponent;
    private PlayBarComponent playBarComponent;
    private SearchBarComponent searchBarComponent;
    private CentralAreaComponent centralAreaComponent;

    private ArrayList<TabComponent> listTabsComponent;
    // TODO : ajouter les PopUp aussi ??? si on les ferme au même endroit qu'on les crée : pas besoin de les avoir ici

    private WindowComponent() {
        this.apiHmi = new ApiHmiImpl();
        this.apiProfile = ApiProfileImpl.getApiProfile();
        this.apiMusic = ApiMusicImpl.getInstance();
        this.apiNetwork = Controller.getInstance().getApiHmi();

        this.model = new WindowModel();
        this.view = new WindowView();
        this.controller = new WindowController(this.model, this.view);
        this.view.setWindowController(this.controller);
        this.view.initFrame();
        this.model.addObserver(this.view);
        this.view.addWindowListener(this.controller.new WindowComponentListener());

        this.setConnectionComponent(new ConnectionComponent());
        this.view.addView(this.getConnectionComponent().getView());

    }

    /** Holder */
    private static class WindowComponentHolder {
        /** Instance unique non préinitialisée */
        private final static WindowComponent instance = new WindowComponent();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static WindowComponent getInstance() {
            return WindowComponentHolder.instance;
    }

    public WindowModel getWindowModel() {
        return this.model;
    }

    public WindowView getWindowView() {
        return this.view;
    }

    public WindowController getWindowController() {
        return this.controller;
    }

    public ApiHmiImpl getApiHmi() {
        return this.apiHmi;
    }

    public void setApiHmi(ApiHmiImpl apiHmi) {
        this.apiHmi = apiHmi;
    }

    public ApiProfileImpl getApiProfile() {
        return this.apiProfile;
    }

    public void setApiProfile(ApiProfileImpl apiProfile) {
        this.apiProfile = apiProfile;
    }

    public ApiMusicImpl getApiMusic() {
        return this.apiMusic;
    }

    public void setApiMusic(ApiMusicImpl apiMusic) {
        this.apiMusic = apiMusic;
    }

    public bitmusic.network.main.ApiHmiImpl getApiNetwork() {
        return this.apiNetwork;
    }

    public void setApiNetwork(bitmusic.network.main.ApiHmiImpl apiNetwork) {
        this.apiNetwork = apiNetwork;
    }

    public AccountCreationComponent getAccountCreationComponent() {
        return this.accountCreationComponent;
    }

    public void setAccountCreationComponent(AccountCreationComponent accountCreationComponent) {
        this.accountCreationComponent = accountCreationComponent;
    }

    public CategoriesComponent getCategoriesComponent() {
        return this.categoriesComponent;
    }

    public void setCategoriesComponent(CategoriesComponent categoriesComponent) {
        this.categoriesComponent = categoriesComponent;
    }

    public ConnectionComponent getConnectionComponent() {
        return this.connectionComponent;
    }

    public void setConnectionComponent(ConnectionComponent connectionComponent) {
        this.connectionComponent = connectionComponent;
    }

    public MyProfileComponent getMyProfileComponent() {
        return this.myProfileComponent;
    }

    public void setMyProfileComponent(MyProfileComponent myProfileComponent) {
        this.myProfileComponent = myProfileComponent;
    }

    public OnlineUsersComponent getOnlineUsersComponent() {
        return this.onlineUsersComponent;
    }

    public void setOnlineUsersComponent(OnlineUsersComponent onlineUsersComponent) {
        this.onlineUsersComponent = onlineUsersComponent;
    }

    public PlayBarComponent getPlayBarComponent() {
        return this.playBarComponent;
    }

    public void setPlayBarComponent(PlayBarComponent playBarComponent) {
        this.playBarComponent = playBarComponent;
    }

    public SearchBarComponent getSearchBarComponent() {
        return this.searchBarComponent;
    }

    public void setSearchBarComponent(SearchBarComponent searchBarComponent) {
        this.searchBarComponent = searchBarComponent;
    }

    public CentralAreaComponent getCentralAreaComponent() {
        return this.centralAreaComponent;
    }

    public void setCentralAreaComponent(CentralAreaComponent centralAreaComponent) {
        this.centralAreaComponent = centralAreaComponent;
    }

    public ArrayList<TabComponent> getListTabsComponent() {
        return this.listTabsComponent;
    }

    public void setListTabsComponent(ArrayList<TabComponent> listTabsComponent) {
        this.listTabsComponent = listTabsComponent;
    }

    public void addTabComponent(TabComponent tab) {
        this.listTabsComponent.add(tab);
    }

    public void removeTabComponent(TabComponent tab) {
        for (int i=0; i<this.listTabsComponent.size(); i++) {
            if (listTabsComponent.get(i).equals(tab)) {
                listTabsComponent.remove(i);
            }
        }
    }

    public void initAllComponents() {
        // TODO : Création des différents Components...

        //TODO
//        this.setCategoriesComponent(new CategoriesComponent());
//        this.getWindowView().addView(this.getCategoriesComponent().getView());

        this.setSearchBarComponent(new SearchBarComponent());
        this.getWindowView().addView(this.getSearchBarComponent().getView());

        this.setMyProfileComponent(new MyProfileComponent());
        this.getWindowView().addView(this.getMyProfileComponent().getView());

        this.setOnlineUsersComponent(new OnlineUsersComponent());
        this.getWindowView().addView(this.getOnlineUsersComponent().getView());
        // Récupérer une liste des utilisateurs déjà connectés et la passer au OnlineUsersModel
        // TODO : en attente de la disponibilité de la méthode dans l'API
        // ArrayList<User> currentOnlineUsers = win.getApiNetwork().getListUser();
        // onlineUsersComponent.getModel().setListUsersOnline(currentOnlineUsers);
        // NB : Pas besoin de prévenir Network qu'on s'est connecté, Profile le fait lors de l'appel à doConnection()
        // => on est censé recevoir un notifyNewConnection() de Network pour notre propre connection

        this.setPlayBarComponent(new PlayBarComponent());
        this.getWindowView().addView(this.getPlayBarComponent().getView());

        //TODO
//        this.setCentralAreaComponent(new CentralAreaComponent());
//        this.getWindowView().addView(this.getCentralAreaComponent().getView());
    }
}
