/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.business.strategies;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.main.Controller;
import java.util.List;

/**
 * Strategy to search songs with tags.
 * @author Thomas
 */
public class TagSearchStrategy extends SongSearcherStrategy {

    @Override
    public void distantSearch(String localUserId, String userIdDest, String searchId, List<String> matcherList) throws NetworkException {
        Controller.getInstance().getApiMusic().searchSongsByTags(localUserId, userIdDest, searchId, matcherList);
    }

    @Override
    protected boolean matched(String matcher, Song song) {
        return song.getTags().contains(matcher);
    };
    
}
