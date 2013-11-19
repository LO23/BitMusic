/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.profile.classes.User;
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
public class ApiProfileImplTest extends NetworkingTest {

    private transient final ThreadManager threadManager
            = Controller.getInstance().getThreadManager();

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
        this.resetSocket();
    }

    @After
    public void tearDown() {
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
        //User result = instance.getUser(userId);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyNewConnection method, of class ApiProfileImpl.
     */
    @Test
    public void testNotifyNewConnection() {
        System.out.println("notifyNewConnection");
        // création d'un user lamba
        final User user = new User("testLogin", "testPwd", "firstName",
                "lastName", null, "/Path/avatar.png");

        final ApiProfileImpl instance = Controller.getInstance().getApiProfile();

        // le test "s'abonne" au threadmanager,
        // il attendra que celui-ci le reveille (reception d'une socket)
        this.threadManager.suscribe(this);

        // Appel de la fonction à tester
        instance.notifyNewConnection(user);

        // attente de la socket en retour
        this.waitForSocket();

        // decodage de la socket
        final AbstractMessage message = this.readMessageFromSocket();

        if(message == null) {
            fail("null message found");
        }

        assertEquals("Type du Message incohérent",
                EnumTypeMessage.NotifyNewConnection, message.getType());
    }


}
