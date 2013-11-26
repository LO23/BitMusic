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
import bitmusic.profile.utilities.ProfileExceptions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ApiProfileImpl instance = ApiProfileImpl.getApiProfile();
        try {
            instance.createUser(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(instance.getCurrentUser(), userTest);
    }

    /**
     * Test of saveUser method, of class ApiProfileImpl.
     */
    @Test
    public void testSaveUser() throws Exception {
        System.out.println("saveUser");
        User user = null;
        try {
            ApiProfileImpl.getApiProfile().saveUser(user);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUser method, of class ApiProfileImpl.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        User expResult = null;
        User result = ApiProfileImpl.getApiProfile().getCurrentUser();
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
        ApiProfileImpl.getApiProfile().setCurrentUser(newUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUserFolder method, of class ApiProfileImpl.
     */
    @Test
    public void testGetCurrentUserFolder() {
        System.out.println("getCurrentUserFolder");
        String expResult = "";
        String result = ApiProfileImpl.getApiProfile().getCurrentUserFolder();
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
        ArrayList<String> expResult = null;
        ArrayList<String> result = new ArrayList<String>();
        try {
            result = ApiProfileImpl.getApiProfile().getCategoriesNameByUserId(userId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = ApiProfileImpl.getApiProfile().getCategories();
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
        try {
            ApiProfileImpl.getApiProfile().addCategory(name);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().updateCategory(categoryId, newName);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().deleteCategory(categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().addUserToCategory(user, categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().moveContact(userId, categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        Rights expResult = null;
        Rights result = null;
        try {
            result = ApiProfileImpl.getApiProfile().getRights(songId, categoryId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().updateRights(categoryId, right);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().updateRights(categoryId, canIReadInfo, canPlay, canRate, canComment);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSongLibrary method, of class ApiProfileImpl.
     */
    @Test
    public void testGetSongLibrary() {
        System.out.println("getSongLibrary");
        SongLibrary expResult = null;
        SongLibrary result = ApiProfileImpl.getApiProfile().getSongLibrary();
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
        try {
            ApiProfileImpl.getApiProfile().addSong(song);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            ApiProfileImpl.getApiProfile().deleteSong(songId);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(ApiProfileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
