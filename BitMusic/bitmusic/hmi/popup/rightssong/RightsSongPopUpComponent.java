/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.rightssong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class RightsSongPopUpComponent extends AbstractComponent<RightsSongPopUpModel, RightsSongPopUpView, RightsSongPopUpController> {

    private Song song;

    public RightsSongPopUpComponent(Song song, int parentTabId) {
        this.song = song;

        this.model = new RightsSongPopUpModel();
        this.view = new RightsSongPopUpView(parentTabId);
        this.controller = new RightsSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
