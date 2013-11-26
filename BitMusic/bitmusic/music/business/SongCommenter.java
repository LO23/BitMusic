/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.business;

import bitmusic.music.data.SongLibrary;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import java.util.*;
import bitmusic.profile.api.ApiProfileImpl;

/**
 * Class managing the comments of songs.
 *
 * @author Music Team
 */
public class SongCommenter {

    /**
     * SongLibrary.
     */
    private SongLibrary songLib;

    /**
     * Api Profile.
     */
    private ApiProfileImpl apiProfil;

    /**
     * Class constructor.
     *
     * @param lib The Song Library
     */
    public SongCommenter(SongLibrary lib) {
        this.songLib = lib;
        apiProfil = ApiProfileImpl.getApiProfile();
    }

    /**
     * Add a comment from HMI.
     *
     * @param songId Song ID
     * @param commentText Comment given by user (String)
     *
     * @return true
     */
    public boolean addCommentFromHMI(String songId, String commentText) {
        Song mySong = songLib.getSong(songId);
        String author = apiProfil.getCurrentUser().getLogin();
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

    /**
     * Remove a comment.
     *
     * @param songId Song ID
     * @param authorId author ID
     * @param date Date of the comment to remove (Comment)
     *
     * @return true
     */
    public boolean deleteComment(String songId, String authorId, Date date) {
        Song mySong = songLib.getSong(songId);

        mySong.deleteComment(authorId, date);

        return true;
    }

    /**
     * Get comments.
     *
     * @param songId Song ID
     *
     * @return true
     */
    public LinkedList<Comment> getComments(String songId) {
        Song mySong = songLib.getSong(songId);

        return mySong.getComments();
    }
}
