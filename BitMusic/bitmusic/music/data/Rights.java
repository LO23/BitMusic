/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;
import java.io.Serializable;
/**
 *
 * @author Doha
 */
public class Rights implements Serializable{
    
    private boolean canPlay;
    private boolean canReadInfo;
    private boolean canRate;
    private boolean canComment;
    private static final long serialVersionUID = 302L;
    
      public Rights()
         {
    
            this.canPlay=true;
            this.canReadInfo=true;
            this.canRate=true;
            this.canComment=true;
        }
    
    public Rights(boolean canPlayValue, boolean canReadInfoValue, boolean canRateValue, boolean canCommentValue)
         {
    
            this.canPlay=canPlayValue;
            this.canReadInfo=canReadInfoValue;
            this.canRate=canRateValue;
            this.canComment=canCommentValue;
        
            System.out.println("New -- " + this.toString());
        }

        
        public boolean getcanPlay(){
            return(canPlay); 
        }
        
        public boolean getcanReadInfo(){
            return(canReadInfo); 
        }
        
        public boolean getcanRate(){
            return(canRate); 
        }
        
        public boolean getcanComment(){
            return(canComment); 
        }
        
        public void setcanPlay(boolean canPlayValue) {
        
           canPlay=canPlayValue;
        }
        
         public void setcanReadInfo(boolean canReadInfoValue) {
        
           canReadInfo=canReadInfoValue;
        }
        
          public void setcanRate(boolean canRateValue) {
        
           canRate=canRateValue;
        }
          
         public void setcanComment(boolean canCommentValue) {
        
           canComment=canCommentValue;
        }

    /**
     * toString function (variables : canPlay, canReadInfo, canRate and canComment).
     * @return string of variables
     */
    @Override public final String toString() {
        return "canPlay : " + canPlay + " ; canReadInfo : " + canReadInfo + " ; canRate : " + canRate + " ; canComment : " + canComment;
    }
          
    /**
     * toString function (variables : canPlay, canReadInfo, canRate and canComment).
     * @return string of variables
     */
    public Boolean equals(Rights r) {
        return this.canComment == r.canComment && this.canPlay == r.canPlay && this.canRate == r.canRate && this.canReadInfo == r.canReadInfo;
    }
}
