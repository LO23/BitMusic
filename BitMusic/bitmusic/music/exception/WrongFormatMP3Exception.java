/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.exception;

 /**
 * Class which allows to manage exception when a user import a file which is not a mp3.
 * @author Jean-Baptiste
 */
public class WrongFormatMP3Exception extends Exception{
    
    /**
     * Constructs a new exception with null as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to Throwable.initCause(java.lang.Throwable).
     */
    public WrongFormatMP3Exception() {
        super();
    }
    
    /**
     * Constructs a new exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized
     * by a call to Throwable.initCause(java.lang.Throwable).
     * @param message The detail message. The detail message is saved for
     * later retrieval by the Throwable.getMessage() method.
     */
    public WrongFormatMP3Exception(final String message) {
        super(message);
    }
    
    /**
     * Constructs a new exception with the specified detail message
     * and cause.
     * @param message the detail message (which is saved for later retrieval
     * by the Throwable.getMessage() method).
     * @param cause The cause (which is saved for later retrieval by the
     * Throwable.getCause() method). (A null value is permitted, and indicates
     * that the cause is nonexistent or unknown.)
     */
    public WrongFormatMP3Exception(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new exception with the specified cause and a
     * detail message of (cause==null ? null : cause.toString())
     * (which typically contains the class and detail message of cause).
     * @param cause The cause (which is saved for later retrieval by the
     * Throwable.getCause() method). (A null value is permitted, and indicates
     * that the cause is nonexistent or unknown.)
     */
    public WrongFormatMP3Exception(final Throwable cause) {
        super(cause);
    }
}
