/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;

import java.io.File;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import sun.awt.shell.ShellFolder;

/**
 *
 * @author reaneyol, MilioPeralta
 */
public class User implements Serializable {

    //########################## ATTRIBUTES ##########################//
    /**
     *
     */
    private String userId;

    /**
     *
     */
    private String login;

    /**
     *
     */
    private transient String password;

    /**
     *
     */
    private Calendar birthDate;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String avatarPath;

    /**
     *
     */
    private SongLibrary localSongs;

    /**
     *
     */
    private static final File myDocumentsFolder = (File) ShellFolder.get("fileChooserDefaultFolder");

    /**
     *
     */
    private ArrayList<Category> categories;

    //######################### CONSTRUCTORS ###########################//

    /**
     *
     * @param login
     * @param password
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param avatarPath
     */
    public User(String login, String password, String firstName, String lastName, Calendar birthDate, String avatarPath) {
        this.userId = UUID.randomUUID().toString();
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.avatarPath = avatarPath;
        this.categories = new ArrayList<Category>();
        categories.add(new Category("Général"));
    }

    /**
     *
     * @param login
     * @param password
     */
    public User(String login, String password) {
        this(login, password, null, null, null, null);
    }

    //########################### METHODS ##############################//

    /**
     *
     * @return
     */
    public SongLibrary getLocalSongs() {
        return localSongs;
    }

    /**
     *
     * @param localSongs
     */
    public void setLocalSongs(SongLibrary localSongs) {
        this.localSongs = localSongs;
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Calendar getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getAvatarPath() {
        return avatarPath;
    }

    /**
     *
     * @param avatarPath
     */
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    /**
     *
     * @return
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @return
     */
    public Category getCategoryById(String categoryId) throws ProfileExceptions {
        for(Category cat : this.categories) {
            if(cat.getId() == categoryId) {
                return cat;
            }
        }
        throw new ProfileExceptions(ProfileExceptionType.CategoryNotFound);
    }

    /**
     *
     * @param categories
     */
    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    /**
     *
     * @param userId
     * @return
     */
    public User getContact(String userId) {
    	User usr = null;
    	for (Category cat : categories) {
    		usr = cat.findContact(userId);
    		if (usr != null) break;
    	}
        return usr;
    }

    /**
     *
     * @param name
     */
    public void addCategory(String name) {
        categories.add(new Category(name));
    }

    /**
     *
     * @param id
     * @param newName
     */
    public void updateCategory(String categoryId, String newName) throws ProfileExceptions {
        this.getCategoryById(categoryId).setName(newName);
    }

    /**
     *
     * @param id
     */
    public void deleteCategory(String categoryId) throws ProfileExceptions {
        categories.remove(this.getCategoryById(categoryId));
    }

    /**
     *
     * @param user
     * @param idCategory
     */
    public void addContact(User user, String categoryId) throws ProfileExceptions {
        this.getCategoryById(categoryId).addUser(user);
    }

    /**
     *
     * @param user
     * @param idCategory
     */
    public void removeContact(User user, String categoryId) throws ProfileExceptions {
         this.getCategoryById(categoryId).deleteUser(user);
    }

    /**
     *
     * @return
     */
    public SongLibrary getSongs() {
        return localSongs;
    }

    /**
     *
     * @param song
     */
    public void addSong(Song song) {
        //localSongs.addSong(song);
    }

    /**
     *
     * @param song
     */
    public void deleteSong(Song song) {
        //localSongs.deleteSong(song);
    }

    /**
     *
     * @param password
     * @return
     */
    private String cryptPassword(String password) {
        try {
            Cipher c = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        //using Cypher from Java
        return "test";
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Login : " + this.login + "\nUserID : " + this.userId + "\n";
    }

    /**
     *
     * @return
     */
    public String getTransformedBirthday() {
        int year = this.birthDate.get(Calendar.YEAR);
        int month = this.birthDate.get(Calendar.MONTH);
        int day = this.birthDate.get(Calendar.DAY_OF_MONTH);
        return Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
    }
    
}
