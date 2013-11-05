package bitmusic.music.data;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class which allows to manage a song.
 * @author Elthum
 */
public class Song {
    
    //################################################################//
    //########################## ATTRIBUTES ##########################//
    //################################################################//
    
    /**
     * References the sond id.
     */
    private String songId;
    
    /**
     * References the title of the song.
     */
    private String title;
    
    /**
     * References the artist of the song.
     */
    private String artist;
    
    /**
     * References the album og the song.
     */
    private String album;
    
    /**
     * References the list of tags.
     */
    private LinkedList<String> tags;
    
    /**
     * References the song comments.
     */
    private LinkedList<Comment> comments;
    
    /**
     * References the song grades.
     */
    private LinkedList<Grade> grades;
    
    /**
     * References the owner id.
     */
    private String ownerId;
    
    /**
     * References the rights by category.
     */
    private HashMap<String,Rights> rightsByCategory;
    
    /**
     * References the local rights
     */
    private Rights localRights;
    
    //##################################################################//
    //######################### CONSTRUCTORS ###########################//
    //##################################################################//
        
    //##################################################################//
    //########################### METHODS ##############################//
    //##################################################################//
    
    /**
     * Add or replace a comment on a song.
     * @param comment The comment to add.
     */
    public void addComment(Comment comment) {
    }
    
    /**
     * Delete a comment from a song.
     * @param authorId The author of the song.
     */
    public void deleteComment(String authorId) {
        
    }
    
    /**
     * Add or replace a grade to the song.
     * @param grade The grade to add or replace.
     */
    public void addGrade(Grade grade) {
    }
    
    /**
     * Delete a grade from a song.
     * @param authorId The author of the grade.
     */
    public void deleteGrade(String authorId) {
    }
    
    /**
     * Add or update the right of a category
     * @param categoryName The category's name to update or add.
     * @param rights The rights to associate to the category.
     */
    public void updateCategory(String categoryName, Rights rights) { 
        this.rightsByCategory.put(categoryName, rights);
    }
    
    /**
     * Delete a category with its rights in a song?
     * @param categoryName The category to delete.
     */
    public void deleteCategory(String categoryName) {
        this.rightsByCategory.remove(categoryName);
    }
    
    //##################################################################//
    //####################### GETTER & SETTER ##########################//
    //##################################################################//
   
    /**
     * Getter of the attribute songId.
     * @return The song id.
     */
    public String getSongId() {
        return songId;
    }

    /**
     * Getter of the attribute title.
     * @return The title of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter of the attribute title.
     * @param title The new title of the song.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter of the attribute artist.
     * @return the artist of the song.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter of the attribute album.
     * @return The album of the song.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Getter of the attribute tags.
     * @return The list of tags.
     */
    public LinkedList<String> getTags() {
        return tags;
    }


    /**
     * Getter of the attribute comments.
     * @return The list of comments.
     */
    public LinkedList<Comment> getComments() {
        return comments;
    }

    /**
     * Getter of the attribute grades.
     * @return The list of grades.
     */
    public LinkedList<Grade> getGrades() {
        return grades;
    }

    /**
     * Getter of the attribute ownerId.
     * @return The owner id of the song.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Getter of the attribute localRight
     * @return The rights of the local user.
     */
    public Rights getLocalRights() {
        return localRights;
    }
}
