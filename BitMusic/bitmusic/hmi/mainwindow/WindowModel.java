/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.mainwindow;

import hmi.patterns.Observable;
import hmi.patterns.Observer;
import java.util.ArrayList;

/**
 *
 * @author hebergui, unkedeuxke
 */
class WindowModel implements Observable {

    private ArrayList<Observer> listObserver = new ArrayList<>();
    
    public WindowModel() {
        
    }

    //Implémentation du pattern observer
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    public void notifyObserver() {

    }

    public void removeObserver() {
        
    }
}
