/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.api;

import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import bitmusic.profile.saving.UserSaver;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Milio
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
    public void createUser(String login, String password, String firstName, String lastName, Calendar birthDate, String avatarPath) throws ProfileExceptions{
        if(login == null || login.length() == 0){
            throw new ProfileExceptions(ProfileExceptionType.LoginNull);
        }
        if(password == null || password.length() == 0){
            throw new ProfileExceptions(ProfileExceptionType.PasswordNull);
        }

        if(birthDate == null){
            throw new ProfileExceptions(ProfileExceptionType.PasswordNull);
        }

        //currentUser = new User(login, password, firstName, lastName, birthDate, avatarPath);

    }


    @Override
    public void saveUser(User user) throws ProfileExceptions {
        UserSaver userSaver = new UserSaver();
        userSaver.saveUser(currentUser);
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public String getCurrentUserFolder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getCategoriesNameByUserId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Category> getCategories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCategory(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCategory(int categoryId, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserToCategory(User user, int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveContact(String userId, int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rights getRights(String songId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRights(String songId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Song> getSongs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSong(String songId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSong(String songId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
