/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.xml;

import bitmusic.profile.Profile;
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
    private Path defaultPath;

    public UserSaver() {
        //TODO
        //Check where is the default path to got through user docs
        this.defaultPath = FileSystems.getDefault().getPath("");
    }

    public void saveUser() throws ProfileExceptions {
        try {
            FileOutputStream saveFile = new FileOutputStream(defaultPath.toString());
            ObjectOutputStream oos = new ObjectOutputStream(saveFile);
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
    }

    public void saveAuthFile() throws ProfileExceptions {
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
    }

}
