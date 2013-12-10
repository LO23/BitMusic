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
import bitmusic.profile.classes.Category;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Class used for managing Music Directories and songs import (mp3 files).
 *
 * @author Music Team
 */
public class SongLoader {

    /**
     * Copy a song. Target Directory :
     * Profiles\UserDirectory\Music\Library\Artist\Album\Title.mp3
     *
     * @param path path of mp3 to copy
     * @param title title of the song
     * @param artist artist of the song
     * @param album album of the song
     */
    private void copyImportedMP3(String path, String title, String artist, 
            String album) throws CopyMP3Exception, IOException {

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
        String separator = FileSystems.getDefault().getSeparator();
        String currentUserFolder
                = new String(ApiProfile.getCurrentUserFolder());
        String fileDirectory = new String("BitTest" + separator
                + "profiles" + separator + currentUserFolder + separator 
                + "music" + separator +"library" + separator + artist 
                + separator + album);
        Path destination = Paths.get(fileDirectory);
        Files.createDirectories(destination);

        //Copying file (delete destination file if it already exists)
        Path destinationMP3 = Paths.get(destination + separator + title 
                + ".mp3");
        if (Files.exists(destinationMP3)) {
            Files.delete(destinationMP3);
        }
        Files.copy(source, destinationMP3, StandardCopyOption.REPLACE_EXISTING);
    }
    
    private void copyMP3(String source, String destination)
            throws CopyMP3Exception, IOException {

        // If path is not a MP3 -> Exception
        if (!source.endsWith(".mp3")) {
            throw new CopyMP3Exception("This file is not a mp3");
        }

        // If file to copy does not exist -> Exception        
        Path sourceMP3 = Paths.get(source);
        if (Files.notExists(sourceMP3)) {
            throw new CopyMP3Exception("File does not exist!");
        }

        //Copying file (delete destination file if it already exists)
        Path destinationMP3 = Paths.get(destination);
        if (Files.exists(destinationMP3)) {
            Files.delete(destinationMP3);
        }
        Files.copy(sourceMP3, destinationMP3, 
                StandardCopyOption.REPLACE_EXISTING);
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
    public void importSong(String path, String title, String artist,
            String album, LinkedList<String> tags)
            throws CopyMP3Exception, IOException {

        //Getting current Date        
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();

        //Generating songId
        ApiProfileImpl ApiProfil = ApiProfileImpl.getApiProfile();
        String userId = new String(ApiProfil.getCurrentUser().getUserId());
        String songId = new String(userId + dateFormat.format(date));

        //Creating song
        Song newSong = new Song(songId, title, artist, album, userId, tags);
        ArrayList<Category> allCategories = ApiProfil.getCategories();

        //All rightsByCategories are set to True by default
        for (Category category : allCategories) {
            Rights newRight = new Rights(true, true, true, true);
            newSong.getRightsByCategory().put(category.getId(), newRight);
        }
        ApiProfil.getSongLibrary().addSong(newSong);

        this.copyImportedMP3(path, title, artist, album);
    }

    /**
     * Get the path of the song identified by songId.
     *
     * @param songId songId of the song
     * @return path path of the song
     */
    public String getSongPath(String songId) {
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        Song localSong = ApiProfile.getSongLibrary().getSong(songId);
        String currentUserFolder
                = new String(ApiProfile.getCurrentUserFolder());
        String artist = new String(localSong.getArtist());
        String album = new String(localSong.getAlbum());
        String title = new String(localSong.getTitle());
        String separator = FileSystems.getDefault().getSeparator();
        String path = new String("BitTest" + separator + "profiles"
                + separator + currentUserFolder + separator + "music" 
                + separator + "library" + separator + artist + separator 
                + album + separator + title + ".mp3");

        return path;
    }

    /**
     * Get the path of the song identified by songId.
     *
     * @param songId songId of the song
     * @return path path of the song
     */
    public String generateTempSongPath(String userId, String songId) {
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        String currentUserFolder
                = new String(ApiProfile.getCurrentUserFolder());
        String separator = FileSystems.getDefault().getSeparator();
        String path = new String("BitTest" + separator + "profiles"
                + separator + currentUserFolder + separator + "music" 
                + separator + "temp" + separator + userId + "_" + songId 
                + ".mp3");

        return path;
    }

    /**
     * Create (if not exists) for the current user the Music directory with its
     * subfolders.
     *
     * @throws IOException
     */
    public void createMusicFolders() throws IOException {
        //Get Current User directory
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        String currentUserFolder
                = new String(ApiProfile.getCurrentUserFolder());

        //Creating /Music/Library folder
        String separator = FileSystems.getDefault().getSeparator();
        String fileDirectory = new String("BitTest" + separator 
                + "profiles" + separator + currentUserFolder + separator 
                + "music" + separator + "library" + separator);
        Path destination = Paths.get(fileDirectory);
        Files.createDirectories(destination);

        //Creating /Music/Library folder
        fileDirectory = "BitTest" + separator + "profiles" 
                + separator + currentUserFolder + separator + "music" 
                + separator + "temp" + separator;
        destination = Paths.get(fileDirectory);
        Files.createDirectories(destination);
    }
    public void deleteSong(String songId) throws CopyMP3Exception, IOException, 
            DirectoryNotEmptyException{
        
        //Removing song's file
        ApiProfileImpl ApiProfile = ApiProfileImpl.getApiProfile();
        String artist = ApiProfile.getSongLibrary().getSong(songId).getArtist();
        String album = ApiProfile.getSongLibrary().getSong(songId).getAlbum();
        
        //Removing song from SongLibrary       
        String filePath = this.getSongPath(songId);
        Path destination = Paths.get(filePath);
        Files.deleteIfExists(destination);
        
        //Deleting album folder if empty
        String separator = FileSystems.getDefault().getSeparator();
        String currentUserFolder
                = new String(ApiProfile.getCurrentUserFolder());
        filePath = "BitTest" + separator + "profiles" + separator 
                + currentUserFolder + separator + "music" + separator +"library"
                + separator + artist + separator + album;
        destination = Paths.get(filePath);
        Files.deleteIfExists(destination);
        
        //Deleting artist folder if empty
        filePath = "BitTest" + separator + "profiles" + separator 
                + currentUserFolder + separator + "music" + separator +"library"
                + separator + artist;
        destination = Paths.get(filePath);
        Files.deleteIfExists(destination);
    }
    
    public boolean tempFileExists(String userId, String songId){
        String tempPath = this.generateTempSongPath(userId, songId);
        Path destination = Paths.get(tempPath);
        return Files.exists(destination);
    }
    
    public boolean saveTempSong(String userId, String songId, 
            String destinationPath) throws CopyMP3Exception, IOException{
        if (tempFileExists(userId, songId)){
            copyMP3(this.generateTempSongPath(userId, songId), destinationPath);
            return true;
        }
        else{
            return false;
        }     
    }
}


