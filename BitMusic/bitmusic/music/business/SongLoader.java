/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.music.business;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.User;
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

/**
 *
 * @author Jean-Baptiste
 */
public class SongLoader {

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
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
        Date date = new Date();
        /* TODO : Finaliser avec API profile
         String userId = new String(getCurrentUser().getUserId()); //TODO : waiting for Profile API
         String songId = new String(userId + dateFormat.format(date));                        

         //Creating song
         Song newsong = new Song(songId, title, album, artist, tags, rightsByCategory);
         profileAPI.getSongLibrary().addSong(newsong);
         */

        // Sauvegarde dans le systeme de fichier (à vérifier)
        if (!path.endsWith(".mp3")){
            //import impossible
            throw new WrongFormatMP3Exception("This file is not a mp3");            
        }
        Path source = Paths.get(path);
        Path destination = Paths.get("Library/" + artist + "/" + album + "/" + title + ".mp3");
        Files.copy(source, destination);

    }
}
