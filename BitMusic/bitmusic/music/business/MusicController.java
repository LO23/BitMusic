/*
 * Singleton used by classes from the HMI, Network and Profile packages, 
 for accessing the unique ApiMusicImpl object = object containing methods implemented by Music for the outside world
 */
package bitmusic.music.business;

import bitmusic.music.api.ApiMusicImpl;

/**
 *
 * @author Amina Bouabdallah - Rym Barkaoui
 */
public class MusicController {

    /**
     * Reference to the unique ApiMusicImpl object (object containing method
     * accessed by HMI, Network, and Profile)
     */
    private ApiMusicImpl apiMusic;

    /**
     * Singleton instance
     */
    private static final MusicController MUSICCONTROLLER = new MusicController();

    /**
     * Private Constructor : creates a MusicController singleton and gets the 
     * reference to the unique instance of ApiMusicImpl
     */
    private MusicController() {
        apiMusic = bitmusic.music.api.ApiMusicImpl.getInstance();
    }
/**
 * 
 * @return the MusicController
 */
    public static MusicController getInstance() {
        return MUSICCONTROLLER;
    }

    /*########################################################################*/
    /* GETTERS */
    /*########################################################################*/
    
    /**
     * 
     * @return the reference to the apiMusic object
     */
    
    public final ApiMusicImpl getApiMusic() {
        return apiMusic;
    }

}
