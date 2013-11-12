/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 * @author Holywa
 */
public class UserSaver {
    //########################## ATTRIBUTES ##########################//
    /**
     *
     */
    private Path defaultPath;

    /**
     *
     */

    //######################### CONSTRUCTORS ###########################//

    public UserSaver() {
        //TODO
        //Check where is the default path to got through user docs
        this.defaultPath = FileSystems.getDefault().getPath(null);
        System.out.println("Default path : " + this.defaultPath.toString());
    }

    //########################### METHODS ##############################//

    /**
     *
     * @throws ProfileExceptions
     */
    public void saveUser() throws ProfileExceptions {
        try {
            FileOutputStream saveFile = new FileOutputStream(defaultPath.toString());
            ObjectOutputStream oos = new ObjectOutputStream(saveFile);
            //oos.writeObject(Profile.getCurrentUser());
            oos.flush();
            oos.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.CreationFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.WritingFileError);
        }
    }

    //To test
    public void saveUser(User userToSave) throws ProfileExceptions {
        try {
            FileOutputStream saveFile = new FileOutputStream(defaultPath.toString());
            ObjectOutputStream oos = new ObjectOutputStream(saveFile);
            oos.writeObject(userToSave);
            oos.flush();
            oos.close();
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
            FileOutputStream authFile = new FileOutputStream(defaultPath.toString());
            ObjectOutputStream oos = new ObjectOutputStream(authFile);
            //oos.writeObject(Profile.getCurrentUser());
            oos.flush();
            oos.close();
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
    public void saveAuthFile(User userAuth) throws ProfileExceptions {
        try {
            FileOutputStream authFile = new FileOutputStream(defaultPath.toString());

            ObjectOutputStream oos = new ObjectOutputStream(authFile);
            oos.writeObject(userAuth);
            oos.flush();
            oos.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(ProfileExceptionType.CreationFileError);
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(ProfileExceptionType.WritingFileError);
        }
    }

}
