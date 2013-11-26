/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.business;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.music.player.BitMusicPlayer;
import bitmusic.network.main.ApiMusicImpl;
import bitmusic.network.main.Controller;
import bitmusic.profile.api.ApiProfileImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Thomas
 */
public class SongPlayer {
    
    public void playSong(Song song) {
        ApiMusicImpl apiMusic = Controller.getInstance().getApiMusic();
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongLoader songLoader = new SongLoader();
        
        if (localSongLibrary.islocal(song.getSongId())) {
            try {
                BitMusicPlayer.getInstance().play(songLoader.getSongPath(song.getSongId()));
            } catch (JavaLayerException ex) {
                Logger.getLogger(SongPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SongPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            apiMusic.
        }
        
    }
