/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.api.ApiProfile;
import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Holywa, MilioPeralta
 */
public class UserParser {
    //########################## ATTRIBUTES ##########################//

    /**
     *
     */
    private String defaultPath;
    private String dirPath;

    //######################### CONSTRUCTORS ###########################//
    /**
     *
     */
	public UserParser() {


        this.dirPath = ApiProfileImpl.getApiProfile().getCurrentUser().getLogin() + "_" + ApiProfileImpl.getApiProfile().getCurrentUser().getTransformedBirthday() + "\\";
        this.defaultPath = new File("").getAbsolutePath().toString() + "\\" + this.dirPath;

        System.out.println("Loading file from default path : " + this.defaultPath.toString());
    }

    //########################### METHODS ##############################//

    /**
     *
     * @throws ProfileExceptions
     */
    public void loadUser() throws ProfileExceptions {
        try {
            FileInputStream saveFile = new FileInputStream(defaultPath.toString());
            try (ObjectInputStream ois = new ObjectInputStream(saveFile)) {
                User loadedUser = (User) ois.readObject();
                ApiProfileImpl.getApiProfile().setCurrentUser(loadedUser);
            }
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
    
    /**
     *
     * @return 
     * @throws ProfileExceptions
     */
    public User loadUserForTest() throws ProfileExceptions {
        try {
            FileInputStream saveFile = new FileInputStream(defaultPath.toString());
            User loadedUser;
            try (ObjectInputStream ois = new ObjectInputStream(saveFile)) {
                loadedUser = (User) ois.readObject();
            }
            return loadedUser;
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

    public void readAuthFile() throws ProfileExceptions {
        try {
            FileInputStream authFile = new FileInputStream(this.defaultPath + "auth");
            ObjectInputStream ois = new ObjectInputStream(authFile);
            ois.readUTF();
            ois.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.ExistingFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.ReadingFileError);
        }
    }

}
