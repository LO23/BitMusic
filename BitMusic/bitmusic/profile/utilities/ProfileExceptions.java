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
            case BirthDateNull : {
                this.errorMessage = "No birthdate given";
                break;
            }
            case LoginWithInvalidCharacters : {
                this.errorMessage = "Login with invalid characters";
                break;
            }
            case CategoryNotFound : {
                this.errorMessage = "Category not found";
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
            case FileNotAuthorized : {
                this.errorMessage = "File not authorized";
                break;
            }
            case CreationFileError : {
                this.errorMessage = "Can\'t create file";
                break;
            }
            case WritingFileError : {
                this.errorMessage = "Can\'t write in file";
                break;
            }
            case ExistingFileError : {
                this.errorMessage = "File already exists";
                break;
            }
            case ReadingFileError : {
                this.errorMessage = "Can\'t read file";
                break;
            }
            case FindingClassUserError : {
                this.errorMessage = "Finding class user error";
                break;
            }
            case DirNotFound: {
                this.errorMessage = "Dir not found";
                break;
            }
            case UserNull: {
                this.errorMessage = "User null";
                break;
            }
            case EmptyString: {
                this.errorMessage = "Empty string received";
                break;
            }
            case SongNull: {
                this.errorMessage = "Song null";
                break;
            }
            case RightNull: {
                this.errorMessage = "Right null";
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