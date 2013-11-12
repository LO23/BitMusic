/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.exception;

/**
 * Class that implements the factory design pattern,
 * which will provide an easy way to create
 * different kind of exception.
 * @author florian
 */

public final class ExceptionFactory {
    /**
     * The only instance of the MessageFactory class.
     */
    private static ExceptionFactory INSTANCE = new ExceptionFactory();

    /**
     * The method that returns the instance of the class.
     * @return The only instance of the MessageFactory class.
     */
    public static ExceptionFactory getInstance() {
         return ExceptionFactory.INSTANCE;
     }

    /**
     * The object constructor.
     */
    private ExceptionFactory() {

    }

    /**
     * Function provided to easily create different kind of exceptions.
     * @param type : Type of the message we want.
     * @return The newly created message.
     */
    public static Exception createException(final EnumTypeException type,
            final String message) {
        Exception exception = null;
        switch (type) {
            case NetworkDirectoryException :
                exception =  new NetworkDirectoryException(message);
                break;
            default :
                break;
        }
        return exception;
    }
}
