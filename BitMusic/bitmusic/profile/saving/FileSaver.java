/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 *
 * @author Holywa, MilioPeralta
 */
public class FileSaver {
    //########################## ATTRIBUTES ##########################//
    /**
     *
     */
    private static FileSaver currentSaver;

    //######################### CONSTRUCTORS ###########################//

    public static FileSaver getFileSaver(){
        if (currentSaver == null) {
            currentSaver = new FileSaver();
        }
        return currentSaver;
    }

    //########################### METHODS ##############################//

    /**
     *
     * @param userToSave
     * @throws ProfileExceptions
     */
    public void saveUser(User userToSave) throws ProfileExceptions {
        //String defaultPath = new File("").getAbsolutePath().toString() + "\\" + ApiProfileImpl.getApiProfile().getCurrentUserFolder();
        String defaultPath = new File("").getAbsolutePath().toString() + "\\" + userToSave.getLogin() + "_" + userToSave.getTransformedBirthday();

        if(!Files.exists(FileSystems.getDefault().getPath(defaultPath))) {
            try {
            Files.createDirectory(FileSystems.getDefault().getPath(defaultPath));
            }
            catch(IOException io) {
                throw new ProfileExceptions("Cannot create directory");
            }
        }

        try {
            FileOutputStream saveFile = new FileOutputStream(defaultPath + "user.ser");
            try (ObjectOutputStream oos = new ObjectOutputStream(saveFile)) {
                oos.writeObject(userToSave);
                oos.flush();
            }
        }
        catch(FileNotFoundException eFound) {
            System.out.println(eFound.toString());
            throw new ProfileExceptions(ProfileExceptionType.CreationFileError);
        }
        catch(IOException eIO) {
            System.out.println(eIO.toString());
            throw new ProfileExceptions(ProfileExceptionType.WritingFileError);
        }
    }

    /**
     *
     * @param toSave
     * @throws ProfileExceptions
     */
    public void saveAuthFile(User toSave) throws ProfileExceptions {
        try {
            //String defaultPath = new File("").getAbsolutePath().toString() + "\\" + ApiProfileImpl.getApiProfile().getCurrentUserFolder();
            String defaultPath = new File("").getAbsolutePath().toString() + "\\" + toSave.getLogin() + "_" + toSave.getTransformedBirthday();
            FileOutputStream authFile = new FileOutputStream(defaultPath + "auth");

            try (ObjectOutputStream oos = new ObjectOutputStream(authFile)) {
                oos.writeUTF(toSave.getLogin());
                oos.writeUTF(toSave.getPassword());
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
