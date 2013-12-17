/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.business;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.music.player.BitMusicPlayer;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.main.ApiMusicImpl;
import bitmusic.network.main.Controller;
import bitmusic.profile.api.ApiProfileImpl;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;

/**
 * Class which manage the song player.
 * @author Thomas
 */
public class SongPlayer {
    
    public void playSong(Song song) throws NetworkException {
        ApiMusicImpl apiMusic = Controller.getInstance().getApiMusic();
        ApiProfileImpl apiProfile = ApiProfileImpl.getApiProfile();
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongLoader songLoader = new SongLoader();
        String path = null;
        boolean isLocal = false;
        
        // Get the path of the local song.
        if (localSongLibrary.islocal(song.getSongId())) {
            path = songLoader.getSongPath(song.getSongId());
            isLocal = true;
        } else if (isTmp(song)) {
            path = songLoader.generateTempSongPath(song.getOwnerId(), song.getSongId());
            isLocal = true;
        }
            
        // If the song is local play the temporary file else call the network.
        if (isLocal) {
            try {
                BitMusicPlayer.getInstance().play(songLoader.getSongPath(song.getSongId()));
            } catch (JavaLayerException ex) {
                Logger.getLogger(SongPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SongPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            apiMusic.getSongFile(apiProfile.getCurrentUser().getUserId(), song.getOwnerId(), song.getSongId(), true);
        }
    }
    
    /**
     * Return true if the song is in the temporary directory.
     * Code pas jolie du tout, point a ameliore
     * @param song
     * @return True if the song is in the temporary directory.
     */
    private boolean isTmp(Song song) {
        SongLoader songLoader = new SongLoader();
        File f = new File(songLoader.generateTempSongPath(song.getOwnerId(), song.getSongId()));
        return f.exists();
    }
}
