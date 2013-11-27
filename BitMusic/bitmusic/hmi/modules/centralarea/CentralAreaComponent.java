/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.centralarea;

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

    public void CentralAreaInit(){

        TabComponent tabComponent = new TabComponent();
        ArrayList<Song> songList = new ArrayList<Song>();
        songList.add(new Song("1", "Make me", "Avicii", "BOUILLA", new LinkedList()));
        songList.add(new Song("2", "Wake me up", "Avicii", "BOUILLA2", new LinkedList()));
        tabComponent.getModel().getModeleTable().setSong(songList);
        tabComponent.getModel().setRequestFilter(this.getController().getFILTER_NONE());
        tabComponent.getModel().setRequestOrigin(this.getController().getORIGIN_MY_PROFILE());
        tabComponent.getModel().setRequestText("");
        this.getView().addTabComponent(tabComponent);

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
}
