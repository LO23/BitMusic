/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.profile.classes.User;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vincetn
 */
public final class TestTools {

    private TestTools() {}

    /**
     * Generate a Map of values needed to set up a new user.
     * @return a map of values
     */
    public static Map<String,Object> getUserValues() {
        final Map<String,Object> values = new HashMap();
        final Calendar birth = Calendar.getInstance();
        birth.set(2000, 01, 01, 0, 0, 0);
        values.put("login", "loginTest");
        values.put("password", "passwordTest");
        values.put("first", "firstNameTest");
        values.put("last", "lastNameTest");
        // 01/01/2000 + {ext} milliseconds
        values.put("birth", birth);
        values.put("path", "pathTest");
        return values;
    }

    /**
     * Generate a Map of values needed to set up a new user.
     * @param ext added to fields values (except birth)
     * @return a map of values
     */
    public static Map<String,Object> getUserValues(final String ext) {
        final Map<String,Object> values = new HashMap();
        final Calendar birth = Calendar.getInstance();
        birth.set(2000, 01, 01, 0, 0, 0);
        values.put("login", "loginTest"+ext);
        values.put("password", "passwordTest"+ext);
        values.put("first", "firstNameTest"+ext);
        values.put("last", "lastNameTest"+ext);
        values.put("birth", birth);
        values.put("path", "pathTest"+ext);
        return values;
    }

    public static User getDefaultUser() {
        return getDefaultUser(getUserValues());
    }

    public static User getDefaultUser(final String ext) {
        return getDefaultUser(getUserValues(ext));
    }

    private static User getDefaultUser(final Map<String,Object> values) {
        return new User(
                (String)values.get("login"),
                (String)values.get("password"),
                (String)values.get("first"),
                (String)values.get("last"),
                (Calendar)values.get("birth"),
                (String)values.get("path"));
    }

    /**
     * Compare two users and return true if equals.
     * Throw a TestException if not equals with reason as message
     * @param usr1
     * @param usr2
     * @return true if equals
     * @throws TestException if not equals with reason as message
     */
    public static boolean areUserEqual(final User usr1, final User usr2) throws TestException  {
        if (!usr1.getLogin().equals(usr2.getLogin())) {
            throw new TestException("Logins not equals");
        }
        if (!usr1.getFirstName().equals(usr2.getFirstName())) {
            throw new TestException("First names not equals");
        }
        if (!usr1.getLastName().equals(usr2.getLastName())) {
            throw new TestException("Last names not equals");
        }
        if (!usr1.getBirthDate().equals(usr2.getBirthDate())) {
            throw new TestException("Birth dates not equals");
        }
        if (!usr1.getAvatarPath().equals(usr2.getAvatarPath())) {
            throw new TestException("Avatar paths not equals");
        }
        return true;
    }
}
