/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.commentsong;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;

/**
 * Model class of CommentSongPopUp
 * @author IHM
 */
public final class CommentSongPopUpModel extends AbstractModel {


    private Song song;
/**
 * Constructor of CommentSongPopUp
 * @param song
 */
    public CommentSongPopUpModel(Song song) {
        super();
        this.song = song;
    }
/**
 * Returns a song to comment
 * @return Song song
 */
    public Song getSong() {
        return song;
    }
}
