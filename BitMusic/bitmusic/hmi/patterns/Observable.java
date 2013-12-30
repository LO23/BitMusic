/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 * Class of Observable
 * @author IHM
 */
public abstract class Observable {

    /**
     * Adds an observer
     * @param obs
     */
    public abstract void addObserver(Observer obs);

    /**
     * Deletes an observer
     * @param obs
     */
    public abstract void removeObserver(Observer obs);

    /**
     * Deletes all the observers
     */
    public abstract void removeAllObservers();

    /**
     * Notifies the observers
     * @param str
     */
    public abstract void notifyObservers(String str);
}
