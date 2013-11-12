/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Holywa
 */
public class UserParserTest {

    public UserParserTest() {
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
     * Test of loadUser method, of class UserParser.
     */
    @Test
    public void testLoadUser() throws Exception {
        System.out.println("loadUser");
        UserParser instance = new UserParser();
        instance.loadUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
