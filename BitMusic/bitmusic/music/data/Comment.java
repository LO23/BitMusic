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
     * Song's comment.
     */
	private String commentText;
	
    /**
     * Comment's author.
     */
	private String authorId;
	
    /**
     * Comment's date.
     */
	private Date commentDate;
	
    /**
     * Class constructor.
     * 
     * @param author    CurrentUserId
     * @param comment   Comment given by user
     */
    public Comment(String author, String comment) {
        this.authorId = author;
        this.commentText = comment;
        this.commentDate = new Date();
    }
	
    /**
     * CommentText Getter.
     * @return this commentText
     */
    public String getComment() {
        return this.commentText;
    }
	
    /**
     * Author Getter.
     * @return this authorId
     */
    public String getAuthor() {
        return this.authorId;
    }
	
    /**
     * Date Getter.
     * @return this commentDate
     */
    public Date getDate() {
        return this.commentDate;
    }
}
