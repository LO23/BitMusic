/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

import bitmusic.profile.saving.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holywa
 */
public class MainTest {
    public static void main(String[] args) {
        FileSaverTest test = new FileSaverTest();
        try {
            test.testSaveUser();
            test.testSaveAuthFile();
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileParserTest parseTest = new FileParserTest();
        try {
            parseTest.testLoadUser();
        } catch (Exception ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
