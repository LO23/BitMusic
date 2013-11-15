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
import java.util.List;
import bitmusic.profile.api.ApiProfileImpl;

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
        //SongLibrary localSongLibrary = ApiProfileImpl.getApiProfile().
        //SongCommenter songCommenter = new SongCommenter(songLibrary);
        //besoin de récupérer la SongLibrary local - attente de Profile
        return true;
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
        // TO DO
        return false;
    }

    ;
   
   /**
    * search a song by User 
    * 
    * @param userID
    * @param searchId 
    */
   public void searchSongsByUser(String userID, String searchId) {

    }

    ;
   
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

    }

    ;
    
    /**
     * play a song from a distant user
     * 
     * @param path song path
     */
    public void playSong(String path) {
        // TO DO
    }

    ;
    
    public String getSongFile(String songid) {

        // TO DO
        return songid;
    }

    ;

    @Override
    public SongLibrary searchSongsByTags(List<String> tagList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * update a song rights
     *
     * @param songid
     * @param rights
     */
    @Override
    public void changeRightsOfThisSong(String songid, Rights rights) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
