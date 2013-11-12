/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vincetn
 */
public class ControllerTest extends TestCase {

    public ControllerTest() {

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

    @Test
    public void testgetInstance() {
        assertNotNull("Controller instance not null", Controller.getInstance());
    }

    @Test
    public void testaddUserToDirectory() {
        String ipSource = "127.0.0.1";
        String userId = "123";
        try {
            Controller.getInstance().addUserToDirectory(ipSource, userId);
            assertTrue("Add user to the directory OK!", true);

            Controller.getInstance().addUserToDirectory(ipSource, userId);
            fail();
        } catch (Exception ex) {
            assertTrue("Add user in double, exception thrown!", true);
        }
    }

    @Test
    public void testgetUserFromDirectory() {
        String userId = "123";
        try {
            Controller.getInstance().getUserIpFromDirectory(userId);
            assertTrue("Get user from the directory OK!", true);

            userId =  Integer.toString(Integer.MAX_VALUE);
            Controller.getInstance().getUserIpFromDirectory(userId);
            fail();
        } catch (Exception ex) {
            assertTrue("Get unknown userId from the directory OK!", true);
        }
    }
    
    @Test
    public void testremoveUserFromDirectory() {
        String userId = "123";
        try {
            Controller.getInstance().removeUserFromDirectory(userId);
            assertTrue("Add user to the directory OK!", true);

            Controller.getInstance().removeUserFromDirectory(userId);
            fail();
        } catch (Exception ex) {
            assertTrue("Add user in double, exception thrown!", true);
        }
    }
}
