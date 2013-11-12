/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.api;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Rights;
import java.util.ArrayList;

/**
 *
 * @author Doha
 */

public class ApiMusicImpl implements ApiMusic {
    
    /**
     * add a comment to a local song
     * 
     * @param songID 
     * @param commentText
     * @return true to indicate to IHM that the song was local and it has to update the song
     */
   public boolean addCommentFromHmi(String songID, String commentText) {
       
       // TO DO
    return true;
    };
   
   /**
    * 
    * add a comment to a distant song
    * 
    * @param songID
    * @param commentText
    * @return false in order to send a comment request to the distant user 
    */
 
   public boolean addCommentFromNetwork(String songID, Comment commentText) {
       
       // TO DO
   
       return false;
   };
   
   /**
    * search a song by User 
    * 
    * @param userID
    * @param searchId 
    */
   public void searchSongsByUser(String userID, String searchId) {
       
       // TO DO
   
   };
   
   /** 
    * Add a song to SongLibrary
    * 
    * @param path  song path
    * @param title song title
    * @param album song album
    * @param tags  song tags
    * @param rights song rights
    */
   public void importSong(String path, String title, String album, ArrayList<String> tags, Rights rights) {
       
       // TO DO
   
   };
   
   /**
    * update a song rights
    * 
    * @param songid
    * @param rights 
    */
    public void changeRigthsOfThisSong (String songid, Rights rights) {
        
        // TO DO
    
    };
    
    /**
     * play a song from a distant user
     * 
     * @param path song path
     */
    public void playSong (String path) {
        
        // TO DO
    
    };
    
    public String getSongFile (String songid) {
        
        // TO DO
        
    return songid;
    };
    
    
}
