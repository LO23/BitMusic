/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holywa, MilioPeralta
 */
public class FileParser {
    //########################## ATTRIBUTES ##########################//

    /**
     *
     */
    private static FileParser currentParser;

    //######################### CONSTRUCTORS ###########################//
    /**
     *
     * @return
     */
    public static FileParser getFileParser(){
        if (currentParser == null) {
            currentParser = new FileParser();
        }
        return currentParser;
    }

    //########################### METHODS ##############################//

    /**
     *
     * @param login
     * @param pwd
     * @return
     * @throws ProfileExceptions
     */
    public User loadUser(String login, String pwd) throws ProfileExceptions {
        try {
            String defaultPath = new File("").getAbsolutePath().toString() + "\\BitMusic\\profiles\\";

            DirectoryStream<Path> stream = Files.newDirectoryStream(FileSystems.getDefault().getPath(defaultPath));
            for(Path path:stream) {
                if(path.getFileName().toString().contains(login) && (new File(path.toString())).isDirectory()) {
                    if(FileParser.getFileParser().readAuthFile(path.toString(), pwd)) {
                        FileInputStream saveFile = new FileInputStream(path.toString() + "\\profile\\" + login + ".ser");
                        try (ObjectInputStream ois = new ObjectInputStream(saveFile)) {
                            User loadedUser = (User) ois.readObject();
                            return loadedUser;
                        }
                        catch (ClassNotFoundException ex) {
                            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new ProfileExceptions("User not found on computer");
    }

    public boolean readAuthFile(String path, String pwd) throws ProfileExceptions {
        try {
            FileInputStream authFile = new FileInputStream(path + "\\profile\\auth");
            try (ObjectInputStream ois = new ObjectInputStream(authFile)) {
                String login = ois.readUTF();
                String password = ois.readUTF();
                return (password.equals(pwd));
            }
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions("File not found\n" + eFound.toString());
        }
        catch(IOException eIO) {
            throw new ProfileExceptions("Cannot open file\n" + eIO.toString());
        }
    }

}
