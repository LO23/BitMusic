/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.patterns;

import java.util.ArrayList;
import hmi.patterns.Observable;
import hmi.patterns.Observer;

/**
 *
 * @author hebergui, unkedeuxke
 */
public abstract class AbstractModel implements Observable {
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

        //Implémentation du pattern observer
        public void addObserver(Observer obs) {
            this.listObserver.add(obs);
        }

        public void notifyObserver() {

        }

        public void removeObserver() {
            listObserver = new ArrayList<Observer>();
        }  
}
