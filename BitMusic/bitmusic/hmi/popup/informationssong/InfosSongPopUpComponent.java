/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpComponent extends AbstractComponent<InfosSongPopUpModel, InfosSongPopUpView, InfosSongPopUpController> {

    private Song song;

    public InfosSongPopUpComponent(Song song) {
        this.song = song;
        
        this.model = new InfosSongPopUpModel(song);
        this.view = new InfosSongPopUpView();
        this.controller = new InfosSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
