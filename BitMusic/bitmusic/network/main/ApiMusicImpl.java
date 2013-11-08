/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

/**
 *
 * @author florian
 */
public class ApiMusicImpl {
    /**
    * Singleton implementation.
    */
    private static final ApiMusicImpl APIMUSICIMPL = new ApiMusicImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiMusicImpl() { }

    /**
     * .
     * @return Unique instance of ApiMusicImpl
     */
    protected static ApiMusicImpl getInstance() {
        return APIMUSICIMPL;
    }
}
