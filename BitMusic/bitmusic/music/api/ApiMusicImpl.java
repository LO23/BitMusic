/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.api;

import bitmusic.music.data.Comment;
import bitmusic.music.data.Rights;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.music.business.SongCommenter;
import bitmusic.music.business.SongLoader;
import bitmusic.music.business.SongPlayer;
import bitmusic.music.business.SongRater;
import bitmusic.music.business.SongSearcher;
import bitmusic.music.business.strategies.AlbumSearchStrategy;
import bitmusic.music.business.strategies.ArtistSearchStrategy;
import bitmusic.music.business.strategies.SongSearcherStrategy;
import bitmusic.music.business.strategies.TagSearchStrategy;
import bitmusic.music.business.strategies.TitleSearchStrategy;
import bitmusic.music.data.Grade;
import bitmusic.music.data.Song;
import bitmusic.music.exception.CopyMP3Exception;
import java.io.IOException;
import bitmusic.music.player.BitMusicPlayer;
import bitmusic.network.exception.NetworkException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Doha
 */
public final class ApiMusicImpl implements ApiMusic {

    /**
     * Singleton implementation.
     */
    private static final ApiMusicImpl APIMUSICIMPL = new ApiMusicImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiMusicImpl() {
    }

    /**
     * .
     * @return Unique instance of ApiMusicImpl
     */
    public static ApiMusicImpl getInstance() {
        return APIMUSICIMPL;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * add a comment to a local song
     *
     * @param songID
     * @param commentText
     * @return true to indicate to IHM that the song was local and it has to
     * update the song
     */
    public boolean addCommentFromHmi(String songID, String commentText) {

        SongCommenter songCommenter;
        SongLibrary localSongLibrary;
        boolean wasCommented = false;

        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        songCommenter = new SongCommenter(localSongLibrary);
        wasCommented = songCommenter.addCommentFromHMI(songID, commentText);

        //besoin de récupérer la SongLibrary local - attente de Profile
        return wasCommented;
    }

    /**
     *
     * add a comment to a distant song
     *
     * @param songID
     * @param commentText
     * @return false in order to send a comment request to the distant user
     */
    public boolean addCommentFromNetwork(String songID, Comment commentText) {
        SongCommenter songCommenter;
        SongLibrary localSongLibrary;
        boolean wasCommented = false;

        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        songCommenter = new SongCommenter(localSongLibrary);
        wasCommented = songCommenter.addCommentFromNetwork(songID, commentText);

        //besoin de récupérer la SongLibrary local - attente de Profile
        return wasCommented;
    }

    
    
    /**
     * add a Grade to a local song
     *
     * @param songID
     * @param grade
     * @return true to indicate to IHM that the song was local and it has to
     * update the song
     */
    public boolean addGradeFromHmi(String songID, int grade) {

        SongRater songRater ;
        SongLibrary localSongLibrary;
        boolean wasRated = false;

        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        songRater = new SongRater(localSongLibrary);
        wasRated = songRater.addGradeFromHMI(songID, grade);

        //besoin de récupérer la SongLibrary local - attente de Profile
        return wasRated;
    }

    /**
     *
     * add a grade to a distant song
     *
     * @param songID
     * @param grade
     * @return false in order to send a comment request to the distant user
     */
     public boolean addGradeFromNetwork(String songID, Grade grade) {

        SongRater songRater ;
        SongLibrary localSongLibrary;
        boolean wasRated = false;

        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        songRater = new SongRater(localSongLibrary);
        wasRated = songRater.addGradeFromNetwork(songID, grade);

        //besoin de récupérer la SongLibrary local - attente de Profile
        return wasRated;
    }
    
      /**
     *
     * delete comment
     *
     * @param songID
     * @param authorId
     * @param date
     * @return false in order to send a comment request to the distant user
     */
     
     
    public boolean deleteComment(String songId, String authorId, Date date) 
    
    {
        SongCommenter songCommenter;
        SongLibrary localSongLibrary;
        boolean commentWasDeleted = false;
        
        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        songCommenter = new SongCommenter(localSongLibrary);
        commentWasDeleted = songCommenter.deleteComment(songId, authorId, date);
        
        return commentWasDeleted;
         
     }
    
      /**
     *
     * delete grade
     *
     * @param songID
     * @param authorId
     * @return false in order to send a comment request to the distant user
     */
      public boolean deleteGrade(String songId, String authorId)
      
      {
        SongRater songRater ;
        SongLibrary localSongLibrary;
        boolean gradeWasDeleted = false;
        
        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        songRater = new SongRater(localSongLibrary);
        gradeWasDeleted=songRater.deleteGrade(songId, authorId);
        
        return gradeWasDeleted;
      }
     
   
   /**
    * search a song by User 
    * 
    * @param userID
    * @param searchId 
    */
   public void searchSongsByUser(String userID, String searchId) {
        SongLibrary localSongLibrary;
        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();

        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        songSearcher.searchSongsbyUser(userID, searchId);
    }
   
    /**
     * Add a song to SongLibrary
     *
     * @param path song path
     * @param title song title
     * @param album song album
     * @param tags song tags
     * @param rights song rights
     */
    public void importSong(String path, String title, String artist, String album, LinkedList<String> tags, HashMap<String, Rights> rights) {
        SongLoader songLoader = new SongLoader();
        try {
            songLoader.importSong(path, title, artist, album, tags);
        } catch (CopyMP3Exception excep) {
            System.out.println(excep.getMessage());
        } catch ( IOException excep) {
            System.out.println(excep.getMessage());
        }

    }
    
    public void playSong(Song song) {
        SongPlayer songPlayer = new SongPlayer();
        try {
            songPlayer.playSong(song);
        } catch (NetworkException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * play a song from a distant user
     *
     * @param path song path
     */
    public void playSongFromStart(String path) {
        try {
            BitMusicPlayer.getInstance().play(path);
        } catch (IOException ioe) {
            System.out.println("Player : can't read file");
        } catch (Exception e) {
            System.out.println("Player : ca marche pas");
        }
    }

    /**
     * Start a song at a specific frame.
     * @param frameNumber The number of the frame.
     */
    public void playSongFromSpecificFrame(int frameNumber) {
        try {
            BitMusicPlayer.getInstance().play(frameNumber);
        } catch (IOException ioe) {
            System.out.println("Player : can't read file");
        } catch (Exception e) {
            System.out.println("Player : can't play");
        }
    }
    
    /**
     * Stop a song. The song can be resume until a new song is not requested.
     */
    public void pause() {
        try {
            BitMusicPlayer.getInstance().pause();
        } catch (Exception e) {
            System.out.println("Player : can't pause");
        }
    }
    
    /**
     * Stop a song. The song can be resume until a new song is not requested.
     */
    public void stop() {
        try {
            BitMusicPlayer.getInstance().stop();
        } catch (Exception e) {
            System.out.println("Player : can't pause");
        }
    }
    
    /**
     * Resume a song which was stopped.
     */
    public void resumeSong() {
        try {
            BitMusicPlayer.getInstance().resume();
        }catch(IOException ioe){
            System.out.println("Player : can't read file");
        } catch (Exception e) {
            System.out.println("Player : can't resume");
        }
    }
    
    /**
     * Get the total number of frame of song. 
     * The song must be played to have a result.
     * @return The total number of frame.
     */
    public int getNumberOfFrame() {
        return BitMusicPlayer.getInstance().getTotalFrame();
    }
    
    /**
     * Get the current frame which is played.
     * @return The frame played
     */
    public int getCurrentFrame() {
        return BitMusicPlayer.getInstance().getCurrentFrame();
    }
    
    /**
     * Get the path of a local song identified by songId
     * @param songId songId
     * @return path path of the song
     */
    public String getSongFile(String songId) {
        SongLoader songLoader = new SongLoader();
        return songLoader.getSongPath(songId);
    }
    
    /**
     * Get the path of a temporary song identified by userId & songId
     * @param userId userId
     * @param songId songId
     * @return path path of the song
     */
    public String getTempSongFile(String userId, String songId){
        SongLoader songLoader = new SongLoader();
        return songLoader.getTempSongPath(userId, songId);
    }
    
    /**
     * Initialization of the current user's music folder.
     * @throws IOException 
     */
    public void initMusicFolder(){
        SongLoader songLoader = new SongLoader();
        try {
            songLoader.createMusicFolders();
        } catch (IOException excep) {
            System.out.println(excep.getMessage());
        }
    }

    @Override
    public SongLibrary searchSongsByTags(String searchId, List<String> tagList) {
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        SongLibrary localTaggedSongs = songSearcher.searchSongs(searchId, tagList, new TagSearchStrategy());
        return localTaggedSongs;
    }

    @Override
    public SongLibrary searchSongsByAlbum(String searchId, List<String> albumList) {
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        SongLibrary localTaggedSongs = songSearcher.searchSongs(searchId, albumList, new AlbumSearchStrategy());
        return localTaggedSongs;
    }

    @Override
    public SongLibrary searchSongsByArtist(String searchId, List<String> artistList) {
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        SongLibrary localTaggedSongs = songSearcher.searchSongs(searchId, artistList, new ArtistSearchStrategy());
        return localTaggedSongs;
    }

    @Override
    public SongLibrary searchSongsByTitle(String searchId, List<String> titleList) {
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        SongLibrary localTaggedSongs = songSearcher.searchSongs(searchId, titleList, new TitleSearchStrategy());
        return localTaggedSongs;
    }

    @Override
    public SongLibrary searchSongsByAll(String searchId, List<String> list) {
        SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();
        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        SongLibrary localTaggedSongs = songSearcher.searchSongs(searchId, list, new TagSearchStrategy());
        return localTaggedSongs;
    }
}
