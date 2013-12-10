/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.rightclicksong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class RightClickSongPopUpComponent extends AbstractComponent<RightClickSongPopUpModel, RightClickSongPopUpView, RightClickSongPopUpController> {

    private Song song;

    /**
     *
     * @param song
     * @param parentTabId
     */
    public RightClickSongPopUpComponent(Song song, int parentTabId) {
        this.song = song;

        this.model = new RightClickSongPopUpModel();
        this.view = new RightClickSongPopUpView(parentTabId);
        this.controller = new RightClickSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
