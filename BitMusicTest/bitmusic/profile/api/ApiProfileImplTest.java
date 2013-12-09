/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.api;

import bitmusic.music.data.Rights;
import bitmusic.music.data.Song;
import bitmusic.music.data.SongLibrary;
import bitmusic.profile.classes.Category;
import bitmusic.profile.classes.User;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Milio
 */
public class ApiProfileImplTest {
	private static final String   LOGIN      = "login";
	private static final String   PASSWORD   = "password";
	private static final String   FIRSTNAME  = "firstname";
	private static final String   LASTNAME   = "lastname";
	private static final String   AVATARPATH = "avatarpath";
	private Calendar birthdate  = Calendar.getInstance();
        User userTest = new User(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);

    public ApiProfileImplTest() {
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
     * Test of getApiProfile method, of class ApiProfileImpl.
     */
    @Test
    public void testGetApiProfile() {
    }

    /**
     * Test of checkPassword method, of class ApiProfileImpl.
     */
    @Test
    public void testCheckPassword() throws Exception {
    }

    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        ApiProfileImpl instance = new ApiProfileImpl();
        User userAPI = instance.createUser(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        assertEquals(instance.getCurrentUser(), userTest);
    }

    /**
     * Test of saveUser method, of class ApiProfileImpl.
     */
    @Test
    public void testSaveUser() throws Exception {
        System.out.println("saveUser");
        User user = null;
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.saveUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUser method, of class ApiProfileImpl.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        ApiProfileImpl instance = new ApiProfileImpl();
        User expResult = null;
        User result = instance.getCurrentUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentUser method, of class ApiProfileImpl.
     */
    @Test
    public void testSetCurrentUser() {
        System.out.println("setCurrentUser");
        User newUser = null;
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.setCurrentUser(newUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUserFolder method, of class ApiProfileImpl.
     */
    @Test
    public void testGetCurrentUserFolder() {
        System.out.println("getCurrentUserFolder");
        ApiProfileImpl instance = new ApiProfileImpl();
        String expResult = "";
        String result = instance.getCurrentUserFolder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoriesNameByUserId method, of class ApiProfileImpl.
     */
    @Test
    public void testGetCategoriesNameByUserId() throws Exception {
        System.out.println("getCategoriesNameByUserId");
        String userId = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getCategoriesNameByUserId(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class ApiProfileImpl.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        ApiProfileImpl instance = new ApiProfileImpl();
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCategory method, of class ApiProfileImpl.
     */
    @Test
    public void testAddCategory() throws Exception {
        System.out.println("addCategory");
        String name = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.addCategory(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCategory method, of class ApiProfileImpl.
     */
    @Test
    public void testUpdateCategory() throws Exception {
        System.out.println("updateCategory");
        String categoryId = "";
        String newName = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.updateCategory(categoryId, newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCategory method, of class ApiProfileImpl.
     */
    @Test
    public void testDeleteCategory() throws Exception {
        System.out.println("deleteCategory");
        String categoryId = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.deleteCategory(categoryId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserToCategory method, of class ApiProfileImpl.
     */
    @Test
    public void testAddUserToCategory() throws Exception {
        System.out.println("addUserToCategory");
        User user = null;
        String categoryId = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.addUserToCategory(user, categoryId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveContact method, of class ApiProfileImpl.
     */
    @Test
    public void testMoveContact() throws Exception {
        System.out.println("moveContact");
        String userId = "";
        String categoryId = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.moveContact(userId, categoryId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRights method, of class ApiProfileImpl.
     */
    @Test
    public void testGetRights() throws Exception {
        System.out.println("getRights");
        String songId = "";
        String categoryId = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        Rights expResult = null;
        Rights result = instance.getRights(songId, categoryId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRights method, of class ApiProfileImpl.
     */
    @Test
    public void testUpdateRights_String_Rights() throws Exception {
        System.out.println("updateRights");
        String categoryId = "";
        Rights right = null;
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.updateRights(categoryId, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRights method, of class ApiProfileImpl.
     */
    @Test
    public void testUpdateRights_5args() throws Exception {
        System.out.println("updateRights");
        String categoryId = "";
        boolean canIReadInfo = false;
        boolean canPlay = false;
        boolean canRate = false;
        boolean canComment = false;
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.updateRights(categoryId, canIReadInfo, canPlay, canRate, canComment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSongLibrary method, of class ApiProfileImpl.
     */
    @Test
    public void testGetSongLibrary() {
        System.out.println("getSongLibrary");
        ApiProfileImpl instance = new ApiProfileImpl();
        SongLibrary expResult = null;
        SongLibrary result = instance.getSongLibrary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSong method, of class ApiProfileImpl.
     */
    @Test
    public void testAddSong() throws Exception {
        System.out.println("addSong");
        Song song = null;
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.addSong(song);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSong method, of class ApiProfileImpl.
     */
    @Test
    public void testDeleteSong() throws Exception {
        System.out.println("deleteSong");
        String songId = "";
        ApiProfileImpl instance = new ApiProfileImpl();
        instance.deleteSong(songId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
