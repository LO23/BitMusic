/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.mainwindow;

import bitmusic.hmi.patterns.Observable;
import bitmusic.hmi.patterns.Observer;
import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowModel extends Observable {

    private ArrayList<Observer> listObservers = new ArrayList<>();

    public WindowModel() {

    }

    // Implémentation du design pattern Observer
    public void addObserver(Observer obs) {
        this.listObservers.add(obs);
    }

    public void removeObserver(Observer obs) {
        this.listObservers.remove(obs);
    }

    public void removeAllObservers() {
        this.listObservers = new ArrayList<>();
    }

    public void notifyObservers(String str) {
        for (Observer obs:this.listObservers) {
            obs.update(this, str);
        }
    }
}
