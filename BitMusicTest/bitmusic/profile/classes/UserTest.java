/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nico
 */
public class UserTest {

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLocalSongs method, of class User.
     */
    @Test
    public void testGetLocalSongs() {
        System.out.println("getLocalSongs");
        User instance = null;
        SongLibrary expResult = null;
        SongLibrary result = instance.getLocalSongs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocalSongs method, of class User.
     */
    @Test
    public void testSetLocalSongs() {
        System.out.println("setLocalSongs");
        SongLibrary localSongs = null;
        User instance = null;
        instance.setLocalSongs(localSongs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class User.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        User instance = null;
        String expResult = "";
        String result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class User.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        String userId = "";
        User instance = null;
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class User.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        User instance = null;
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class User.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        User instance = null;
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthDate method, of class User.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        User instance = null;
        Date expResult = null;
        Date result = instance.getBirthDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthDate method, of class User.
     */
    @Test
    public void testSetBirthDate() {
        System.out.println("setBirthDate");
        Date birthDate = null;
        User instance = null;
        instance.setBirthDate(birthDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = null;
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        User instance = null;
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = null;
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        User instance = null;
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvatarPath method, of class User.
     */
    @Test
    public void testGetAvatarPath() {
        System.out.println("getAvatarPath");
        User instance = null;
        String expResult = "";
        String result = instance.getAvatarPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvatarPath method, of class User.
     */
    @Test
    public void testSetAvatarPath() {
        System.out.println("setAvatarPath");
        String avatarPath = "";
        User instance = null;
        instance.setAvatarPath(avatarPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class User.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        User instance = null;
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategories method, of class User.
     */
    @Test
    public void testSetCategories() {
        System.out.println("setCategories");
        ArrayList<Category> categories = null;
        User instance = null;
        instance.setCategories(categories);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class User.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        String userId = "";
        User instance = null;
        User expResult = null;
        User result = instance.getContact(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCategory method, of class User.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String name = "";
        User instance = null;
        instance.addCategory(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCategory method, of class User.
     */
    @Test
    public void testUpdateCategory() {
        System.out.println("updateCategory");
        int id = 0;
        String newName = "";
        User instance = null;
        instance.updateCategory(id, newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCategory method, of class User.
     */
    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory");
        int id = 0;
        User instance = null;
        instance.deleteCategory(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addContact method, of class User.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        User user = null;
        int idCategory = 0;
        User instance = null;
        instance.addContact(user, idCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeContact method, of class User.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        User user = null;
        int idCategory = 0;
        User instance = null;
        instance.removeContact(user, idCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSongs method, of class User.
     */
    @Test
    public void testGetSongs() {
        System.out.println("getSongs");
        User instance = null;
        SongLibrary expResult = null;
        SongLibrary result = instance.getSongs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSong method, of class User.
     */
    @Test
    public void testAddSong() {
        System.out.println("addSong");
        Song song = null;
        User instance = null;
        instance.addSong(song);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSong method, of class User.
     */
    @Test
    public void testDeleteSong() {
        System.out.println("deleteSong");
        Song song = null;
        User instance = null;
        instance.deleteSong(song);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
