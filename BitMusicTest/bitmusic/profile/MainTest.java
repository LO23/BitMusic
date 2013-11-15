/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

import bitmusic.profile.saving.*;

/**
 *
 * @author Holywa
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("Testing profile");
        UserSaverTest test = new UserSaverTest();
        test.testSaveUser();
        test.testSaveAuthFile();
    }
}
