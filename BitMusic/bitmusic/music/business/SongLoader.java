/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.business;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.User;       //TODO: à modifier quand ProfileAPI créée
import bitmusic.music.data.Rights;
import bitmusic.music.exception.WrongFormatMP3Exception;
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
     * Copy a song to Profiles\UserDirectory\Music\Library\Artist\Album\Title.mp3 .
     * 
     * @param path      path of mp3 to copy
     * @param title     title of the song
     * @param artist    artist of the song
     * @param album     album of the song
     */
    private void copyMP3(String path, String title, String artist, String album) throws WrongFormatMP3Exception, IOException{
        // If path is not a MP3 -> Exception
        if (!path.endsWith(".mp3")) {
            throw new WrongFormatMP3Exception("This file is not a mp3");            
        }
        
        // If file to copy does not exist -> Exception        
        Path source = Paths.get(path);
        if (Files.notExists(source)){
            throw new WrongFormatMP3Exception("File does not exist!");
        }
        
        //Creating target directory
        String fileDirectory = new String("Profiles/" + "GetUserDirectory/"+ "Music/Library/" + artist + "/" + album);
        Path destination = Paths.get(fileDirectory);
        Files.createDirectories(destination);

        //Copying file (delete destination file if it already exists)
        Path destinationMP3 = Paths.get(destination + "/" + title + ".mp3");
        if (Files.exists(destinationMP3)){
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
    public void importSong(String path, String title, String artist, String album, LinkedList<String> tags, HashMap<String, Rights> rightsByCategory) throws WrongFormatMP3Exception, IOException{

        // Ajout dans songLibrary
        //Generating songId
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();
        /* TODO : Finaliser avec API profile
         String userId = new String(getCurrentUser().getUserId()); //TODO : waiting for Profile API
         String songId = new String(userId + dateFormat.format(date));                        

         //Creating song
         Song newsong = new Song(songId, title, album, artist, tags, rightsByCategory);
         profileAPI.getSongLibrary().addSong(newsong);
        */
        this.copyMP3(path, title, artist, album);               
    }
}