/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;
import java.util.Date;

/**
 *
 * @author Bruno
 */
public class Comment {
    
    /**
     * Song's comment (out of 5).
     */
	private String commentText;
	
    /**
     * Comment's author (out of 5).
     */
	private String authorId;
	
    /**
     * Comment's date (out of 5).
     */
	private Date commentDate;
	
    /**
     * Class constructor.
     * 
     * @param author    CurrentUserId
     * @param comment   Comment given by user
     */
    Comment(String author, String comment) {
        this.authorId = author;
        this.commentText = comment;
		this.commentDate = new Date();
    }
	
    /**
     * CommentText Getter.
     * @return this grade
     */
    public String getComment() {
        return this.commentText;
    }
	
    /**
     * Grade Getter.
     * @return this grade
     */
    public String getAuthor() {
        return this.authorId;
    }
	
    /**
     * Grade Getter.
     * @return this grade
     */
    public Date getDate() {
        return this.commentDate;
    }
}
