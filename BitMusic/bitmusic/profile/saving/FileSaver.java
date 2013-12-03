/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import bitmusic.profile.api.ApiProfileImpl;
import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;

/**
 *
 * @author Holywa, MilioPeralta, JÃ©rÃ©my
 */
public class FileSaver {
    //########################## ATTRIBUTES ##########################//
    /**
     *
     */
    private static FileSaver currentSaver;
    private static String separator = FileSystems.getDefault().getSeparator();
    private static String mainStructure = separator + "BitTest" + separator + "profiles" + separator;
    private static String profileStructure = separator + "profile" + separator;

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
        String defaultPath = new File("").getAbsolutePath().toString()
        		+ mainStructure
        		+ ApiProfileImpl.getApiProfile().getCurrentUserFolder();

        if(!Files.exists(FileSystems.getDefault().getPath(defaultPath))) {
            throw new ProfileExceptions(ProfileExceptionType.DirNotFound);
        }

        try {
            FileOutputStream saveFile = new FileOutputStream(defaultPath
            		+ profileStructure + userToSave.getLogin() + ".ser");

            ObjectOutputStream oos = new ObjectOutputStream(saveFile);
            oos.writeObject(userToSave);
            oos.flush();
            oos.close();
            saveFile.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(eFound.toString());
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(eIO.toString());
        }
    }

    /**
     *
     * @param toSave
     * @throws ProfileExceptions
     */
    public void saveAuthFile(User toSave) throws ProfileExceptions {
        try {
            String defaultPath = new File("").getAbsolutePath().toString()
                    + mainStructure
                    + ApiProfileImpl.getApiProfile().getCurrentUserFolder();
            FileOutputStream authFile = new FileOutputStream(defaultPath
                    + profileStructure + "auth");

            ObjectOutputStream oos = new ObjectOutputStream(authFile);
            oos.writeUTF(toSave.getEncryptedPassword());
            oos.flush();
            oos.close();
            authFile.close();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(eFound.toString());
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(eIO.toString());
        }
    }

}
