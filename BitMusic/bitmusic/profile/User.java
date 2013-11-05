/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author reaneyol
 */
public class User {
    private String userId;
    private String login;
    private String password;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String avatarPath;
    //private SongLibrary localSongs;
    private ArrayList<Category> categories;

    User(String login, String password, String firstName, String lastName, Date date, String avatarPath) throws ProfileExceptions {
        if(login == null) {
            throw new ProfileExceptions(0);
        }
        else if(password == null) {
            throw new ProfileExceptions(1);
        }

        this.login = login;
        this.password = this.cryptPassword(password);
        this.userId = UUID.randomUUID().toString();
    }

    private String cryptPassword(String password) {
        return "test";
    }

    @Override
    public String toString() {
        return "Login : " + this.login + "\nUserID : " + this.userId + "\n";
    }
}
