/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

/**
 *
 * @author reaneyol
 */
public class ProfileExceptions extends Throwable {
    private String errorMessage;

    public ProfileExceptions(int type) {
        switch(type) {
            case 0: {
                    this.errorMessage = "None login defined";
                    break;
            }
            case 1: {
                    this.errorMessage = "None password defined";
                    break;
            }
            default : {
                    this.errorMessage = "Exception from Profile";
                    break;
                }
            }
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
