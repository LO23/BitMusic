/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.api;

import bitmusic.music.data.Comment;
import bitmusic.music.data.Rights;
import bitmusic.music.data.SongLibrary;
import java.util.ArrayList;
import java.util.*;
import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.music.business.SongCommenter;
import bitmusic.music.business.SongLoader;
import bitmusic.music.business.SongSearcher;
import bitmusic.music.exception.CopyMP3Exception;
import java.io.IOException;
import bitmusic.music.player.BitMusicPlayer;

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

    ;
   
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
            songLoader.importSong(path, title, artist, album, tags, rights);
        } catch (CopyMP3Exception | IOException excep) {
            System.out.println(excep.getMessage());
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
    public void pauseOrStopSong() {
        try {
            BitMusicPlayer.getInstance().pause();
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
     * Get the
     * @param searchId
     * @param tagList
     * @return
     */
    @Override
    public SongLibrary searchSongsByTags(String searchId, List<String> tagList) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        SongLibrary localSongLibrary;
        localSongLibrary = ApiProfileImpl.getApiProfile().getSongLibrary();

        SongSearcher songSearcher = new SongSearcher(localSongLibrary);
        SongLibrary localTaggedSongs = songSearcher.searchSongsByTags(searchId, tagList);

        return localTaggedSongs;
    }

}
