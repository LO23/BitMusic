/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

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

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;

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
    private static String mainStructure = "\\BitTest\\profiles\\";
    private static String profileStructure = "\\profile\\";


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
            String defaultPath = new File("").getAbsolutePath().toString()
            		+ mainStructure;

            DirectoryStream<Path> stream = Files.newDirectoryStream(FileSystems.getDefault().getPath(defaultPath));
            for(Path path:stream) {
                if(path.getFileName().toString().contains(login) && (new File(path.toString())).isDirectory()) {
                    if(readAuthFile(path.toString(), pwd)) {
                        try {
                        	FileInputStream saveFile = new FileInputStream(path.toString() 
                        			+ profileStructure 
                        			+ login + ".ser");

                            ObjectInputStream ois = new ObjectInputStream(saveFile);
                            User loadedUser = (User) ois.readObject();
                            ois.close();
                            saveFile.close();
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
            FileInputStream authFile = new FileInputStream(path
            		+ profileStructure + "auth");
            ObjectInputStream ois = new ObjectInputStream(authFile);
            String password = ois.readUTF();
            ois.close();
            authFile.close();
            ConfigurablePasswordEncryptor pwdEncryptor = new ConfigurablePasswordEncryptor();
            pwdEncryptor.setAlgorithm("SHA-1");
            return pwdEncryptor.checkPassword(pwd, password);
        }
        catch(FileNotFoundException eFound) {
            throw new ProfileExceptions("File not found\n" + eFound.toString());
        }
        catch(IOException eIO) {
            throw new ProfileExceptions("Cannot open file\n" + eIO.toString());
        }
    }

}
