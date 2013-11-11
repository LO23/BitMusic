/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractModel implements Observable {

    private ArrayList<Observer> listObserver = new ArrayList<>();

    public AbstractModel() {

    }

    public ArrayList<Observer> getObserver(String observerClass) {
        ArrayList<Observer> matches = new ArrayList<>();

        Iterator<Observer> iterator = this.listObserver.iterator();
        while (iterator.hasNext()) {
            Observer current = iterator.next();
            if (current.getClass().getSimpleName().equals(observerClass)) {
                matches.add(current);
            }
        }
        return matches;
    }

    public void removeObserver(Observer observer) {
        this.listObserver.remove(observer);
    }

    //Implémentation du pattern observer (fonctions communes à tous les models)
    public void addObserver(Observer observer) {
        this.listObserver.add(observer);
    }

    public void notifyObserver(String str) {
        for (Observer observer : listObserver) {
             observer.update(this, str);
        }
    }

    public void removeAllObserver() {
        listObserver = new ArrayList<>();
    }
}
