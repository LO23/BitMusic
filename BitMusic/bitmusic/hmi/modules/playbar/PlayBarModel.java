/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarModel extends AbstractModel {

    private boolean isPlaying = false;
    private int frame;
    private Song song = null;

    public PlayBarModel() {
        super();
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
        //Arrête la musique en cours de lecture
        WindowComponent.getInstance().getPlayBarComponent().getController().new StopListener().actionPerformed(null);
    }


    public boolean isPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
        this.notifyObservers("isPlaying");
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }


}
