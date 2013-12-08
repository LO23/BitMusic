/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class RateSongPopUpComponent extends AbstractComponent<RateSongPopUpModel, RateSongPopUpView, RateSongPopUpController> {

    private Song song;
    public RateSongPopUpComponent(Song song) {

        this.song = song;

        this.model = new RateSongPopUpModel(song);
        this.view = new RateSongPopUpView();
        this.controller = new RateSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
