package bitmusic.music.business;

import java.util.*;
import java.lang.*;
import bitmusic.music.data.*;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.main.ApiMusicImpl;
//porte d'entrée vers le module Network
import bitmusic.network.main.Controller;
import bitmusic.profile.api.ApiProfileImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class implementing the search feature of our application. The user can search
 * for songs from a specific user
 *
 * @author Music Team
 */
public class SongSearcher {

    /**
     * library of local user's songs.
     */
    private SongLibrary songLibrary;

    /**
     * library of local user's songs.
     *
     * @param songLib
     */
    public SongSearcher(SongLibrary songLib) {
        songLibrary = songLib;

    }

    /**
     * Method invoked when local user wants to get the list of songs owned by
     * userId. Requires a call to the method getSongsByUser of
     * network.api.ApiMusic. Response received directly in the UI
     *
     * @param userID id of the user whose songs we are searching for
     * @param SearchID if of the current search
     */
    public void searchSongsbyUser(String userID, String SearchID) {

        ApiMusicImpl apiMusic = Controller.getInstance().getApiMusic();
        ApiProfileImpl apiProfile = ApiProfileImpl.getApiProfile();
        String localUserId = apiProfile.getCurrentUser().getUserId();
        try {
            apiMusic.getSongsByUser(localUserId, userID, SearchID);
        } catch (NetworkException ex) {
            Logger.getLogger(SongSearcher.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    /**
     * Method invoked when local user is requested his/her songs. Fetches the
     * local SongLibrary, and Local User's categories of contacts.
     *
     * @param userId requester's user id
     * @param searchId search id of the search being done with this method call
     * @return SongLibrary containing only the songs which requester can access
     */
    public SongLibrary getSongsByUser(String searchId, String userId) {
        //songs avec des droits à 1 partout
        ArrayList<Song> songsFromMyLibrary = songLibrary.getlibrary();
        ArrayList<Song> songsForRequester = new ArrayList<Song>();
        SongLibrary songLibForRequester = null;
        Iterator<Song> it = songsFromMyLibrary.iterator();
        Song currentSong;

        //give the songs from local library with the correct rights 
        //for the User userId
        while (it.hasNext()) {
            currentSong = it.next();
            //song dont l'attribut right est changé : 
            //les droits ont été ajustés pour userId
            currentSong = getLightSong(currentSong, userId);
            songsForRequester.add(currentSong);
            //songs avec les droits ajustés pour userId
        }
        //build the SongLibrary to be returned
        songLibForRequester = new SongLibrary(songsForRequester);
        return songLibForRequester;
    }

    /**
     * Local user is searching for all songs in LAN with at least one of the
     * tags from tagList. Look up in local library and returns local songs with
     * requested tags, and in all the libraries from connected users via
     * network.
     *
     * @param searchId
     * @param tagList
     * @return
     */
    public SongLibrary searchSongsByTags(String searchId,
            List<String> tagList) {
        SongLibrary myTaggedSongs;
        ApiMusicImpl apiMusicFromNetwork;
        List<String> connectedUsers;
        Iterator<String> it;
        String userIdDest;

        //get list of connected users
        apiMusicFromNetwork = Controller.getInstance().getApiMusic();
        connectedUsers = apiMusicFromNetwork.getAllUserId();

        //for each user, go fetch their songs with the right tags
        it = connectedUsers.iterator();
        ApiProfileImpl apiProfile = ApiProfileImpl.getApiProfile();
        String localUserId = apiProfile.getCurrentUser().getUserId();
        while (it.hasNext()) {
            userIdDest = it.next();
            //result of call below go straight to the UI
            try {
                apiMusicFromNetwork.searchSongsByTags(localUserId, userIdDest,
                        searchId, tagList);
            } catch (NetworkException ex) {
                Logger.getLogger(SongSearcher.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        //method returns only our songs with the right tags
        myTaggedSongs = this.getSongsByTag(searchId, null, tagList);
        return myTaggedSongs;
    }

    /**
     * Method invoked when local user is requested to send their songs
     * fulfilling the tag criteria
     *
     * @param searchId id of the search being done with this call
     * @param tagList list of tags that remote user is requesting
     * @param userId user id of the requester ******* AMINA ADDED IT CAUSE IT
     * WAS MISSING ********* @return
     */
    public SongLibrary getSongsByTag(String searchId, String userId,
            List<String> tagList) {

        ArrayList<Song> songsWithCorrectTags = new ArrayList<Song>();
        ArrayList<Song> songsFromMyLibrary = songLibrary.getlibrary();
        SongLibrary songLibraryForRequester;
        Iterator<Song> it = songsFromMyLibrary.iterator();
        Song currentSong;

        //iterate over local songLibrary
        // -> fetches only the songs with at least one tag from tagList
        while (it.hasNext()) {
            currentSong = it.next();
            if (currentSong.hasTag(tagList)) {
                //changer les droits de la chanson pour le user en question 
                // -> if userId = null then local user is requester
                if (userId != null) {
                    currentSong = getLightSong(currentSong, userId);
                }
                songsWithCorrectTags.add(currentSong);
            }
        }
        //instantiate the SongLibrary to be sent
        songLibraryForRequester = new SongLibrary(songsWithCorrectTags);
        return songLibraryForRequester;
    }

    /**
     * Get a lightSong with the localSong attribute for the user with userId
     *
     * @param currentSong The song whose the lightsong will be created
     * @param authorId The authorId
     * @return A light song with attribute modified for the autorId.
     */
    public Song getLightSong(Song currentSong, String userId) {
        Song lightSong = new Song(currentSong.getSongId(),
                currentSong.getTitle(), currentSong.getArtist(),
                currentSong.getAlbum(), currentSong.getTags(),
                currentSong.getRightsByCategory());
        ArrayList<String> categoryList = 
              ApiProfileImpl.getApiProfile().getCategoriesNameByUserId(userId);
        Rights localRights = new Rights(true, true, true, true);

        for (String categoryName : categoryList) {
            Rights r = currentSong.getRightsByCategory().get(categoryName);
            if (!r.getcanComment()) {
                r.setcanComment(false);
            }
            if (!r.getcanPlay()) {
                r.setcanPlay(false);
            }
            if (!r.getcanRate()) {
                r.setcanRate(false);
            }
            if (!r.getcanReadInfo()) {
                r.setcanReadInfo(false);
            }
        }

        return lightSong;
    }

}
