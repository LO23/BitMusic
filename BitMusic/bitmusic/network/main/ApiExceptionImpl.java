/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.exception.EnumTypeException;
import bitmusic.network.exception.ExceptionFactory;
import bitmusic.network.exception.NetworkException;

/**
 *
 * @author florian
 */
public class ApiExceptionImpl {
    /**
    * Singleton implementation.
    */
    private static final ApiExceptionImpl APIEXCEPTIONIMPL =
            new ApiExceptionImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiExceptionImpl() { }

    /**
     * .
     * @return Unique instance of ApiExceptionImpl
     */
    protected static ApiExceptionImpl getInstance() {
        return APIEXCEPTIONIMPL;
    }

    /**
     * .
     * @param type
     * @param msg
     * @throws Exception
     */
    public final void throwException(final EnumTypeException type, final String msg)
            throws NetworkException {
        throw ExceptionFactory.createException(type, msg);
    }
}
