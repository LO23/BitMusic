/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class Observable {
    public abstract void addObserver(Observer obs);
    public abstract void removeObserver(Observer obs);
    public abstract void removeAllObservers();
    public abstract void notifyObservers(String str);
}
