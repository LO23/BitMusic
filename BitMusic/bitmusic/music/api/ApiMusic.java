/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.api;
import bitmusic.music.data.Rights;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Grade;
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
     *
     * delete grade
     *
     * @param songID
     * @param authorId
     * @return false in order to send a comment request to the distant user
     */
     
    
     public boolean deleteGrade(String songId, String authorId);
    
     /**
     *
     * add a grade to a distant song
     *
     * @param songID
     * @param grade
     * @return false in order to send a comment request to the distant user
     */
     public boolean addGradeFromNetwork(String songID, Grade grade);
    
     /**
     * add a Grade to a local song
     *
     * @param songID
     * @param grade
     * @return true to indicate to IHM that the song was local and it has to
     * update the song
     */
    public boolean addGradeFromHmi(String songID, int grade);
    
      
      
       /**
     *
     * delete comment
     *
     * @param songID
     * @param authorId
     * @param date
     * @return false in order to send a comment request to the distant user
     */
    public boolean deleteComment(String songId, String authorId, Date date) ;
    
    
    
    /**
    * search a song by User 
    * 
    * @param userID
    * @param searchId 
    */
    public void searchSongsByUser(String userID, String searchId);  
    
    /**
     * Allows to search local and distant songs relative with the tagList
     * @param searchId The id of the search.
     * @param tagList The tag list to match.
     * @return local songs relative to the tagList.
     */
    public SongLibrary searchSongsByTags(String searchId, List<String> tagList);
    
    /**
     * Allows to search local songs relative with the tagList
     * @param tagList The tag list to match.
     * @param requestingUserId The user who demands the search / null if it is the local User
     * @return local songs relative to the tagList.
     */
    public SongLibrary searchLocalSongsByTags(List<String> tagList, String requestingUserId);
    
    /**
     * Allows to search local and distant songs relative with the albumList
     * @param searchId The id of the search.
     * @param albumList The albums list to match.
     * @return local songs relative to the albumList.
     */
    public SongLibrary searchSongsByAlbum(String searchId, List<String> albumList);
    
    /**
     * Allows to search local songs relative with the albumList
     * @param albumList The albums list to match.
     * @param requestingUserId The user who demands the search / null if it is the local User
     * @return local songs relative to the albumList.
     */
    public SongLibrary searchLocalSongsByAlbum(List<String> albumList, String requestingUserId);
    
    
    /**
     * Allows to search local and distant songs relative with the artistList
     * @param searchId The id of the search.
     * @param artistList The albums list to match.
     * @return local songs relative to the artistList.
     */
    public SongLibrary searchSongsByArtist(String searchId, List<String> artistList);
    
    /**
     * Allows to search local songs relative with the artistList
     * @param artistList The albums list to match.
     * @param requestingUserId The user who demands the search / null if it is the local User
     * @return local songs relative to the artistList.
     */
    public SongLibrary searchLocalSongsByArtist(List<String> artistList, String requestingUserId);
    
    /**
     * Allows to search local and distant songs relative with the titleList
     * @param searchId The id of the search.
     * @param titleList The titles list to match.
     * @return local songs relative to the titleList.
     */
    public SongLibrary searchSongsByTitle(String searchId, List<String> titleList);
    
   /**
     * Allows to search local songs relative with the titleList
     * @param titleList The titles list to match.
     * @param requestingUserId The user who demands the search / null if it is the local User
     * @return local songs relative to the titleList.
     */
    public SongLibrary searchLocalSongsByTitle(List<String> titleList, String requestingUserId);
    
    /**
     * WARNING : DOES NOT WORK FOR THE MOMENT - MUST BE IMPLEMENTED
     * Allows to search local and distant songs relative with the list
     * @param searchId The id of the search.
     * @param list The tags, artists, albums, titles, users list to match.
     * @return local songs relative to the list.
     */
    @Deprecated
    public SongLibrary searchSongsByAll(String searchId, List<String> list);
    
     /** 
    * Add a song to SongLibrary.
    * 
    * @param path  song path
    * @param title song title
    * @param album song album
    * @param tags  song tags
    * @param rights song rights
    */    
    public boolean importSong(String path, String title, String artist, String album, LinkedList<String> tags, HashMap<String,Rights> rights);
    
    /**
     * Delete a song from the SongLibrary (and the associated file).
     * 
     * @param songId
     * @return 
     */
    public boolean deleteSong(String songId);
    
    
    /**
     * Copy a song in temp folder to destination.
     * 
     * @param userId
     * @param songId
     * @param destination
     */
    public void saveSong(String userId, String songId, String destination);
    
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
     * Get the path of a temporary song identified by userId & songId.
     * @param userId userId
     * @param songId songId
     * @return path path of the song
     */
    public String getTempSongFile(String userId, String songId);
    
    /**
     * Get the destination path of the song to dowload.
     * @param userId
     * @param songId
     * @return path of the song to download
     */
    public String getSavedSongPath(String userId, String songId);
       
    /**
     * Initialization of the current user's music folder.
     * @throws IOException 
     */
    public void initMusicFolder();
}
