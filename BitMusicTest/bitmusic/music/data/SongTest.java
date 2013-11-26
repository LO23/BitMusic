/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MB
 */
public class SongTest {
    
    public SongTest() {
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
     * Test of addComment method, of class Song.
     */
    @Test
    public void testAddComment() {
        System.out.println("addComment");
        Comment comment = new Comment("Amina", "comment text");
        LinkedList listTag = new LinkedList<String>();
        listTag.add(new String("tag1"));
        listTag.add(new String("tag2"));
        Song instance = new Song("1", "titre", "artiste", "album", listTag);
        instance.addComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getComments().get(1),comment.getComment());
    }

    /**
     * Test of deleteComment method, of class Song.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("deleteComment");
        String authorId = "";
        Date date = null;
        Song instance = null;
        instance.deleteComment(authorId, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGrade method, of class Song.
     */
    @Test
    public void testAddGrade() {
        System.out.println("addGrade");
        Grade grade = null;
        Song instance = null;
        instance.addGrade(grade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGrade method, of class Song.
     */
    @Test
    public void testDeleteGrade() {
        System.out.println("deleteGrade");
        String authorId = "";
        Song instance = null;
        instance.deleteGrade(authorId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCategory method, of class Song.
     */
    @Test
    public void testUpdateCategory() {
        System.out.println("updateCategory");
        String categoryName = "";
        Rights rights = null;
        Song instance = null;
        instance.updateCategory(categoryName, rights);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCategory method, of class Song.
     */
    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory");
        String categoryName = "";
        Song instance = null;
        instance.deleteCategory(categoryName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSongId method, of class Song.
     */
    @Test
    public void testGetSongId() {
        System.out.println("getSongId");
        Song instance = null;
        String expResult = "";
        String result = instance.getSongId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Song.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Song instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Song.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Song instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArtist method, of class Song.
     */
    @Test
    public void testGetArtist() {
        System.out.println("getArtist");
        Song instance = null;
        String expResult = "";
        String result = instance.getArtist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlbum method, of class Song.
     */
    @Test
    public void testGetAlbum() {
        System.out.println("getAlbum");
        Song instance = null;
        String expResult = "";
        String result = instance.getAlbum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTags method, of class Song.
     */
    @Test
    public void testGetTags() {
        System.out.println("getTags");
        Song instance = null;
        LinkedList<String> expResult = null;
        LinkedList<String> result = instance.getTags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class Song.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Song instance = null;
        LinkedList<Comment> expResult = null;
        LinkedList<Comment> result = instance.getComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrades method, of class Song.
     */
    @Test
    public void testGetGrades() {
        System.out.println("getGrades");
        Song instance = null;
        HashMap<String, Grade> expResult = null;
        HashMap<String, Grade> result = instance.getGrades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwnerId method, of class Song.
     */
    @Test
    public void testGetOwnerId() {
        System.out.println("getOwnerId");
        Song instance = null;
        String expResult = "";
        String result = instance.getOwnerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalRights method, of class Song.
     */
    @Test
    public void testGetLocalRights() {
        System.out.println("getLocalRights");
        Song instance = null;
        Rights expResult = null;
        Rights result = instance.getLocalRights();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRightsByCategory method, of class Song.
     */
    @Test
    public void testGetRightsByCategory() {
        System.out.println("getRightsByCategory");
        Song instance = null;
        HashMap<String, Rights> expResult = null;
        HashMap<String, Rights> result = instance.getRightsByCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasTag method, of class Song.
     */
    @Test
    public void testHasTag() {
        System.out.println("hasTag");
        List<String> tagList = null;
        Song instance = null;
        boolean expResult = false;
        boolean result = instance.hasTag(tagList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
