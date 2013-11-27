/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bitmusic.profile.utilities.ProfileExceptions;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jérémy
 */
public class UserTest {
	private static final String   LOGIN      = "login";
	private static final String   PASSWORD   = "password";
	private static final String   FIRSTNAME  = "firstname";
	private static final String   LASTNAME   = "lastname";
	private static final String   AVATARPATH = "avatarpath";
	private Calendar birthdate  = Calendar.getInstance();
	private User user = null;
	
	public UserTest() {
	}
	
	@Before
    public void setUp() {
		birthdate.set(2013, 11, 15);
		user = new User(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
    }

    /**
     * Test of getLogin method, of class User.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        assertEquals(LOGIN, user.getLogin());
    }

    /**
     * Test of setLogin method, of class User.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String newLogin = "newlogin";
        try {
            user.setLogin(newLogin);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(newLogin, user.getLogin());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        assertEquals(PASSWORD, user.getPassword());
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String newPassword = "newpassword";
        try {
            user.setPassword(newPassword);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(newPassword, user.getPassword());
    }

    /**
     * Test of getBirthDate method, of class User.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        assertEquals(birthdate, user.getBirthDate());
    }

    /**
     * Test of setBirthDate method, of class User.
     */
    @Test
    public void testSetBirthDate() {
        System.out.println("setBirthDate");
        Calendar newBirthdate = Calendar.getInstance();
        newBirthdate.set(2013, 12, 24);
        try {
            user.setBirthDate(newBirthdate);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(newBirthdate, user.getBirthDate());
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        assertEquals(FIRSTNAME, user.getFirstName());
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String newFirstname = "newfirstname";
        try {
            user.setFirstName(newFirstname);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(newFirstname, user.getFirstName());
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        assertEquals(LASTNAME, user.getLastName());
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String newLastname = "newlastname";
        try {
            user.setLastName(newLastname);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(newLastname, user.getLastName());
    }

    /**
     * Test of getAvatarPath method, of class User.
     */
    @Test
    public void testGetAvatarPath() {
        System.out.println("getAvatarPath");
        assertEquals(AVATARPATH, user.getAvatarPath());
    }

    /**
     * Test of setAvatarPath method, of class User.
     */
    @Test
    public void testSetAvatarPath() {
        System.out.println("setAvatarPath");
        String newAvatarPath = "newavatarpath";
        try {
            user.setAvatarPath(newAvatarPath);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(newAvatarPath, user.getAvatarPath());
    }

    /**
     * Test of addCategory method, of class User.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String categoryName = "category";
        List<Category> cat = user.getCategories();
        cat.add(new Category(categoryName));
        try {
            user.addCategory(categoryName);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(cat, user.getCategories());
    }


    /**
     * Test of deleteCategory method, of class User.
     * @throws ProfileExceptions 
     */
    @Test
    public void testDeleteCategory() throws ProfileExceptions {
        System.out.println("deleteCategory");
        List<Category> cat = new ArrayList<Category>(user.getCategories());
        String uuid = cat.get(0).getId();
        cat.remove(0);
        user.deleteCategory(uuid);
        assertEquals(cat, user.getCategories());
    }
    
    /**
     * Test of deleteCategory method, of class User with wrong id
     * @throws ProfileExceptions 
     */
    @Test(expected=ProfileExceptions.class)
    public void testDeleteCategoryWithWrongId() throws ProfileExceptions {
        System.out.println("deleteCategoryWithWrongId");
        String uuid = "wrongid";
        user.deleteCategory(uuid);
    }

    /**
     * Test of addContact method, of class User.
     * @throws ProfileExceptions 
     */
    @Test
    public void testAddContact() throws ProfileExceptions {
        System.out.println("addContact");
        User newUser = new User("test", "mdptest");
        List<Category> cat = new ArrayList<Category>(user.getCategories());
        cat.get(0).addUser(newUser);
        String uuid = cat.get(0).getId();
        user.addContact(newUser, uuid);
        assertEquals(cat, user.getCategories());
    }

    /**
     * Test of removeContact method, of class User.
     * @throws ProfileExceptions 
     */
    @Test
    public void testRemoveContact() throws ProfileExceptions {
        System.out.println("removeContact");
        List<Category> cat = new ArrayList<Category>(user.getCategories());
        String uuid = cat.get(0).getId();
        User newUser = new User("test", "mdptest");
        user.addContact(newUser, uuid);
        cat.get(0).deleteUser(newUser);
        user.removeContact(newUser, uuid);
        assertEquals(cat, user.getCategories());
    }
}
