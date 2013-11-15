/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.api;

import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.User;

/**
 *
 * @author hebergui <hebergui.utc@gmail.com>
 */
public interface ApiHmi {
    public abstract void notifyLightProfile(User user, String searchId);
    public abstract void notifyNewConnection(User lightUserLan);
    public abstract void notifySongListByUserId(String userID, SongLibrary songLibrary);
    public abstract void notifySongListBySearchId(String searchId, SongLibrary songList);
    public abstract void removeUserFromOnlineUsers(String userId);
    public abstract void notifyNewTag(String tag);
}
