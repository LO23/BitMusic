/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractModel extends Observable {

    private ArrayList<Observer> listObservers = new ArrayList();

    /**
     *
     */
    public AbstractModel() {
    }

    /**
     *
     * @param obs
     */
    @Override
    public void addObserver(Observer obs) {
        this.listObservers.add(obs);
    }

    /**
     *
     * @param obs
     */
    @Override
    public void removeObserver(Observer obs) {
        this.listObservers.remove(obs);
    }

    /**
     *
     */
    @Override
    public void removeAllObservers() {
        this.listObservers = new ArrayList();
    }

    /**
     *
     * @param str
     */
    @Override
    public void notifyObservers(String str) {
        for (Observer obs:this.listObservers) {
            obs.update(this, str);
        }
    }
}
