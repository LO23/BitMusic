/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.business.strategies;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.network.exception.NetworkException;
import java.util.Iterator;
import java.util.List;

/**
 * Strategy to make a search relative to what we need.
 * @author Thomas
 */
public abstract class SongSearcherStrategy {
    
    /**
     * Allows to lunch a request to find songs.
     * @param localUserId The local user Id.
     * @param userIdDest The user aimed
     * @param searchId The searchId
     * @param matcherList The list of word to match.
     * @throws NetworkException 
     */
    public abstract void distantSearch(String localUserId, String userIdDest, String searchId, List<String> matcherList) throws NetworkException;
    
    /**
     * Allows to know if a song match with the matcher.
     * @param matcher The word matcher.
     * @param song The song to test.
     * @return True if the song is matched.
     */
    protected abstract boolean matched(String matcher, Song song);
    
    /**
     * Allows to know if a song match with the matcherList.
     * @param song The song to test.
     * @param matcherList The matcher list.
     * @return True if the wong is matched.
     */
    public  boolean isMatched(Song song, List<String> matcherList) {
        Iterator<String> it = matcherList.iterator();
        while(it.hasNext()){
            String matcher = it.next();
            if(matched(matcher, song)){
                return true;
            }
        }
        return false;
    }
    
}
