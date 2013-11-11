/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

/**
 *
 * @author Holywa, saben2
 */
public class Rights {
    //########################## ATTRIBUTES ##########################//

    /**
     * References if other users can read his own music's Info.
     */
    private boolean canReadInfo;

    /**
     * References if other users can play his own musics.
     */
    private boolean canPlay;

    /**
     * References if other users can rate his own musics.
     */
    private boolean canRate;

    /**
     * References if other users can comment his own musics.
     */
    private boolean canComment;

//######################### CONSTRUCTORS ###########################//
    Rights(){
        this.canReadInfo = true;
        this.canPlay = true;
        this.canRate = true;
        this.canComment = true;
    }
    
//########################### METHODS ##############################//
    /**
     * Update rights.
     * @param canReadInfo.
     * @param canPlay.
     * @param canRate.
     * @param canComment.
     */
    public void updateRights( boolean canReadInfo, boolean canPlay, boolean canRate, boolean canComment){
        this.canReadInfo = canReadInfo;
        this.canPlay = canPlay;
        this.canRate = canRate;
        this.canComment = canComment;
    }
    /**
     * Get right to play.
     * @returns boolean, if the user has the right or not to play.
     */
    public boolean getcanPlay(){
            return(canPlay);
    }

    /**
     * Get right if user can read info or not.
     * @returns boolean, if the user has the right or not to read info.
     */
    public boolean getcanReadInfo(){
            return(canReadInfo);
    }

    /**
     * Get right if user can rate or not.
     * @returns boolean, if the user has the right or not to rate.
     */
    public boolean getcanRate(){
            return(canRate);
    }

    /**
     * Get right if user can comment or not.
     * @returns boolean, if the user has the right or not to comment.
     */
    public boolean getcanComment(){
            return(canComment);
    }

    /**
     * Set right if users can play or not.
     * @param canPlayValue
     */
    public void setcanPlay(boolean canPlayValue) {
           canPlay=canPlayValue;
    }

    /**
     * Set right if users can read info or not.
     * @param canReadInfoValue
     */
    public void setcanReadInfo(boolean canReadInfoValue) {

           canReadInfo=canReadInfoValue;
    }

    /**
     * Set right if users can rate or not.
     * @param canRateValue
     */
    public void setcanRate(boolean canRateValue) {

           canRate=canRateValue;
    }

    /**
     * Set right if users can comment or not.
     * @param canCommentValue
     */
    public void setcanComment(boolean canCommentValue) {

           canComment=canCommentValue;
    }


}
