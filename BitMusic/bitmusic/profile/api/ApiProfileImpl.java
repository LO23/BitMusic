/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import bitmusic.profile.saving.FileParser;
import bitmusic.profile.saving.FileSaver;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;

/**
 *
 * @author MilioPeralta
 */
public class ApiProfileImpl implements ApiProfile {
    private static ApiProfileImpl currentApi;
    public User currentUser;

    public static ApiProfileImpl getApiProfile(){
        if (currentApi == null) {
            currentApi = new ApiProfileImpl();
        }

        return currentApi;
    }
    
    @Override
    public User checkPassword(String login, String password) throws ProfileExceptions {
    	return FileParser.getFileParser().loadUser(login, password);
    }

    @Override
    public void createUser(String login, String password, String firstName, String lastName, Calendar birthDate, String avatarPath) throws ProfileExceptions{
        if(login == null || login.length() == 0){
            throw new ProfileExceptions(ProfileExceptionType.LoginNull);
        }
        if(password == null || password.length() == 0){
            throw new ProfileExceptions(ProfileExceptionType.PasswordNull);
        }

        if(birthDate == null) {
            throw new ProfileExceptions(ProfileExceptionType.PasswordNull);
        }

        if(login.contains("_")) {
            throw new ProfileExceptions(ProfileExceptionType.LoginWithInvalidCharacters);
        }

        currentUser = new User(login, password, firstName, lastName, birthDate,
                avatarPath);

    }


    @Override
    public void saveUser(User user) throws ProfileExceptions {
        FileSaver.getFileSaver().saveUser(user);
    }

    @Override
    public User getCurrentUser() {
        return this.currentUser;
    }

    @Override
    public void setCurrentUser(User newUser) {
        this.currentUser = newUser;
    }

        @Override
    public String getCurrentUserFolder() {
        return currentUser.getFolderName();
    }

    @Override
    public ArrayList<String> getCategoriesNameByUserId(String userId) {
        ArrayList<Category> myCategories = currentUser.getCategories();
        ArrayList<String> myCategoriesNames = new ArrayList<>();

        for (Category cat : myCategories) {
            myCategoriesNames.add(cat.getName());
        }

        return myCategoriesNames;

    }

    @Override
    public ArrayList<Category> getCategories() {
        return currentUser.getCategories();
    }

    @Override
    public void addCategory(String name) {
        currentUser.addCategory(name);
    }

    @Override
    public void updateCategory(String categoryId, String newName) {
        try {
            currentUser.updateCategory(categoryId, newName);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteCategory(String categoryId) {
        try {
            currentUser.deleteCategory(categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addUserToCategory(User user, String categoryId) {
        try {
            currentUser.addContact(user, categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void moveContact(String userId, String categoryId) {
        try {
            Category myCategory = currentUser.getCategoryById(categoryId);
            User tmpUser = myCategory.findContact(userId);

            currentUser.removeContact(tmpUser, categoryId);
            currentUser.addContact(tmpUser, categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Rights getRights(String songId, String categoryId) {
        Rights tmpRight = currentUser.getSongs().getSong(songId).getRightsByCategory().get(categoryId);

        if(tmpRight == null){
            tmpRight = new Rights();
        }

        return tmpRight;
    }

    @Override
    public void updateRights(String categoryId, Rights right) {
        try {
            currentUser.getCategoryById(categoryId).updateRight(right.getcanPlay(), right.getcanPlay(), right.getcanRate(), right.getcanComment());
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRights(String categoryId, boolean canIReadInfo, boolean canPlay, boolean canRate, boolean canComment) {
        try {
            currentUser.getCategoryById(categoryId).updateRight(canIReadInfo,canPlay,canRate, canComment);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public SongLibrary getSongLibrary() {
        return currentUser.getSongs();
    }

    @Override
    public void addSong(Song song) {
        this.currentUser.addSong(song);
    }

    @Override
    public void deleteSong(String songId) {
        this.currentUser.deleteSong(songId);
    }

}