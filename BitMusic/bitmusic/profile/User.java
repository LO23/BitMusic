/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import sun.awt.shell.ShellFolder;

/**
 *
 * @author reaneyol
 */
public class User {
    private String userId;
    private String login;
    private String password;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String avatarPath;
    private SongLibrary localSongs;

    private static final File myDocumentsFolder = (File)ShellFolder.get("fileChooserDefaultFolder");

    public SongLibrary getLocalSongs() {
        return localSongs;
    }

    public void setLocalSongs(SongLibrary localSongs) {
        this.localSongs = localSongs;
    }
    private ArrayList<Category> categories;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

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

    public User(String login, String password) {
        this(login, password, null, null, null, null);
    }

    public User getContact(String userId){
        return null;
    };

    public void addCategory(String name){
        categories.add(new Category(name));
    }

    public void updateCategory(int id, String newName){
        categories.get(id).setName(newName);
    }

    public void deleteCategory(int id){
        categories.remove(id);
    }

    public void addContact(User user, int idCategory){
        categories.get(idCategory).addUser(user);
    }

    public void removeContact(User user, int idCategory){
        categories.get(idCategory).deleteUser(user);
    }

    public SongLibrary getSongs(){
        return localSongs;
    }

    public void addSong(Song song){
        //localSongs.addSong(song);
    }

    public void deleteSong(Song song){
        //localSongs.deleteSong(song);
    }

    private String cryptPassword(String password) {
        return "test";
    }

    @Override
    public String toString() {
        return "Login : " + this.login + "\nUserID : " + this.userId + "\n";
    }
}
