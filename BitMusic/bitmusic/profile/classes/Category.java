/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

import bitmusic.music.data.Rights;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Category
 * @author frogerfa, lesceuni, reaneyol, MilioPeralta
 */
public class Category implements Serializable {

    //########################## ATTRIBUTES ##########################//

    private String id;
    private String name;
    private ArrayList<User> contacts;
    private Rights rights;

    //######################### CONSTRUCTORS ###########################//

    /**
     * Constructor : Create a category
     * @param name  Name of the category
     */
    public Category(String name) {
        this.id = UUID.randomUUID().toString();
        this.contacts = new ArrayList<User>();
        this.name = name;
        this.rights = new Rights(true, true, true, true);
    }

    //########################### METHODS ##############################//

    /**
     * Change the name of the category
     * @param newName New name of the category
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /**
     * Return the Id of the category
     * @return Id
     */
    public String getId(){
        return this.id;
    }

    /**
     * Return the name of the category
     * @return name of the category
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the contacts of the category
     * @return List of the contacts
     */
    public ArrayList<User> getContacts(){
        return this.contacts;
    }
    
    /**
     * Change the list of the contacts
     * @param contacts new contacts to add
     */
    public void setContacts(ArrayList<User> contacts){
        this.contacts = contacts;
    }
    
    /**
     * Return the rights of the category
     * @return Rights of the category
     */
    public Rights getRight() {
        return this.rights;
    }

    /**
     * Find a user with its ID
     * @param UserID UserID to find
     * @return th User or null
     */
    public User findContact(String UserID){
        User found = null;
        for(User contact : this.contacts){
            if(contact.getUserId() == UserID) found = contact;
        }
        return found;
    }
    
    /**
     * Update the rights of the category
     * @param canIReadInfo Right to read information
     * @param canPlay Right to play
     * @param canRate Right to play
     * @param canComment Right to comment
     */
    public void updateRight(boolean canIReadInfo, boolean canPlay, boolean canRate, boolean canComment) {
        if(this.rights != null) {
            // TO DO this.rights.updateRights(canIReadInfo, canPlay, canRate, canComment);
        }
        else {
            // TO DO this.rights = new Rights();
        }
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
