/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.business;

import bitmusic.music.data.SongLibrary;
import bitmusic.music.data.Grade;
import bitmusic.music.data.Song;
import java.util.*;

/**
 *
 * @author Bruno
 */
public class SongRater {

    /**
     * SongLibrary.
     */
    private SongLibrary songLib;

    /**
     * Class constructor.
     *
     * @param lib The Song Library
     */
    public SongRater(SongLibrary lib) {
        this.songLib = lib;
    }

    /**
     * Add a grade fron HMI.
     *
     * @param songId    Song ID
     * @param grade     Grade given by user (int out of 5)
     *
     * @return true
     */
    public boolean addGradeFromHMI(String songId, int grade) {
        Song mySong = songLib.getSong(songId);
        String author = "blabla"; //To Do
        Grade myGrade = new Grade(author, grade);

        mySong.addGrade(myGrade);

        return true;
    }

    /**
     * Add a grade fron network.
     *
     * @param songId Song ID
     * @param grade Grade given by user (Grade)
     *
     * @return true
     */
    public boolean addGradeFromNetwork(String songId, Grade grade) {
        Song mySong = songLib.getSong(songId);

        mySong.addGrade(grade);

        return true;
    }
    
    /**
     * Remove a grade.
     *
     * @param songId Song ID
     * @param authorId author ID
     *
     * @return true
     */
    public boolean deleteGrade(String songId, String authorId) {
        Song mySong = songLib.getSong(songId);

        mySong.deleteGrade(authorId);

        return true;
    }
    
    /**
     * Get comments.
     *
     * @param songId Song ID
     *
     * @return true
     */
    public HashMap<String,Grade> getGrades(String songId) {
        Song mySong = songLib.getSong(songId);

        return mySong.getGrades();
    }
}
