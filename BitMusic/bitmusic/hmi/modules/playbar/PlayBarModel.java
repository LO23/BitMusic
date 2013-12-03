/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarModel extends AbstractModel {

    private Song song;

    public PlayBarModel() {
        super();
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    
}
