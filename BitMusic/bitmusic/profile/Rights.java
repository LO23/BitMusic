/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

/**
 *
 * @author Holywa
 */
public class Rights {
    private boolean canReadInfo;
    private boolean canPlay;
    private boolean canRate;
    private boolean canComment;

    Rights(){
        this.canReadInfo = true;
        this.canPlay = true;
        this.canRate = true;
        this.canComment = true;
    }

    public void updateRights( boolean canReadInfo, boolean canPlay, boolean canRate, boolean canComment){
        this.canReadInfo = canReadInfo;
        this.canPlay = canPlay;
        this.canRate = canRate;
        this.canComment = canComment;
    }


}
