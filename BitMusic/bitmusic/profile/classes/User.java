/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import sun.awt.shell.ShellFolder;

/**
 *
 * @author reaneyol, MilioPeralta
 */
public class User {

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
    private String password;

    /**
     *
     */
    private Date birthDate;

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
    public User(String login, String password, String firstName, String lastName, Date birthDate, String avatarPath) {
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
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(Date birthDate) {
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

        // TODO

        return null;
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
    public void updateCategory(int id, String newName) {
        categories.get(id).setName(newName);
    }

    /**
     *
     * @param id
     */
    public void deleteCategory(int id) {
        categories.remove(id);
    }

    /**
     *
     * @param user
     * @param idCategory
     */
    public void addContact(User user, int idCategory) {
        categories.get(idCategory).addUser(user);
    }

    /**
     *
     * @param user
     * @param idCategory
     */
    public void removeContact(User user, int idCategory) {
        categories.get(idCategory).deleteUser(user);
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
}
