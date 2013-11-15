/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

/**
 *
 * @author florian
 */
public abstract class AbstractManageable implements Runnable {
    /**
     * This method is implemented in classes which
     * inherit from AbstractManageable.
     */
    @Override
    public abstract void run();
}
