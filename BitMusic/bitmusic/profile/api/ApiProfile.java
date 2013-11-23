/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.profile.api;

import bitmusic.music.data.Rights;
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
	 * @return The User if correct, null otherwise
	 * @throws ProfileExceptions 
     */
    public User checkPassword(String login, String password) throws ProfileExceptions;

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
     */
    public ArrayList<String> getCategoriesNameByUserId(String userId);

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
     */
    public void addCategory(String name);

    /**
     * Updates a category of an user
     *
     * @param categoryId
     * @param newName
     * @return
     */
    public void updateCategory(String categoryId, String newName);

    /**
     * Deletes a category of an user
     *
     * @return
     */
    public void deleteCategory(String categoryId);

    /**
     * Adds a user to a category
     *
     * @param user
     * @param categoryId
     * @return
     */
    public void addUserToCategory(User user, String categoryId);

    /**
     * Moves a user to another category
     *
     * @param userId
     * @param categoryId
     * @return
     */
    public void moveContact(String userId, String categoryId);

    /**
     * Returns the rights associated to a song
     *
     * @param songId
     * @return Rights rights
     */
    public Rights getRights(String songId, String categoryId);

    /**
     * Updates the rights associated to a song
     *
     * @param songId
     * @return
     */
    public void updateRights(String songId, Rights right);

    /**
     * Updates the rights associated to a song
     *
     * @param songId
     * @return
     */
    public void updateRights(String songId, boolean canIReadInfo, boolean canPlay, boolean canRate, boolean canComment);

    /**
     * Returns the songs of the current user
     *
     * @return ArrayList<Song> songs
     */
    public SongLibrary getSongLibrary();

    /**
     * Returns the songs of the current user
     *
     * @param songId
     * @return
     */
    public void addSong(String songId);

    /**
     * Deletes the song of the current user
     *
     * @param songId
     * @return
     */
    public void deleteSong(String songId);

}
