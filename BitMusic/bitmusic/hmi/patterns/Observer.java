/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.patterns;

/**
 *
 * @author IHM
 */
public interface Observer {

    /**
     * 
     * @param obj
     * @param str
     */
    public void update(Observable obj, String str);
}
