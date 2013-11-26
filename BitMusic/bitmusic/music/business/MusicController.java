/**
 * Singleton used by classes from the HMI, Network and Profile packages. Used
 * for accessing the unique ApiMusicImpl object = object containing methods
 * implemented by Music for the outside world
 */
package bitmusic.music.business;

import bitmusic.music.api.ApiMusicImpl;

/**
 * Class controlling the music API.
 *
 * @author Music Team
 */
public class MusicController {

    /**
     * Reference to the unique ApiMusicImpl object. (object containing method
     * accessed by HMI, Network, and Profile)
     */
    private ApiMusicImpl apiMusic;

    /**
     * Singleton instance.
     */
    private static final MusicController MUSICCONTROLLER
            = new MusicController();

    /**
     * Private Constructor. Creates a MusicController singleton and gets the
     * reference to the unique instance of ApiMusicImpl
     */
    private MusicController() {
        apiMusic = bitmusic.music.api.ApiMusicImpl.getInstance();
    }

    /**
     * Gets the MusicController singleton.
     *
     * @return MUSICCONTROLLER MusicController object
     */
    public static MusicController getInstance() {
        return MUSICCONTROLLER;
    }

    /*########################################################################*/
    /*############################### GETTERS ################################*/
    /*########################################################################*/
    /**
     * Get the ApiMusic singleton.
     *
     * @return apiMusic apiMusic object
     */
    public final ApiMusicImpl getApiMusic() {
        return apiMusic;
    }

}
