/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

import java.util.ArrayList;

/**
 *
 * @author reaneyol
 */
public class Category {

    //private String id;
    private String name;
    private ArrayList<UserLight> contacts;

    public Category(String name) {
        this.contacts = new ArrayList<UserLight>();
        this.name = name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

}
