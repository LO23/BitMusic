/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.api;

import bitmusic.network.exception.EnumTypeException;

/**
 *
 * @author florian
 */
public interface ApiException {
    public void throwException(EnumTypeException type, String msg);
}
