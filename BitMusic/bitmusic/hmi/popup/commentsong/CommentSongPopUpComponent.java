/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.commentsong;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class CommentSongPopUpComponent extends AbstractComponent<CommentSongPopUpModel, CommentSongPopUpView, CommentSongPopUpController> {

    public CommentSongPopUpComponent() {
        this.model = new CommentSongPopUpModel();
        this.view = new CommentSongPopUpView();
        this.controller = new CommentSongPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}
