/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jib
 */
public class SongLibraryTest {
    
    public SongLibraryTest() {
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
     * Test of getlibrary method, of class SongLibrary.
     */
    @Test
    public void testGetlibrary() {
        System.out.println("getlibrary");
        SongLibrary instance = new SongLibrary();
  //      LinkedList<String> testListe = new LinkedList<String>();
 //       Song testSong = new Song("maChanson","LO23","monArtist","monAlbum",testListe);
  //      instance.addSong(testSong);
        
        ArrayList<Song> expResult = new ArrayList<Song>();
  //      expResult.add(testSong);
        ArrayList<Song> result = instance.getlibrary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of setlibrary method, of class SongLibrary.
     */
    @Test
    public void testSetlibrary() {
        System.out.println("setlibrary");
        ArrayList<Song> lib = null;
        SongLibrary instance = new SongLibrary();
        instance.setlibrary(lib);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of islocal method, of class SongLibrary.
     */
    @Test
    public void testIslocal() {
        System.out.println("islocal");
        String songId = "";
        SongLibrary instance = new SongLibrary();
        boolean expResult = false;
        boolean result = instance.islocal(songId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSong method, of class SongLibrary.
     */
    @Test
    public void testGetSong() {
        System.out.println("getSong");
        String songId = "";
        SongLibrary instance = new SongLibrary();
        Song expResult = null;
        Song result = instance.getSong(songId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSong method, of class SongLibrary.
     */
    @Test
    public void testRemoveSong() {
        System.out.println("removeSong");
        String songId = "";
        SongLibrary instance = new SongLibrary();
        instance.removeSong(songId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSong method, of class SongLibrary.
     */
    @Test
    public void testAddSong() {
        System.out.println("addSong");
        Song song = null;
        SongLibrary instance = new SongLibrary();
        instance.addSong(song);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCategory method, of class SongLibrary.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String name = "";
        Rights rights = null;
        SongLibrary instance = new SongLibrary();
        instance.addCategory(name, rights);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCategory method, of class SongLibrary.
     */
    @Test
    public void testRemoveCategory() {
        System.out.println("removeCategory");
        String name = "";
        SongLibrary instance = new SongLibrary();
        instance.removeCategory(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
