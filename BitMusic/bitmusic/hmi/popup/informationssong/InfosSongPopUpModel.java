/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpModel extends AbstractModel {

    private Song song;

    /**
     *
     * @param song
     */
    public InfosSongPopUpModel(Song song) {
        super();
        this.setSong(song);

    }

    /**
     *
     * @return
     */
    public Song getSong() {
        return song;
    }

    /**
     *
     * @param song
     */
    public void setSong(Song song) {
        this.song = song;
        this.notifyObservers("SHOW_SONG_INFOS");
    }
}
