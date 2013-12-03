/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.saving;

import bitmusic.profile.classes.User;
import bitmusic.profile.utilities.ProfileExceptions;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
 * @author Holywa
 */
public class FileSaverTest {

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
     * Test of saveUser method, of class FileSaver.
     */
    @Test
    public void testSaveUser() throws IOException {
        User userToSave = new User("Olivia", "test");
        Calendar birth = GregorianCalendar.getInstance();
        birth.set(1990, 05, 02);
        try {
            userToSave.setBirthDate(birth);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(FileSaverTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileSaver.getFileSaver().saveUser(userToSave);
        }
        catch(ProfileExceptions e) {
            fail(e.toString());
        }
    }

    /**
     * Test of saveAuthFile method, of class FileSaver.
     */
    @Test
    public void testSaveAuthFile() throws IOException {
        User toAuth = new User("Olivia", "pwd");
        Calendar birth = GregorianCalendar.getInstance();
        birth.set(1990, 05, 02);
        try {
            toAuth.setBirthDate(birth);
        } catch (ProfileExceptions ex) {
            Logger.getLogger(FileSaverTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileSaver.getFileSaver().saveAuthFile(toAuth);
        }
        catch(ProfileExceptions e) {
            fail(e.toString());
        }
    }

}
