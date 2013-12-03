/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.api;
import bitmusic.music.data.Rights;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import java.util.*;

/**
 *
 * @author Rym
 */

public interface ApiMusic {
    
     /**
     * add a comment to a local song
     * 
     * @param songID 
     * @param commentText
     * @return true to indicate to IHM that the song was local and it has to update the song
     */
    
    public boolean addCommentFromHmi(String songID, String commentText);
    
     /**
    * 
    * add a comment to a distant song
    * 
    * @param songID
    * @param commentText
    * @return false in order to send a comment request to the distant user 
    */
    
    public boolean addCommentFromNetwork(String songID, Comment commentText);
    
     /**
    * search a song by User 
    * 
    * @param userID
    * @param searchId 
    */
    
    
    public void searchSongsByUser(String userID, String searchId);  
    
    
    /**
     * 
     */
    public SongLibrary searchSongsByTags(String searchId, List<String> tagList);
    
     /** 
    * Add a song to SongLibrary
    * 
    * @param path  song path
    * @param title song title
    * @param album song album
    * @param tags  song tags
    * @param rights song rights
    */
    
    public void importSong(String path, String title, String artist, String album, LinkedList<String> tags, HashMap<String,Rights> rights);
     
    /**
     * play a song from a distant user
     *
     * @param path song path
     */
    public void playSongFromStart (String path);
    
    /**
     * Start a song at a specific frame.
     * @param frameNumber The number of the frame.
     */
    public void playSongFromSpecificFrame(int frameNumber);
    
    /**
     * Play a remote or a local song.
     * @param song 
     */
    public void playSong(Song song);
            
    /**
     * Pause a song. The song can be resume until a new song is not requested.
     */
    public void pause();
    
    /**
     * Stop a song. Must use play for play a song.
     */
    public void stop();
    
    /**
     * Resume a song which was stopped.
     */
    public void resumeSong();
    
    /**
     * Get the total number of frame of song. 
     * The song must be played to have a result.
     * @return The total number of frame.
     */
    public int getNumberOfFrame();
    
    /**
     * Get the current frame which is payed.
     * @return The frame played
     */
    public int getCurrentFrame();
    
    /**
     * Get the path of a local song identified by songId
     * @param songId songId
     * @return path path of the song
     */
    public String getSongFile (String songId);
    
    /**
     * Get the path of a temporary song identified by userId & songId
     * @param userId userId
     * @param songId songId
     * @return path path of the song
     */
    public String getTempSongFile(String userId, String songId);
       
    /**
     * Initialization of the current user's music folder.
     * @throws IOException 
     */
    public void initMusicFolder();
}
