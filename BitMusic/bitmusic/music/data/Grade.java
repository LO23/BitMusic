/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;

/**
 *
 * @author Jean-Baptiste
 */
public class Grade {
    /**
     * Song's grade (out of 5).
     */
    private int grade;

    /**
     * Grade's author.
     */
    private String authorId;
    
    /**
     * Class constructor.
     * 
     * @param author    CurrentUserId
     * @param newgrade  Grade given by user
     */
    public Grade(String author, int newgrade) {
        this.authorId = author;
        this.grade = newgrade;
    }
    
    /**
     * Grade Getter.
     * @return this grade
     */
    public int getGrade() {
        return this.grade;
    }

    /**
     * AuthorId Getter.
     * @return this authorId
     */
    public String getAuthorId() {
        return this.authorId;                    
    }
}
