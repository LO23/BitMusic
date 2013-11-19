/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.utilities;

/**
 *
 * @author reaneyol, MilioPeralta
 */
public class ProfileExceptions extends Throwable {
    private String errorMessage;
    private ProfileExceptionType type;

    public ProfileExceptions(ProfileExceptionType type) {
        this.type = type;
        switch(type) {
            case LoginNull : {
                this.errorMessage = "No login defined";
                break;
            }
            case PasswordNull : {
                this.errorMessage = "No password defined";
                break;
            }
            case ConnectionWrongLogin : {
                this.errorMessage = "Can\'t connect : wrong login entered";
                break;
            }
            case ConnectionWrongPassword : {
                this.errorMessage = "Can\'t connect : wrong password entered";
                break;
            }
            case FileNotFound : {
                this.errorMessage = "Can\'t open file";
                break;
            }
            case DirNotFound: {
                this.errorMessage = "Dir not found";
                break;
            }
            default : {
                this.errorMessage = "Exception from Profile";
                break;
                }
            }
    }

    public ProfileExceptions(String err) {
        this.errorMessage = err;
    }

    public ProfileExceptionType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}