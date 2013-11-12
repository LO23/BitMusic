/*
 * Class which instantiates all the 
 */

package bitmusic.music.business;
import bitmusic.music.api.ApiMusicImpl;
/**
 *
 * @author Amina Bouabdallah - Rym Barkaoui
 */
public class MusicController {
    private ApiMusicImpl apiMusic; //fichier contenant les fonctions utilisées par l'extérieur
    private static final MusicController MUSICCONTROLLER = new MusicController();
    
    
    private MusicController(){
        apiMusic = bitmusic.music.api.ApiMusicImpl.getInstance();
    }
    
    public static MusicController getInstance(){
        return MUSICCONTROLLER;
    }
    
    /*########################################################################*/
    /* GETTERS */
    /*########################################################################*/
    public final ApiMusicImpl getApiMusic(){
        return apiMusic;
    }
    
    
    
}
