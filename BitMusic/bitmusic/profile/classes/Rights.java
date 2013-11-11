/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

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
     * @param canReadInfo boolean on reading right.
     * @param canPlay boolean on playing right.
     * @param canRate boolean in rating right.
     * @param canComment boolean on commenting right.
     */
    public void updateRights(final boolean canReadInfo, final boolean canPlay,
            final boolean canRate, final boolean canComment) {
        this.canReadInfo = canReadInfo;
        this.canPlay = canPlay;
        this.canRate = canRate;
        this.canComment = canComment;
    }
    /**
     * Get right to play.
     * @return boolean, if the user has the right or not to play.
     */
    public boolean getcanPlay(){
            return(this.canPlay);
    }

    /**
     * Get right if user can read info or not.
     * @return boolean, if the user has the right or not to read info.
     */
    public boolean getcanReadInfo() {
            return(this.canReadInfo);
    }

    /**
     * Get right if user can rate or not.
     * @returns boolean, if the user has the right or not to rate.
     */
    public boolean getcanRate() {
            return(this.canRate);
    }

    /**
     * Get right if user can comment or not.
     * @return boolean, if the user has the right or not to comment.
     */
    public boolean getcanComment() {
            return(this.canComment);
    }

    /**
     * Set right if users can play or not.
     * @param canPlayValue new value on playing right.
     */
    public void setcanPlay(final boolean canPlayValue) {
           this.canPlay=canPlayValue;
    }

    /**
     * Set right if users can read info or not.
     * @param canReadInfoValue new value on reading info right.
     */
    public void setcanReadInfo(final boolean canReadInfoValue) {

           this.canReadInfo=canReadInfoValue;
    }

    /**
     * Set right if users can rate or not.
     * @param canRateValue new value on rating right.
     */
    public void setcanRate(final boolean canRateValue) {

           this.canRate=canRateValue;
    }

    /**
     * Set right if users can comment or not.
     * @param canCommentValue new value on commenting right.
     */
    public void setcanComment(final boolean canCommentValue) {

           this.canComment=canCommentValue;
    }
}
