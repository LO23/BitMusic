/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.profile.utilities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Holywa, MilioPeralta
 */
public class UserSaver {
    //########################## ATTRIBUTES ##########################//
    /**
     *
     */
    private final String defaultPath;
    private final String dirPath;

    /**
     *
     */

    //######################### CONSTRUCTORS ###########################//

    public UserSaver() {
        //TODO
        //Check where is the default path to got through user docs
        this.dirPath = ApiProfileImpl.getApiProfile().getCurrentUser().getLogin() + "_" + ApiProfileImpl.getApiProfile().getCurrentUser().getTransformedBirthday() + "\\";
        this.defaultPath = new File("").getAbsolutePath().toString() + "\\" + this.dirPath;

        System.out.println("Default path : " + this.defaultPath);
    }

    //########################### METHODS ##############################//

    /**
     *
     * @throws ProfileExceptions
     */
    public void saveUser() throws ProfileExceptions {
        try {
            FileOutputStream saveFile = new FileOutputStream(this.defaultPath + "user.ser");
            try (ObjectOutputStream oos = new ObjectOutputStream(saveFile)) {
                oos.writeObject(ApiProfileImpl.getApiProfile().getCurrentUser());
                oos.flush();
            }
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.CreationFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.WritingFileError);



        }
    }

    /**
     *
     * @throws ProfileExceptions
     */
    public void saveAuthFile() throws ProfileExceptions {
        try {
            FileOutputStream authFile = new FileOutputStream(this.defaultPath + "auth");



            try (ObjectOutputStream oos = new ObjectOutputStream(authFile)) {
                oos.writeUTF(ApiProfileImpl.getApiProfile().getCurrentUser().getLogin());
                oos.writeUTF(ApiProfileImpl.getApiProfile().getCurrentUser().getPassword());
                oos.flush();
            }
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.CreationFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.WritingFileError);
        }
    }

}
