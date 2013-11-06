/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.EnumTypeException;
import bitmusic.network.exception.ExceptionFactory;

/**
 *
 * @author florian
 */
public class ApiExceptionImpl {
    /**
    * Singleton implementation.
    */
    private static final ApiExceptionImpl APIEXCEPTIONIMPL = new ApiExceptionImpl();

    /**
     * .
     * @return Unique instance of ApiExceptionImpl
     */
    protected static ApiExceptionImpl getInstance() {
        return APIEXCEPTIONIMPL;
    }


    public void throwException(EnumTypeException type, String msg) throws Exception {
        throw ExceptionFactory.getInstance().createException(type, msg);
    }
}
