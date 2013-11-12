/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.patterns.AbstractModel;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class ConnectionModel extends AbstractModel {

    public ConnectionModel() {
        super();
    }

    // A IMPLEMENTER !!!!! VERIFIER SI LA CONNECTION EST VALIDE SINON RETOURN FALSE
    public boolean doConnection() {
        return true;
    }
}
