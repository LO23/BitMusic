/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.exception;

/**
 *
 * @author florian
 */
public final class NetworkDirectoryException extends NetworkException {
    /**
     * Constructs a new exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized
     * by a call to Throwable.initCause(java.lang.Throwable).
     * @param message The detail message. The detail message is saved for
     * later retrieval by the Throwable.getMessage() method.
     */
    public NetworkDirectoryException(final String message) {
        super("[package:network] Directory error " + message);
    }
}
