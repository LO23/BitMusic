/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.profile.api;

import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author MilioPeralta, Jérémy
 */
public interface ApiProfile {
	
	/**
	 * Chek if the login and password are correct
	 * 
	 * @param login
	 * @param password
	 * @return True if correct, false otherwise
	 * @throws ProfileExceptions 
     */
    public boolean checkPassword(String login, String password) throws ProfileExceptions;

    /**
     * Creates a User as an object User
     *
     * @param login
     * @param password
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param avatarPath
     * @return
     * @throws bitmusic.profile.utilities.ProfileExceptions
     */
    public void createUser(String login, String password, String firstName, String lastName, Calendar birthDate, String avatarPath) throws ProfileExceptions;

    /**
     * Saves a User as an object User
     *
     * @return
     */
    public void saveUser(User user) throws ProfileExceptions;

    /**
     * Returns the current user as an object User
     *
     * @return User user
     */
    public User getCurrentUser();

    /**
     * Set the current user as the one read in the file
     *
     * @param User newUser
     */
    public void setCurrentUser(User newUser);

    /**
     * Returns the folder of the current user
     *
     * @return String folderName
     */
    public String getCurrentUserFolder();

    /**
     * Returns the categories names of an user
     *
     * @param userId
     * @return ArrayList<String>
     * @throws ProfileExceptions 
     */
    public ArrayList<String> getCategoriesNameByUserId(String userId) throws ProfileExceptions;

    /**
     * Returns a category name of an user
     *
     * @return ArrayList<String>
     */
    public ArrayList<Category> getCategories();

    /**
     * Adds a category to the categories of an user
     *
     * @param name
     * @return
     * @throws ProfileExceptions 
     */
    public void addCategory(String name) throws ProfileExceptions;

    /**
     * Updates a category of an user
     *
     * @param categoryId
     * @param newName
     * @return
     * @throws ProfileExceptions 
     */
    public void updateCategory(String categoryId, String newName) throws ProfileExceptions;

    /**
     * Deletes a category of an user
     *
     * @return
     * @throws ProfileExceptions 
     */
    public void deleteCategory(String categoryId) throws ProfileExceptions;

    /**
     * Adds a user to a category
     *
     * @param user
     * @param categoryId
     * @return
     * @throws ProfileExceptions 
     */
    public void addUserToCategory(User user, String categoryId) throws ProfileExceptions;

    /**
     * Moves a user to another category
     *
     * @param userId
     * @param categoryId
     * @return
     * @throws ProfileExceptions 
     */
    public void moveContact(String userId, String categoryId) throws ProfileExceptions;

    /**
     * Returns the rights associated to a song
     *
     * @param songId
     * @return Rights rights
     * @throws ProfileExceptions 
     */
    public Rights getRights(String songId, String categoryId) throws ProfileExceptions;

    /**
     * Updates the rights associated to a song
     *
     * @param songId
     * @return
     * @throws ProfileExceptions 
     */
    public void updateRights(String songId, Rights right) throws ProfileExceptions;

    /**
     * Updates the rights associated to a song
     *
     * @param songId
     * @return
     * @throws ProfileExceptions 
     */
    public void updateRights(String songId, boolean canIReadInfo, boolean canPlay, boolean canRate, boolean canComment) throws ProfileExceptions;

    /**
     * Returns the songs of the current user
     *
     * @return ArrayList<Song> songs
     */
    public SongLibrary getSongLibrary();

    /**
     * Returns the songs of the current user
     *
     * @param song
     * @return
     * @throws ProfileExceptions 
     */
    public void addSong(Song song) throws ProfileExceptions;

    /**
     * Deletes the song of the current user
     *
     * @param songId
     * @return
     * @throws ProfileExceptions 
     */
    public void deleteSong(String songId) throws ProfileExceptions;

}
