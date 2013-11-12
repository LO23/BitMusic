/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;

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
public class UserSaverTest {

    public UserSaverTest() {
        this.testSaveUser();
        this.testSaveAuthFile();
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
     * Test of saveUser method, of class UserSaver.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        UserSaver instance = new UserSaver();
        User userToSave = new User("Olivia", "test");
        try {
            instance.saveUser(userToSave);
        }
        catch(ProfileExceptions e) {
            switch(e.getType()) {
                case CreationFileError:
                    fail("Error occured while creating the file");
                    break;
                case WritingFileError:
                    fail("Error occured while writing in file");
                    break;
                default :
                    fail("Problem from Profile occured");
                    break;
            }
        }
    }

    /**
     * Test of saveAuthFile method, of class UserSaver.
     */
    @Test
    public void testSaveAuthFile() {
        System.out.println("saveAuthFile");

        User toAuth = new User("Olivia", "pwd");

        UserSaver instance = new UserSaver();

        try {
        instance.saveAuthFile(toAuth);
        }
        catch(ProfileExceptions e) {
            switch(e.getType()) {
                case CreationFileError:
                    fail("test");
                    break;
                case WritingFileError:
                    fail("prout");
                    break;
                default :
                    fail("dead");
                    break;
            }
        }
    }

}
