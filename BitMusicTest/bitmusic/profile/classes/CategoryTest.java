/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile.classes;

import bitmusic.music.data.Rights;
import bitmusic.profile.utilities.ProfileExceptions;
import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frogerfa, Nico
 */
public class CategoryTest {
    Category cat = new Category("famille");

    public CategoryTest() {
        Category cat = new Category("famille");
    }

    @Before
    public void setUp() {
        //System.out.println("Before : " + cat.getName());
    }

    @After
    public void tearDown() {
        //System.out.println("After : " + cat.getName());
    }
/**
     * Test of setName method, of class Category.
     */
    @Test
    public void testSetName() throws ProfileExceptions{
        System.out.println("setName");
        String newName = "newName";
        cat.setName(newName);
        assertEquals(newName, cat.getName());
    }
    
    /**
     * @throws ProfileExceptions
     */

    @Test(expected = ProfileExceptions.class)
    public void testSetNameNullName() throws ProfileExceptions {
        System.out.println("setName");
        String name = null;
        cat.setName(name);
    }
    
    /**
     * @throws ProfileExceptions
     */

    @Test(expected = ProfileExceptions.class)
    public void testSetNameEmptyName() throws ProfileExceptions {
        System.out.println("setName");
        String name = "";
        cat.setName(name);
    }

    /**
     * Test of getName method, of class Category.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("famille", cat.getName());
    }

    /**
     * Test of getContacts method, of class Category.
     */
    @Test
    public void testGetContacts()  throws ProfileExceptions{
        System.out.println("getContacts");
        User test1 = new User("login1","mdp1");
        User test2 = new User("login2","mdp2");
        
        ArrayList<User> expResult = new ArrayList<User>();
        expResult.add(test1);
        expResult.add(test2);
        
        cat.addUser(test1);
        cat.addUser(test2);
        
        assertEquals(expResult, cat.getContacts());
    }

    /**
     * Test of setContacts method, of class Category.
     */
    @Test
    public void testSetContacts() {
        System.out.println("setContacts");
        User test1 = new User("login1","mdp1");
        User test2 = new User("login2","mdp2");
        
        ArrayList<User> expResult = new ArrayList<User>();
        expResult.add(test1);
        expResult.add(test2);
        
        cat.setContacts(expResult);
        
        assertEquals(expResult, cat.getContacts());
    }

    /**
     * Test of getRight method, of class Category.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        
        Rights expResult = new Rights(true, true, true, true);

        assertEquals(expResult, cat.getRight());
    }

    /**
     * Test of updateRight method, of class Category.
     */
    @Test
    public void testUpdateRight() {
        System.out.println("updateRight");
        Rights test = new Rights(true, false, false, false);
        cat.updateRight(true, false, false, false);
        assertEquals(test,cat.getRight());
    }

    /**
     * Test of addUser method, of class Category.
     */
    @Test
    public void testAddUser()  throws ProfileExceptions{
        List<User> liste = new ArrayList<User> (cat.getContacts());
        User test = new User("login", "mdp");
        cat.addUser(test);
        liste.add(test);
        assertEquals(liste,cat.getContacts());
    }

    /**
     * Test of deleteUser method, of class Category.
     */
    @Test
    public void testDeleteUser() throws ProfileExceptions {
        System.out.println("deleteUser");
        
        User test1 = new User("login1","mdp1");
        User test2 = new User("login2","mdp2");
        
        ArrayList<User> expResult = new ArrayList<User>();
        expResult.add(test1);
        
        cat.setContacts(expResult);
        cat.addUser(test2);
        cat.deleteUser(test2);
        
        assertEquals(expResult, cat.getContacts());
    }

    /**
     * Test of findContact method, of class Category.
     */
    @Test
    public void testFindContact() throws ProfileExceptions {
        System.out.println("findContact");
        String UserID = "test1";
        
        User test1 = new User("login1","mdp1");
        User test2 = new User("login2","mdp2");
        
        ArrayList<User> expResult = new ArrayList<User>();
        expResult.add(test1);
        expResult.add(test2);
        
        cat.setContacts(expResult);
        
        assertEquals(test1, cat.findContact(test1.getUserId()));
    }
    
}