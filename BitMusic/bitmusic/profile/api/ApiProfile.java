/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.profile.api;

import bitmusic.profile.classes.User;

import bitmusic.music.data.Song;
import java.util.ArrayList;

/**
 *
 * @author saben2
 */
public class Profile {
    //########################## ATTRIBUTES ##########################//

    private static User currentUser;

    //########################### METHODS ##############################//
    /*
    public boolean checkPassword(String login, String password){
        return true;
    }
    public void saveUser(User user){
    }*/

    public static User getCurrentUser() {
        return Profile.currentUser;
    }

    public static void setCurrentUser(User newUser) {
        Profile.currentUser = newUser;
    }

    /*public User getCurrentUser(String userId){
        if(currentUser.getUserId()==userId){
            return this.currentUser;
        }
    }
    public void createUser(){
    }
    public ArrayList<String> getCategoriesNameByUserId(){
    }
    public ArrayList<Category> getCategories(){
    }
    public void addCategory(String name){
    }
    public void updateCategory(int categoryId, String newName){
    }
    public void deleteCategory(int categoryId){
    }
    public void addUserToCategory(String userId,int categoryId){
    }
    public void moveContact(String userId, int categoryId){
    }
    public Rights getRights(String songId){
    }
    public void updateRights(){
    }
    public ArrayList<Song> getSongs(){
    }
    public void addSong(String songId){
    }
    public void deleteSong(String songId){
    }
    */
}
