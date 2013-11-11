/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.xml;

import bitmusic.profile.Profile;
import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 * @author Holywa
 */
public class UserParser {
    //########################## ATTRIBUTES ##########################//

    /**
     *
     */
    private Path defaultPath;

    //######################### CONSTRUCTORS ###########################//
    /**
     *
     */
    public UserParser() {
        this.defaultPath = FileSystems.getDefault().getPath("");
    }

    //########################### METHODS ##############################//

    /**
     * 
     * @throws ProfileExceptions
     */
    public void loadUser() throws ProfileExceptions {
        try {
            FileInputStream saveFile = new FileInputStream(defaultPath.toString());
            ObjectInputStream ois = new ObjectInputStream(saveFile);
            User loadedUser = (User) ois.readObject();
            Profile.setCurrentUser(loadedUser);
            ois.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.ExistingFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.ReadingFileError);
        }
        catch(ClassNotFoundException eClass) {
            throw new ProfileExceptions(ProfileExceptionType.FindingClassUserError);
        }
    }

    /*public void saveAuthFile() throws ProfileExceptions {
        try {
            FileOutputStream authFile = new FileOutputStream(defaultPath.toString());
            ObjectOutputStream oos = new ObjectOutputStream(authFile);
            oos.writeObject(Profile.getCurrentUser());
            oos.flush();
            oos.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.CreationFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.WritingFileError);
        }
    }*/

}
