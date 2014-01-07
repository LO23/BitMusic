/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.AbstractMessage;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageGetUser;
import bitmusic.network.message.MessageNotifyNewConnection;
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
    private final ApiProfileImpl api = Controller.getInstance().getApiProfile();

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
    @Test
    public void testGetInstance() {
        assertNotNull("(Singleton) Instance not created",
                ApiProfileImpl.getInstance());
    }

    /**
     * Test of getUser method, of class ApiProfileImpl.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        // le test "s'abonne" au threadmanager,
        // il attendra que celui-ci le reveille (reception d'une socket)
        this.threadManager.suscribe(this);


        // ### adding me to directory
        final User me = TestTools.getDefaultUser("me");
        MessageNotifyNewConnection msg = new MessageNotifyNewConnection(
                EnumTypeMessage.NotifyNewConnection,
                "127.0.0.1", // ip source
                "1.1.1.1", // ip dest
                me,
                true);
        // send message to add a user
        threadManager.assignTaskToHermes(msg);
        waitForSocket();
        // deal with msg received
        // should add usr to directory
        threadManager.endTest();
        threadManager.assignTaskToWorker(getSocketReceived());
        threadManager.prepareForTest();
        this.resetSocket();


        // ### adding a user to directory
        final User initUser = TestTools.getDefaultUser();
        msg = new MessageNotifyNewConnection(
                EnumTypeMessage.NotifyNewConnection,
                "127.0.0.1", // ip source
                "2.2.2.2", // ip dest
                initUser,
                true);
        // send message to add a user
        threadManager.assignTaskToHermes(msg);
        waitForSocket();
        // deal with msg received
        // should add usr to directory
        threadManager.endTest();
        threadManager.assignTaskToWorker(getSocketReceived());
        threadManager.prepareForTest();
        this.resetSocket();


        final String research = "1";
        // ### Testing the function
        try {
            System.out.println(me.getUserId()+" # "+initUser.getUserId());
            api.getUser(me.getUserId(), initUser.getUserId(), research);
        } catch (NetworkException ex) {
            fail(ex.getMessage());
        }

        waitForSocket();

        final AbstractMessage message = this.readMessageFromSocket();
        assertEquals("Invalid message type",
                EnumTypeMessage.GetUser, message.getType());

        // comp with me
        assertEquals("Invalid operator user_id",
                me.getUserId(), ((MessageGetUser)message).getOperator());

        // comp with askedUser
        assertEquals("Invalid AskedUser user_id",
                initUser.getUserId(), ((MessageGetUser)message).getAskedUser());

        // comp with research_id
        assertEquals(research, ((MessageGetUser)message).getResearchId());


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
        // création d'un user lamba
        final User userInit = TestTools.getDefaultUser();

        // le test "s'abonne" au threadmanager,
        // il attendra que celui-ci le reveille (reception d'une socket)
        this.threadManager.suscribe(this);

        // Appel de la fonction à tester
        //api.notifyNewConnection(userInit);

        // attente de la socket en retour
        this.waitForSocket();

        // decodage de la socket
        final AbstractMessage message = this.readMessageFromSocket();

        if(message == null) {
            fail("null message found");
        }
        // verif type message
        assertEquals("Type du Message incohérent",
                EnumTypeMessage.NotifyNewConnection, message.getType());
        // recupération de l'user dans le
        final User userFinal = ((MessageNotifyNewConnection)message).getUser();
        // verif champs par champs
        try {
            TestTools.areUserEqual(userInit, userFinal);
        } catch (TestException ex) {
            fail(ex.getMessage());
        }

        // verif password vide suite à transmission
        assertNull("Password should be empty", userFinal.getPassword());
    }


}
