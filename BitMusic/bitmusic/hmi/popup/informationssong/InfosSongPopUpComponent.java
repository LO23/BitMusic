/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 * Components class of InfosSongPopUp
 * @author IHM
 */
public final class InfosSongPopUpComponent extends AbstractComponent<InfosSongPopUpModel, InfosSongPopUpView, InfosSongPopUpController> {

    private Song song;

    /**
     * Constructor of InfosSongPopUpComponent
     * @param song
     * @param parentTabId
     */
    public InfosSongPopUpComponent(Song song, int parentTabId) {
        this.song = song;

        this.model = new InfosSongPopUpModel(song);
        this.view = new InfosSongPopUpView(parentTabId);
        this.controller = new InfosSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
