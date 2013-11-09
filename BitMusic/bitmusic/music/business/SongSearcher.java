package bitmusic.music.business;

import java.util.*;
import java.lang.*;
import bitmusic.music.data.*;
import bitmusic.network.api.ApiMusic;
/**
 *
 * @author Amina Bouabdallah
 */
public class SongSearcher {
    
    HashMap<String, List<String>> tagIndex; // tag -> list de song id 
    HashMap<String, List<String>> userIndex; // userId -> list de song id
    SongLibrary songLibrary; // library of local user's songs
    /**
     * 
     * @param songLib 
     */
    public SongSearcher(SongLibrary songLib){
        songLibrary = songLib;
        tagIndex = new HashMap<String, List<String>>(); 
        userIndex = new HashMap<String, List<String>>();
    }
    /**
     * Local user wants to get the list of songs owned by userId. 
     * Requires a call to the method getSongsByUser of network.api.ApiMusic.
     * Response received directly in the UI
     * @param userID id of the user whose songs we are searching for
     * @param SearchID if of the current search
     */
    public void searchSongsbyUser(String userID, String SearchID){
        //besoin de l'implémentation de la méthode getSongsByUser(final User askedUser, final String researchId)
        //le premier argument doit être un "String userId"
        // ApiMusic apiMusic = new ApiMusicImpl();
        // apiMusic.getSongsByUser(userID, SearchID)
         
    }
    /**
     * Method invoked when local user is requested his/her songs. 
     * Fetches the local SongLibrary, and Local User's categories of contacts.
     * @param userId requester's user id
     * @return SongLibrary containing only the songs which requester can access
     */
    public SongLibrary getSongsByUser(String userId){
        ArrayList<Song> songsFromMyLibrary = songLibrary.getlibrary(); //songs avec des droits à 1 partout
        ArrayList<Song> songsForRequester = new ArrayList<Song>();
        SongLibrary songLibForRequester = null;
        
        Iterator<Song> it = songsFromMyLibrary.iterator();
        //give the songs in library with the correct rights for the User userId
        while(it.hasNext()){
            Song currentSong = it.next();
            songsForRequester.add(currentSong.getLightSong(userId)); //songs avec les droits ajustés pour userId
        }
        
        songLibForRequester = new SongLibrary(songsForRequester);
        
        return songLibForRequester;
    }
    
    /**
     * 
     * @param searchId
     * @param tagList
     * @return 
     */
    public SongLibrary searchSongByTags(String searchId, List<String> tagList){
        return null;
    }
    
    
    
    /**
     * 
     * @param songId
     * @param rights 
     */
    public void changeRightsOfThisSong(String songId, Rights rights){
        
    }
            
}
