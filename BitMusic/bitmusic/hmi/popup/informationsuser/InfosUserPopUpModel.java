/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationsuser;

import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.profile.classes.User;

/**
 * Model class of InfosUserPopUp
 * @author IHM
 */
public final class InfosUserPopUpModel extends AbstractModel {

    private User user;

    /**
     * Constructor of InfosUserPopUpModel
     * @param user
     */
    public InfosUserPopUpModel(User user) {
        super();
        this.setUser(user);
    }

    /**
     * Returns the user
     * @return User user
     */
    public User getUser() {
        return user;
    }

    /**
     * Updates user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
        this.notifyObservers("SET_USER_INFOS");
    }

}
