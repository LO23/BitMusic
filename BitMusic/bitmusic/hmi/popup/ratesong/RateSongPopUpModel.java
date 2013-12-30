/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;

/**
 * Model class of RateSongPopUp
 * @author IHM
 */
public final class RateSongPopUpModel extends AbstractModel {

    private Song song;

    /**
     * Constructor of RateSongPopUpModel
     * @param song
     */
    public RateSongPopUpModel(Song song) {
        super();
        this.setSong(song);
    }

    /**
     * Returns a song model
     * @return Song song
     */
    public Song getSong() {
        return song;
    }

    /**
     * Updates a song model
     * @param song
     */
    public void setSong(Song song) {
        this.song = song;
    }

}
