/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.api;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;

/**
 *
 * @author Milio, Jérémy
 */
public class ApiProfileImplTest {
	private static final String   LOGIN      = "logintest";
	private static final String   PASSWORD   = "passwordtest";
	private static final String   FIRSTNAME  = "firstnametest";
	private static final String   LASTNAME   = "lastnametest";
	private static final String   AVATARPATH = "avatarpathtest";
	private Calendar birthdate  = Calendar.getInstance();
    private User userTest = null;
    private ApiProfile api = null;

    public ApiProfileImplTest() {
    	api = ApiProfileImpl.getApiProfile();
		birthdate.set(2013, 11, 15);
		userTest = new User(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
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
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test
    public void testCreateUser() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        assertEquals(userTest, api.getCurrentUser());
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithEmptyLogin() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser("", PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        fail("testCreateUserWithEmptyLogin failed");
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithNullLogin() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(null, PASSWORD, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        fail("testCreateUserWithNullLogin failed");
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithEmptyPassword() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(LOGIN, "", FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        fail("testCreateUserWithEmptyPassword failed");
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithNullPassword() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(LOGIN, null, FIRSTNAME, LASTNAME, birthdate, AVATARPATH);
        fail("testCreateUserWithNullPassword failed");
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithNullBirthdate() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, null, AVATARPATH);
        fail("testCreateUserWithNullBirthdate failed");
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithEmptyAvatarPath() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, "");
        fail("testCreateUserWithEmptyAvatarPath failed");
    }
    
    /**
     * Test of createUser method, of class ApiProfileImpl.
     */
    @Test(expected=ProfileExceptions.class)
    public void testCreateUserWithNullAvatarPath() throws ProfileExceptions {
        System.out.println("createUser");
        api.createUser(LOGIN, PASSWORD, FIRSTNAME, LASTNAME, birthdate, null);
        fail("testCreateUserWithNullAvatarPath failed");
    }

    /**
     * Test of checkPassword method, of class ApiProfileImpl.
     * @throws ProfileExceptions 
     */
    @Test(expected=ProfileExceptions.class)
    public void testCheckPasswordWithEmptyLogin() throws ProfileExceptions {
    	System.out.println("checkPassword");
    	api.checkPassword("", PASSWORD);
    	fail("testCheckPasswordWithEmptyLogin failed");
    }

    /**
     * Test of checkPassword method, of class ApiProfileImpl.
     * @throws ProfileExceptions 
     */
    @Test(expected=ProfileExceptions.class)
    public void testCheckPasswordWithNullLogin() throws ProfileExceptions {
    	System.out.println("checkPassword");
    	api.checkPassword(null, PASSWORD);
    	fail("testCheckPasswordWithNullLogin failed");
    }

    /**
     * Test of checkPassword method, of class ApiProfileImpl.
     * @throws ProfileExceptions 
     */
    @Test(expected=ProfileExceptions.class)
    public void testCheckPasswordWithEmptyPassword() throws ProfileExceptions {
    	System.out.println("checkPassword");
    	api.checkPassword(LOGIN, "");
    	fail("testCheckPasswordWithEmptyPassword failed");
    }

    /**
     * Test of checkPassword method, of class ApiProfileImpl.
     * @throws ProfileExceptions 
     */
    @Test(expected=ProfileExceptions.class)
    public void testCheckPasswordWithNullPassword() throws ProfileExceptions {
    	System.out.println("checkPassword");
    	api.checkPassword(LOGIN, null);
    	fail("testCheckPasswordWithNullPassword failed");
    }

}
