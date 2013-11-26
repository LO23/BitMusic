/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.api;

import bitmusic.music.api.ApiMusicImpl;
import java.util.ArrayList;
import java.util.Calendar;

import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.network.main.Controller;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import bitmusic.profile.saving.FileParser;
import bitmusic.profile.saving.FileSaver;
import bitmusic.profile.utilities.ProfileExceptionType;
import bitmusic.profile.utilities.ProfileExceptions;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 *
 * @author MilioPeralta
 */
public class ApiProfileImpl implements ApiProfile {
    private static ApiProfileImpl currentApi;
    public User currentUser;

    private ApiProfileImpl() throws ProfileExceptions {
        /*String defaultPath = new File("").getAbsolutePath().toString()
                + "\\BitMusic";*/

        String defaultPath = new File("").getAbsolutePath().toString()
                + "\\BitTest";

        if(!Files.exists(FileSystems.getDefault().getPath(defaultPath))) {
           try {
            Files.createDirectory(FileSystems.getDefault().getPath(defaultPath));
            Files.createDirectory(FileSystems.getDefault().getPath(defaultPath
                    + "\\profiles"));
            }
            catch(IOException io) {
                throw new ProfileExceptions(io.toString());
            }
        }
    }

    public static ApiProfileImpl getApiProfile()  {
        if (currentApi == null) {
            try {
                currentApi = new ApiProfileImpl();
            }
            catch(ProfileExceptions e) {
                System.out.println(e.toString());
            }
        }

        return currentApi;
    }
    
    @Override
    public boolean checkPassword(String login,
            String password) throws ProfileExceptions {
    	if (login == null || login.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.LoginNull);
    	if (password == null || password.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.PasswordNull);
    	currentUser = FileParser.getFileParser().loadUser(login, password);
    	if (currentUser == null) return false;
    	Controller.getInstance().getApiProfile().notifyNewConnection(currentUser);
    	return true;
    }

    @Override
    public void createUser(String login, String password, 
            String firstName, String lastName,
            Calendar birthDate, String avatarPath) throws ProfileExceptions{
        if(login.isEmpty() || login.length() == 0){
            throw new ProfileExceptions(ProfileExceptionType.LoginNull);
        }
        if(password.isEmpty() || password.length() == 0){
            throw new ProfileExceptions(ProfileExceptionType.PasswordNull);
        }

        if(birthDate == null) {
            throw new ProfileExceptions(ProfileExceptionType.BirthDateNull);
        }

        if(avatarPath.isEmpty()) {
            throw new ProfileExceptions(ProfileExceptionType.PathNull);
        }

        if(login.contains("_")) {
            throw new ProfileExceptions(ProfileExceptionType.LoginWithInvalidCharacters);
        }

        currentUser = new User(login, password, firstName, lastName, birthDate,
                avatarPath);

        /*String defaultPath = new File("").getAbsolutePath().toString() +
                "\\BitMusic\\profiles" + this.getCurrentUserFolder() ;*/

        String defaultPath = new File("").getAbsolutePath().toString() +
                "\\BitTest\\profiles" + this.getCurrentUserFolder() ;

        if(!Files.exists(FileSystems.getDefault().getPath(defaultPath))) {
           try {
            Files.createDirectory(FileSystems.getDefault().getPath(defaultPath));
            Files.createDirectory(FileSystems.getDefault().getPath(defaultPath
                    + "\\profile"));
            ApiMusicImpl.getInstance().initMusicFolder();
            }
            catch(IOException io) {
                throw new ProfileExceptions(io.toString());
            }
        }

    }


    @Override
    public void saveUser(User user) throws ProfileExceptions {
    	if (user == null)
            throw new ProfileExceptions(ProfileExceptionType.UserNull);
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
    public ArrayList<String> getCategoriesNameByUserId(String userId) throws ProfileExceptions {
    	if (userId == null | userId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.UserNull);
        ArrayList<Category> myCategories = currentUser.getCategories();
        ArrayList<String> myCategoriesNames = new ArrayList<String>();

        for (Category cat : myCategories) {
            if (cat.findContact(userId) != null)
                myCategoriesNames.add(cat.getName());
        }

        return myCategoriesNames;

    }

    @Override
    public ArrayList<Category> getCategories() {
        return currentUser.getCategories();
    }

    @Override
    public void addCategory(String name) throws ProfileExceptions {
    	if (name == null || name.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        currentUser.addCategory(name);
    }

    @Override
    public void updateCategory(String categoryId,
            String newName) throws ProfileExceptions {
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
    	if (newName == null || newName.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        currentUser.updateCategory(categoryId, newName);
    }

    @Override
    public void deleteCategory(String categoryId) throws ProfileExceptions {
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        currentUser.deleteCategory(categoryId);
    }

    @Override
    public void addUserToCategory(User user,
            String categoryId) throws ProfileExceptions {
    	if (user == null)
            throw new ProfileExceptions(ProfileExceptionType.UserNull);
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        currentUser.addContact(user, categoryId);
    }

    @Override
    public void moveContact(String userId,
            String categoryId) throws ProfileExceptions {
    	if (userId == null || userId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        Category myCategory = currentUser.getCategoryById(categoryId);
        User tmpUser = myCategory.findContact(userId);

        currentUser.removeContact(tmpUser, categoryId);
        currentUser.addContact(tmpUser, categoryId);
    }

    @Override
    public Rights getRights(String songId,
            String categoryId) throws ProfileExceptions {
    	if (songId == null || songId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        Rights tmpRight = currentUser.getSongs().getSong(songId).getRightsByCategory().get(categoryId);

        if(tmpRight == null){
            tmpRight = new Rights();
        }

        return tmpRight;
    }

    @Override
    public void updateRights(String categoryId,
            Rights right) throws ProfileExceptions {
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
    	if (right == null)
            throw new ProfileExceptions(ProfileExceptionType.RightNull);
        currentUser.getCategoryById(categoryId).updateRight(right.getcanPlay(),
                right.getcanPlay(), right.getcanRate(), right.getcanComment());
    }

    @Override
    public void updateRights(String categoryId, boolean canIReadInfo, 
            boolean canPlay, boolean canRate,
            boolean canComment) throws ProfileExceptions {
    	if (categoryId == null || categoryId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        currentUser.getCategoryById(categoryId).updateRight(canIReadInfo, 
                canPlay, canRate, canComment);
    }

    @Override
    public SongLibrary getSongLibrary() {
        return currentUser.getSongs();
    }

    @Override
    public void addSong(Song song) throws ProfileExceptions {
    	if (song == null)
            throw new ProfileExceptions(ProfileExceptionType.SongNull);
        this.currentUser.addSong(song);
    }

    @Override
    public void deleteSong(String songId) throws ProfileExceptions {
    	if (songId == null || songId.isEmpty())
            throw new ProfileExceptions(ProfileExceptionType.EmptyString);
        this.currentUser.deleteSong(songId);
    }

}