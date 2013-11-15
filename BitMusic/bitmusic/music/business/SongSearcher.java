package bitmusic.music.business;

import java.util.*;
import java.lang.*;
import bitmusic.music.data.*;
import bitmusic.network.main.ApiMusicImpl;
//porte d'entrée vers le module Network
import bitmusic.network.main.Controller; 

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
    public SongSearcher(SongLibrary songLib) {
        songLibrary = songLib;
        tagIndex = new HashMap<String, List<String>>();
        userIndex = new HashMap<String, List<String>>();
    }

    /**
     * Local user wants to get the list of songs owned by userId. Requires a
     * call to the method getSongsByUser of network.api.ApiMusic. Response
     * received directly in the UI
     *
     * @param userID id of the user whose songs we are searching for
     * @param SearchID if of the current search
     */
    public void searchSongsbyUser(String userID, String SearchID) {
        //besoin de l'implémentation de la méthode getSongsByUser(final User askedUser, final String researchId)
        //le premier argument doit être un "String userId"
        //ApiMusic apiMusic = new ApiMusicImpl(); //à ne pas faire, faire appel au singleton
        ApiMusicImpl apiMusic = Controller.getInstance().getApiMusic();
        apiMusic.getSongsByUser(userID, SearchID);
        return;
    }

    /**
     * Method invoked when local user is requested his/her songs. Fetches the
     * local SongLibrary, and Local User's categories of contacts.
     *
     * @param userId requester's user id
     * @return SongLibrary containing only the songs which requester can access
     */
    public SongLibrary getSongsByUser(String searchId, String userId) {
        ArrayList<Song> songsFromMyLibrary = songLibrary.getlibrary(); //songs avec des droits à 1 partout
        ArrayList<Song> songsForRequester = new ArrayList<Song>();
        SongLibrary songLibForRequester = null;
        Iterator<Song> it = songsFromMyLibrary.iterator();
        //give the songs from local library with the correct rights for the User userId
        while (it.hasNext()) {
            Song currentSong = it.next();
            songsForRequester.add(currentSong.getLightSong(userId)); //songs avec les droits ajustés pour userId
        }
        //build the SongLibrary to be returned
        songLibForRequester = new SongLibrary(songsForRequester);
        return songLibForRequester;
    }

    /**
     * Search all the songs with at least one of the tags from tagList. Look up
     * in local library and returns local songs with requested tags, and in all
     * the libraries from connected users via network
     *
     * @param searchId
     * @param tagList
     * @return
     */
    public SongLibrary searchSongByTags(String searchId, List<String> tagList) {
        SongLibrary myTaggedSongs = null;
        //besoin de l'implémentation de la méthode getSongsByUser(final User askedUser, final String researchId)
        //le premier argument doit être un "String userId"
        // ApiMusic apiMusic = new ApiMusicImpl();
        // List<String> connectedUsers =  apiMusic.getAllUserId()
        // for (userIdDest : connectedUsers) {
        //  apiMusic.searchSongsByTags(userIdDest, searchId, tagList)
        // }
        
        myTaggedSongs = this.getSongsByTag(searchId, tagList);
        return myTaggedSongs;
    }

    public SongLibrary getSongsByTag(String searchId, List<String> tagList) {
        ArrayList<Song> songsWithCorrectTags = new ArrayList<Song>();
        ArrayList<Song> songFromMyLibrary = songLibrary.getlibrary();
        SongLibrary songLibraryForRequester = null;
        Iterator<Song> it = songFromMyLibrary.iterator();

        //iterate over local songLibrary - fetches only the songs with at least one tag from tagList
        while (it.hasNext()) {
            Song currentSong = it.next();
            if (currentSong.hasTag(tagList)) {
                songsWithCorrectTags.add(currentSong);
            }
        }

        songLibraryForRequester = new SongLibrary(songsWithCorrectTags);
        return songLibraryForRequester;
    }

    /**
     *
     * @param songId
     * @param rights
     */
    public void changeRightsOfThisSong(String songId, Rights rights) {

    }

}
