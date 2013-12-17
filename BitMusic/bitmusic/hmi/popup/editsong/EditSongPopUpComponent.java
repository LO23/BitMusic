/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 * classe des components de EditSongPopUp
 * @author IHM
 */
public final class EditSongPopUpComponent extends AbstractComponent<EditSongPopUpModel, EditSongPopUpView, EditSongPopUpController> {

    private Song song;

    /**
     * Constructeur de EditSongPopUpComponent
     * @param song
     * @param parentTabId
     */
    public EditSongPopUpComponent(Song song, int parentTabId) {
        this.song = song;

        this.model = new EditSongPopUpModel(song);
        this.view = new EditSongPopUpView(parentTabId);
        this.controller = new EditSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }

}
