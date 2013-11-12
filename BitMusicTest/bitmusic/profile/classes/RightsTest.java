/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

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
public class RightsTest {

    public RightsTest() {
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
     * Test of updateRights method, of class Rights.
     */
    @Test
    public void testUpdateRights() {
        System.out.println("updateRights");
        boolean canReadInfo = false;
        boolean canPlay = false;
        boolean canRate = false;
        boolean canComment = false;
        Rights instance = new Rights();
        instance.updateRights(canReadInfo, canPlay, canRate, canComment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcanPlay method, of class Rights.
     */
    @Test
    public void testGetcanPlay() {
        System.out.println("getcanPlay");
        Rights instance = new Rights();
        boolean expResult = false;
        boolean result = instance.getcanPlay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcanReadInfo method, of class Rights.
     */
    @Test
    public void testGetcanReadInfo() {
        System.out.println("getcanReadInfo");
        Rights instance = new Rights();
        boolean expResult = false;
        boolean result = instance.getcanReadInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcanRate method, of class Rights.
     */
    @Test
    public void testGetcanRate() {
        System.out.println("getcanRate");
        Rights instance = new Rights();
        boolean expResult = false;
        boolean result = instance.getcanRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcanComment method, of class Rights.
     */
    @Test
    public void testGetcanComment() {
        System.out.println("getcanComment");
        Rights instance = new Rights();
        boolean expResult = false;
        boolean result = instance.getcanComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setcanPlay method, of class Rights.
     */
    @Test
    public void testSetcanPlay() {
        System.out.println("setcanPlay");
        boolean canPlayValue = false;
        Rights instance = new Rights();
        instance.setcanPlay(canPlayValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setcanReadInfo method, of class Rights.
     */
    @Test
    public void testSetcanReadInfo() {
        System.out.println("setcanReadInfo");
        boolean canReadInfoValue = false;
        Rights instance = new Rights();
        instance.setcanReadInfo(canReadInfoValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setcanRate method, of class Rights.
     */
    @Test
    public void testSetcanRate() {
        System.out.println("setcanRate");
        boolean canRateValue = false;
        Rights instance = new Rights();
        instance.setcanRate(canRateValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setcanComment method, of class Rights.
     */
    @Test
    public void testSetcanComment() {
        System.out.println("setcanComment");
        boolean canCommentValue = false;
        Rights instance = new Rights();
        instance.setcanComment(canCommentValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
