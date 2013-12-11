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
import bitmusic.hmi.modules.categories.CategoriesComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaComponent;
import bitmusic.hmi.modules.connection.ConnectionComponent;
import bitmusic.hmi.modules.myprofile.MyProfileComponent;
import bitmusic.hmi.modules.onlineusers.OnlineUsersComponent;
import bitmusic.hmi.modules.playbar.PlayBarComponent;
import bitmusic.hmi.modules.searchbar.SearchBarComponent;
import bitmusic.network.exception.NetworkException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowComponent {

    private WindowModel model;
    private WindowView view;
    private WindowController controller;

    private ApiHmiImpl apiHmi = null;
    private ApiProfileImpl apiProfile = null;
    private ApiMusicImpl apiMusic = null;
    private bitmusic.network.main.ApiHmiImpl apiNetwork = null;

    private CategoriesComponent categoriesComponent;
    private ConnectionComponent connectionComponent;
    private MyProfileComponent myProfileComponent;
    private OnlineUsersComponent onlineUsersComponent;
    private PlayBarComponent playBarComponent;
    private SearchBarComponent searchBarComponent;
    private CentralAreaComponent centralAreaComponent;

    private WindowComponent() {
        this.apiHmi = new ApiHmiImpl();
        this.apiProfile = ApiProfileImpl.getApiProfile();
        this.apiMusic = ApiMusicImpl.getInstance();


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

    /**
     *
     */
    public void startNetwork() {
        this.apiNetwork = Controller.getInstance().getApiHmi();
        //On notifie le réseau que l'on s'est connecté
        this.apiNetwork.notifyNewConnection(apiProfile.getCurrentUser());
    }

    /** Holder */
    private static class WindowComponentHolder {
        /** Instance unique non préinitialisée */
        private final static WindowComponent instance = new WindowComponent();
    }

    /** Point d'accès pour l'instance unique du singleton
     * @return  */
    public static WindowComponent getInstance() {
            return WindowComponentHolder.instance;
    }

    /**
     *
     */
    public void initAllComponents() {
        // Création des différents Components
        WindowComponent win = WindowComponent.getInstance();

        this.setSearchBarComponent(new SearchBarComponent());
        this.getWindowView().addView(this.getSearchBarComponent().getView());

        this.setMyProfileComponent(new MyProfileComponent());
        this.getWindowView().addView(this.getMyProfileComponent().getView());

        // TODO :
        // this.setCategoriesComponent(new CategoriesComponent());
        // this.getWindowView().addView(this.getCategoriesComponent().getView());

        this.setCentralAreaComponent(new CentralAreaComponent());
        this.getWindowView().addView(this.getCentralAreaComponent().getView());
        //On affiche mesMorceaux dans une tab dans centralArea
        this.myProfileComponent.getController().new MySongsListener().actionPerformed(null);

        this.setPlayBarComponent(new PlayBarComponent());
        this.getWindowView().addView(this.getPlayBarComponent().getView());

        this.setOnlineUsersComponent(new OnlineUsersComponent());
        this.getWindowView().addView(this.getOnlineUsersComponent().getView());

        // Récupération de la liste des utilisateurs déjà connectés pour les afficher dans OnlineUsersComponent
        String ourUserId = win.getApiProfile().getCurrentUser().getUserId();
        //List<String> currentOnlineUsersId = win.getApiNetwork().getAllUserId();
        List<String> currentOnlineUsersId = new ArrayList();
        for (int i = 0; i < currentOnlineUsersId.size(); i++) {
            try {
                win.getApiNetwork().getUser(ourUserId, currentOnlineUsersId.get(i), null); // searchId nécessaire ici ?
            } catch (NetworkException e) {
                System.out.println("Erreur à l'appel de la méthode ApiNetwork.getUser() !");
            }
        }
        // Pas besoin de prévenir Network qu'on s'est connecté, Profile le fait via notre appel à checkPassword() dans doConnection()
        // On est censé recevoir un notifyNewConnection() de Network pour notre propre connection
    }

    /**
     *
     * @return
     */
    public WindowModel getWindowModel() {
        return this.model;
    }

    /**
     *
     * @return
     */
    public WindowView getWindowView() {
        return this.view;
    }

    /**
     *
     * @return
     */
    public WindowController getWindowController() {
        return this.controller;
    }

    /**
     *
     * @return
     */
    public ApiHmiImpl getApiHmi() {
        return this.apiHmi;
    }

    /**
     *
     * @param apiHmi
     */
    public void setApiHmi(ApiHmiImpl apiHmi) {
        this.apiHmi = apiHmi;
    }

    /**
     *
     * @return
     */
    public ApiProfileImpl getApiProfile() {
        return this.apiProfile;
    }

    /**
     *
     * @param apiProfile
     */
    public void setApiProfile(ApiProfileImpl apiProfile) {
        this.apiProfile = apiProfile;
    }

    /**
     *
     * @return
     */
    public ApiMusicImpl getApiMusic() {
        return this.apiMusic;
    }

    /**
     *
     * @param apiMusic
     */
    public void setApiMusic(ApiMusicImpl apiMusic) {
        this.apiMusic = apiMusic;
    }

    /**
     *
     * @return
     */
    public bitmusic.network.main.ApiHmiImpl getApiNetwork() {
        return this.apiNetwork;
    }

    /**
     *
     * @param apiNetwork
     */
    public void setApiNetwork(bitmusic.network.main.ApiHmiImpl apiNetwork) {
        this.apiNetwork = apiNetwork;
    }

    /**
     *
     * @return
     */
    public CategoriesComponent getCategoriesComponent() {
        return this.categoriesComponent;
    }

    /**
     *
     * @param categoriesComponent
     */
    public void setCategoriesComponent(CategoriesComponent categoriesComponent) {
        this.categoriesComponent = categoriesComponent;
    }

    /**
     *
     * @return
     */
    public ConnectionComponent getConnectionComponent() {
        return this.connectionComponent;
    }

    /**
     *
     * @param connectionComponent
     */
    public void setConnectionComponent(ConnectionComponent connectionComponent) {
        this.connectionComponent = connectionComponent;
    }

    /**
     *
     * @return
     */
    public MyProfileComponent getMyProfileComponent() {
        return this.myProfileComponent;
    }

    /**
     *
     * @param myProfileComponent
     */
    public void setMyProfileComponent(MyProfileComponent myProfileComponent) {
        this.myProfileComponent = myProfileComponent;
    }

    /**
     *
     * @return
     */
    public OnlineUsersComponent getOnlineUsersComponent() {
        return this.onlineUsersComponent;
    }

    /**
     *
     * @param onlineUsersComponent
     */
    public void setOnlineUsersComponent(OnlineUsersComponent onlineUsersComponent) {
        this.onlineUsersComponent = onlineUsersComponent;
    }

    /**
     *
     * @return
     */
    public PlayBarComponent getPlayBarComponent() {
        return this.playBarComponent;
    }

    /**
     *
     * @param playBarComponent
     */
    public void setPlayBarComponent(PlayBarComponent playBarComponent) {
        this.playBarComponent = playBarComponent;
    }

    /**
     *
     * @return
     */
    public SearchBarComponent getSearchBarComponent() {
        return this.searchBarComponent;
    }

    /**
     *
     * @param searchBarComponent
     */
    public void setSearchBarComponent(SearchBarComponent searchBarComponent) {
        this.searchBarComponent = searchBarComponent;
    }

    /**
     *
     * @return
     */
    public CentralAreaComponent getCentralAreaComponent() {
        return this.centralAreaComponent;
    }

    /**
     *
     * @param centralAreaComponent
     */
    public void setCentralAreaComponent(CentralAreaComponent centralAreaComponent) {
        this.centralAreaComponent = centralAreaComponent;
    }
}
