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
import javax.swing.JTabbedPane;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaComponent extends AbstractComponent<CentralAreaModel, CentralAreaView, CentralAreaController> {

    private ArrayList<TabComponent> listTabComponent = new ArrayList<>();

    public CentralAreaComponent() {
        this.model = new CentralAreaModel();
        this.view = new CentralAreaView();
        this.controller = new CentralAreaController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }

    public void CentralAreaInit(){

        TabComponent tabComponent = new TabComponent();
        ArrayList<Song> songList = new ArrayList<Song>();
        songList.add(new Song("1", "Make me", "Avicii", "BOUILLA", new LinkedList()));
        songList.add(new Song("2", "Wake me up", "Avicii", "BOUILLA2", new LinkedList()));
        tabComponent.getModel().getModeleTable().setSong(songList);
        tabComponent.getModel().setRequestFilter(this.getController().getFILTER_NONE());
        tabComponent.getModel().setRequestOrigin(this.getController().getORIGIN_MY_PROFILE());
        tabComponent.getModel().setRequestText("");
        this.addTabComponent(tabComponent);

        //this.getView().addTab(tabComponent.getView());

//       // if (!WindowComponent.getInstance().getApiProfile().getCurrentUser().getLocalSongs().getlibrary().isEmpty())
//        if (false)
//            this.tabComponent.getModel().getModeleTable().setSong(WindowComponent.getInstance().getApiProfile().getCurrentUser().getLocalSongs().getlibrary());
//        else{
//            songList.add(new Song("","Make me","Avicii","BOUILLA",null));
//            songList.add(new Song("","Wake me up","Avicii","BOUILLA2",null));
//            this.tabComponent.getModel().getModeleTable().setSong(songList);
//        }

    }

    public ArrayList<TabComponent> getListTabComponent() {
        return listTabComponent;
    }

    public void setListTabComponent(ArrayList<TabComponent> listTabComponent) {
        this.listTabComponent = listTabComponent;
    }

    public void addTabComponent(TabComponent tabComponent) {
        this.listTabComponent.add(tabComponent);
        // Identifie le tab par un tabId pour sa suppression
        int tabId = this.getView().addTab(tabComponent.getView());
        tabComponent.setTabId(tabId);
    }

    public void removeTabComponent(TabComponent tabComponent) {
        //Suppression de la liste de TabComponent
        this.listTabComponent.remove(tabComponent);
        //Suppression de la vue
        this.getView().removeTab(tabComponent.getView());
    }

    public void removeTabComponentWithTabId(int tabId) {
        for (int i=0; i<this.listTabComponent.size(); i++ ) {
            if (listTabComponent.get(i).getTabId() == tabId) {
                this.removeTabComponent(listTabComponent.get(i));
            }
            else {
                System.out.println("Aucun tab trouvé avec le numéro tabId " + tabId);
            }
        }
    }

}
