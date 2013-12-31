/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

import java.util.ArrayList;

/**
 * Class of abstract model
 * @author IHM
 */
public abstract class AbstractModel extends Observable {

    private ArrayList<Observer> listObservers = new ArrayList();

    /**
     * Constructor of AbstractModel
     */
    public AbstractModel() {
    }

    /**
     * Adds an observer
     * @param obs
     */
    @Override
    public void addObserver(Observer obs) {
        this.listObservers.add(obs);
    }

    /**
     * Deletes observer
     * @param obs
     */
    @Override
    public void removeObserver(Observer obs) {
        this.listObservers.remove(obs);
    }

    /**
     * Deletes all the observers
     */
    @Override
    public void removeAllObservers() {
        this.listObservers = new ArrayList();
    }

    /**
     * Notifies all the observers
     * @param str
     */
    @Override
    public void notifyObservers(String str) {
        for (Observer obs:this.listObservers) {
            obs.update(this, str);
        }
    }
}
