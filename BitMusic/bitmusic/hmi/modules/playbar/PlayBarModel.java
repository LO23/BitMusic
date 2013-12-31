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
 * @author IHM
 */
public final class PlayBarModel extends AbstractModel {

    private boolean isPlaying = false;
    private int frame;
    private Song song = null;

    /**
     * Constructor of PlayBarModel
     */
    public PlayBarModel() {
        super();
    }

    /**
     *
     * @return Song song
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
        //Arrête la musique en cours de lecture
        WindowComponent.getInstance().getPlayBarComponent().getController().new StopListener().actionPerformed(null);
        this.notifyObservers("Song loaded");
    }

    /**
     *
     * @return boolean
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     *
     * @param isPlaying
     */
    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
        this.notifyObservers("isPlaying");
    }

    /**
     *
     * @return frame
     */
    public int getFrame() {
        return frame;
    }

    /**
     *
     * @param frame
     */
    public void setFrame(int frame) {
        this.frame = frame;
    }

}
