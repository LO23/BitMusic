/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Model class of InfosSongPopUp
 * @author IHM
 */
public final class InfosSongPopUpModel extends AbstractModel {

    private Song song;
    private LinkedList<Comment> commentsOnTheSong;
    // couple <author, comment>
    // liste de couple de string
    private Vector<String[]> comments = new Vector<String[]>();
    //private List<String> commentsValue = new ArrayList<String>();



    /**
     * Contructor of InfosSongPopUpModel
     * @param song
     */
    public InfosSongPopUpModel(Song song) {
        super();
        this.setSong(song);
        this.commentsOnTheSong = song.getComments();
        /*for (Comment c: this.commentsOnTheSong) {
            String[] tmp = {c.getAuthor(), c.getComment()};
            this.comments.add(tmp);
        }*/
    }

    /**
     * Returns a song
     * @return Song song
     */
    public Song getSong() {
        return song;
    }

    /**
     * Updates a song
     * @param song
     */
    public void setSong(Song song) {
        this.song = song;
        this.notifyObservers("SHOW_SONG_INFOS");
    }
    /**
     * Returns a list of comments of a song
     * @return LinkedList commentsOnTheSong
     */
    public LinkedList<Comment> getCommentsOnTheSong() {
        return commentsOnTheSong;
    }
    /**
     * Returns a list of comments
     * @return List comments
     */
    public List<String[]> getComments() {
        return comments;
    }

    // peut-être il faudra implémenter une méthode getCommentAuthor en passant par la liste comments

}
