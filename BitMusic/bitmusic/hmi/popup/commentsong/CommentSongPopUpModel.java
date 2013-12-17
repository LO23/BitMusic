/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.commentsong;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Song;

/**
 * La classe du modèle de CommentSongPopUp
 * @author IHM
 */
public final class CommentSongPopUpModel extends AbstractModel {


    private Song song;
/**
 * Constructeur de la classe CommentSongPopUp
 * @param song
 */
    public CommentSongPopUpModel(Song song) {
        super();
        this.song = song;
    }
/**
 * Retourne le song à commenter
 * @return le song à commenter sous forme d'un objet de type song.
 */
    public Song getSong() {
        return song;
    }
}
