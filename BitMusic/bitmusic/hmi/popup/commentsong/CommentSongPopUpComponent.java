/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.commentsong;

import bitmusic.hmi.patterns.AbstractComponent;
import bitmusic.music.data.Song;

/**
 * classe des components du SongPopUp
 * @author IHM
 */
public final class CommentSongPopUpComponent extends AbstractComponent<CommentSongPopUpModel, CommentSongPopUpView, CommentSongPopUpController> {


    private Song song;

    public CommentSongPopUpComponent(Song song, int parentTabId) {
        this.model = new CommentSongPopUpModel(song);
        this.view = new CommentSongPopUpView(parentTabId);

        this.controller = new CommentSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
