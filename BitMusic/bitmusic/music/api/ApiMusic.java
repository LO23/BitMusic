/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.api;
import bitmusic.music.data.Rights;
import bitmusic.music.data.Comment;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */

public interface ApiMusic {
    
    public boolean addCommentFromHmi(String songID, String commentText);
    public boolean addCommentFromNetwork(String songID, Comment commentText);
    public void searchSongsByUser(String userID, String searchId);   
    public void importSong(String path, String title, String album, ArrayList<String> tags, Rights rights);
    public void changeRigthsOfThisSong (String songid, Rights rights);
    public void playSong (String path);
    public String getSongFile (String songid);
    
}
