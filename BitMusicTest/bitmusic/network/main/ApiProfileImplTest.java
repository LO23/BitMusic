/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkException;
import bitmusic.profile.classes.User;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vincetn
 */
public class ApiProfileImplTest {

    public ApiProfileImplTest() { }

    @BeforeClass
    public static void setUpClass() {
        Controller.getInstance().prepareForTest();
    }

    @AfterClass
    public static void tearDownClass() {
        Controller.getInstance().endTest();
    }

    @Before
    public void setUp() {
        System.out.println("###########################");
        System.out.println("##      START  TEST      ##");
    }

    @After
    public void tearDown() {
        System.out.println("##       END  TEST       ##");
        System.out.println("###########################");
    }

    /**
     * Test of getInstance method, of class ApiProfileImpl.
     */
    @Ignore("useless")
    @Test
    public void testGetInstance() {
    }

    /**
     * Test of getUser method, of class ApiProfileImpl.
     */
    @Ignore("TODO")
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String userId = "";
        ApiProfileImpl instance = null;
        User expResult = null;
        User result = instance.getUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyNewConnection method, of class ApiProfileImpl.
     */
    @Test
    public void testNotifyNewConnection() throws NetworkException {
        System.out.println("notifyNewConnection");
        final User user = new User("testLogin", "testPwd", "firstName", "lastName",
                new Date(System.currentTimeMillis()), "/Path/avatar.png");

        final ApiProfileImpl instance = Controller.getInstance().getApiProfile();
        instance.notifyNewConnection(user);
        try {
            wait(200);
        } catch (InterruptedException ex) {
            fail("InterruptedException Raised : "+ex.getMessage()
                    +" \n-----\nStackTrace :"+ex.getStackTrace().toString());
        }
        assertTrue(true);
    }

}
