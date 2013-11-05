/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

import java.util.ArrayList;

/**
 * Category
 * @author frogerfa, lesceuni, reaneyol
 */
public class Category {
    
    private String name;
    private ArrayList<User> contacts;
    private Rights rights;

    /**
     * Constructor : Create a category
     * @param name  Name of the category
     */
    public Category(String name) {
        this.contacts = new ArrayList<User>();
        this.name = name;
        this.rights = new Rights();
    }

    /**
     * Change the name of the category
     * @param newName New name of the category
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Return the name of the category
     * @return name of the category
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Return the rights of the category
     * @return Rights of the category
     */
    public Rights getRight() {
        return this.rights;
    }
   
    /**
     * Update the rights of the category
     * @param canIReadInfo Right to read information
     * @param canPlay Right to play
     * @param canRate Right to play
     * @param canComment Right to comment
     */
    public void updateRight(boolean canIReadInfo, boolean canPlay, boolean canRate, boolean canComment) {
        this.rights = new Rights(canIReadInfo, canPlay, canRate, canComment);
    }
    
    /**
     * Add a user in the contact list
     * @param user
     * @return true if contact added
     */
    public boolean addUser(User user){
        return contacts.add(user);
        
    }
    
    /**
     * Delete a user from the contact list
     * @param user
     * @return true if contact deleted
     */
    public boolean deleteUser(User user){
        return contacts.remove(user);
    }

}
