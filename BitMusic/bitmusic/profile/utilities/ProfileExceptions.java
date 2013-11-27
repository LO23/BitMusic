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
            case LoginNullOrEmpty : {
                this.errorMessage = "No login defined";
                break;
            }
            case PasswordNullOrEmpty : {
                this.errorMessage = "No password defined";
                break;
            }
            case BirthDateNull : {
                this.errorMessage = "No birthdate given";
                break;
            }
            case PathNullorEmpty : {
                this.errorMessage = "No path given";
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
            case CategoryEmptyName : {
                this.errorMessage = "Category's name empty";
                break;
            }
            case LoginEmptyName : {
                this.errorMessage = "Login is empty";
                break;
            }
            case UserIdEmptyName : {
                this.errorMessage = "UserId is empty";
                break;
            }
            case PasswordEmptyName : {
                this.errorMessage = "Password is empty";
                break;
            }
            case ConnectionWrongLogin : {
                this.errorMessage = "Can\'t connect : wrong login entered";
                break;
            }
            case BirthdateEmptyName : {
                this.errorMessage = "Birthday is empty";
                break;
            }
            case FirstNameNullOrEmpty : {
                this.errorMessage = "Firstname is empty";
                break;
            }
            case LastNameNullOrEmpty : {
                this.errorMessage = "Lastname is empty";
                break;
            }
            case AvatarPathEmpty : {
                this.errorMessage = "AvatarPath is empty";
                break;
            }
            case SongEmptyName : {
                this.errorMessage = "SongId is empty";
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