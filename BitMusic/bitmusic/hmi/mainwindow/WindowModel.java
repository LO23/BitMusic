/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.patterns.Observable;
import bitmusic.hmi.patterns.Observer;
import bitmusic.profile.classes.User;
import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowModel extends Observable {

    private ArrayList<Observer> listObservers = new ArrayList<>();

    public WindowModel() {

    }

    public void logOut() {
        // si on est connecté, alors on doit avertir les autres, sinon on ferme simplement l'application
        User currentUser = WindowComponent.getInstance().getApiProfile().getCurrentUser();
        if (currentUser != null) {
            String myId = currentUser.getUserId();
            // WindowComponent.getInstance().getApiNetwork().logOut(myId); // à décommenter dès que API Network en place
        }
        this.notifyObservers("LOGOUT");
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObservers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        this.listObservers.remove(obs);
    }

    @Override
    public void removeAllObservers() {
        this.listObservers = new ArrayList<>();
    }

    @Override
    public void notifyObservers(String str) {
        for (Observer obs:this.listObservers) {
            obs.update(this, str);
        }
    }
}
