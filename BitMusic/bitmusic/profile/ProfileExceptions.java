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

    ProfileExceptions(int type) {
        switch(type) {
            default : {
                    this.errorMessage = new String("Exception from Profile");
                    break;
                }
            }
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
