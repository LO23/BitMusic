/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.api;

import bitmusic.profile.classes.User;
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
public class ApiProfileTest {

    public ApiProfileTest() {
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
     * Test of getCurrentUser method, of class Profile.
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
     * Test of setCurrentUser method, of class Profile.
     */
    @Test
    public void testSetCurrentUser() {
        System.out.println("setCurrentUser");
        User newUser = null;
        ApiProfileImpl.getApiProfile().setCurrentUser(newUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
