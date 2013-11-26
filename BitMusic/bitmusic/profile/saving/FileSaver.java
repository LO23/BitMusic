/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.api.ApiProfileImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;

/**
 *
 * @author Holywa, MilioPeralta, Jérémy
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
        /*String defaultPath = new File("").getAbsolutePath().toString()
                + "\\BitMusic\\profiles\\" + userToSave.getFolderName();*/
        String defaultPath = new File("").getAbsolutePath().toString()
                + "\\BitTest\\profiles\\" + userToSave.getFolderName();


        if(!Files.exists(FileSystems.getDefault().getPath(defaultPath))) {
            throw new ProfileExceptions(ProfileExceptionType.DirNotFound);
        }

        try {
            FileOutputStream saveFile = new FileOutputStream(defaultPath
                    + "\\profile\\" + userToSave.getLogin() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(saveFile);
            oos.writeObject(userToSave);
            oos.flush();
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
            /*String defaultPath = new File("").getAbsolutePath().toString()
                    + "\\BitMusic\\profiles"
                    + ApiProfileImpl.getApiProfile().getCurrentUserFolder();*/
            String defaultPath = new File("").getAbsolutePath().toString()
                    + "\\BitTest\\profiles\\"
                    + ApiProfileImpl.getApiProfile().getCurrentUserFolder();

            FileOutputStream authFile = new FileOutputStream(defaultPath
                    + "\\profile\\auth");

            ObjectOutputStream oos = new ObjectOutputStream(authFile);
            oos.writeUTF(toSave.getLogin());
            oos.writeUTF(toSave.getEncryptedPassword());
            oos.flush();
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions(eFound.toString());
        }
        catch(IOException eIO) {
            throw new ProfileExceptions(eIO.toString());
        }
    }

}
