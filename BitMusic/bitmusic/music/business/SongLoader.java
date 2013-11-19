/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.business;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.music.data.Rights;
import bitmusic.music.exception.CopyMP3Exception;
import bitmusic.profile.api.ApiProfileImpl;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Jean-Baptiste
 */
public class SongLoader {

    /**
     * Copy a song to
     * Profiles\UserDirectory\Music\Library\Artist\Album\Title.mp3 .
     *
     * @param path path of mp3 to copy
     * @param title title of the song
     * @param artist artist of the song
     * @param album album of the song
     */
    private void copyMP3(String path, String title, String artist, String album) throws CopyMP3Exception, IOException {
        // If path is not a MP3 -> Exception
        if (!path.endsWith(".mp3")) {
            throw new CopyMP3Exception("This file is not a mp3");
        }

        // If file to copy does not exist -> Exception        
        Path source = Paths.get(path);
        if (Files.notExists(source)) {
            throw new CopyMP3Exception("File does not exist!");
        }

        //Creating target directory
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        String currentUserFolder = new String(ApiProfile.getCurrentUserFolder());
        String fileDirectory = new String("Profiles/" + currentUserFolder + "/Music/Library/" + artist + "/" + album); //à tester
        Path destination = Paths.get(fileDirectory);
        Files.createDirectories(destination);

        //Copying file (delete destination file if it already exists)
        Path destinationMP3 = Paths.get(destination + "/" + title + ".mp3");
        if (Files.exists(destinationMP3)) {
            Files.delete(destinationMP3);
        }
        Files.copy(source, destinationMP3, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Import a song into SongLibrary. First creates a new Song and then puts it
     * into the SongLibrary
     *
     * @param path file path of the song
     * @param title title of the song
     * @param artist artist of the song
     * @param album album of the song
     * @param tags tags of the song
     * @param rightsByCategory access rights of the song
     */
    public void importSong(String path, String title, String artist, String album, LinkedList<String> tags, HashMap<String, Rights> rightsByCategory) throws CopyMP3Exception, IOException {

        //Getting current Date        
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();

        //Generating songId
        ApiProfileImpl ApiProfil = ApiProfileImpl.getApiProfile();
        ApiProfil.getCurrentUser().getUserId();
        String userId = new String(ApiProfil.getCurrentUser().getUserId());
        String songId = new String(userId + dateFormat.format(date));

        //Creating song
        Song newsong = new Song(songId, title, album, artist, tags, rightsByCategory);
        ApiProfil.getSongLibrary().addSong(newsong); //à tester

        this.copyMP3(path, title, artist, album);
    }

    /**
     * Get the path of the song identified by songId.
     * 
     * @param songId    songId of the song
     * @return path     path of the song
     */
    public String getSongPath(String songId) {
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        Song localSong = ApiProfile.getSongLibrary().getSong(songId);
        String currentUserFolder = new String(ApiProfile.getCurrentUserFolder());
        String artist = new String(localSong.getArtist());
        String album = new String(localSong.getAlbum());
        String title = new String(localSong.getTitle());
        String path = new String("Profiles/" + currentUserFolder + "/Music/Library/" + artist + "/" + album + "/" + title + ".mp3");
        return path;
    }
    
    /**
     * Get the path of the song identified by songId.
     * 
     * @param songId    songId of the song
     * @return path     path of the song
     */
    public String getTempSongPath(String userId, String songId) {
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        Song localSong = ApiProfile.getSongLibrary().getSong(songId);
        String currentUserFolder = new String(ApiProfile.getCurrentUserFolder());
        String path = new String("Profiles/" + currentUserFolder + "/Music/Temp/" + userId + "_" + songId + ".mp3");
        return path;
    }
}
