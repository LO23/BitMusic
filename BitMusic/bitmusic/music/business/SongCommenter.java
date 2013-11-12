/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.business;

import bitmusic.music.data.SongLibrary;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;

/**
 *
 * @author Bruno
 */
public class SongCommenter {

    /**
     * SongLibrary.
     */
    private SongLibrary songLib;

    /**
     * Class constructor.
     *
     * @param lib The Song Library
     */
    public SongCommenter(SongLibrary lib) {
        this.songLib = lib;
    }

    /**
     * Add a comment fron HMI.
     *
     * @param songId Song ID
     * @param commentText Comment given by user (String)
     *
     * @return true
     */
    public boolean addCommentFromHMI(String songId, String commentText) {
        Song mySong = songLib.getSong(songId);
        String author = "blabla"; //To Do
        Comment myComment = new Comment(author, commentText);

        mySong.addComment(myComment);

        return true;
    }

    /**
     * Add a comment fron network.
     *
     * @param songId Song ID
     * @param commentText Comment given by user (Comment)
     *
     * @return true
     */
    public boolean addCommentFromNetwork(String songId, Comment commentText) {
        Song mySong = songLib.getSong(songId);

        mySong.addComment(commentText);

        return true;
    }
}
