package org.miage.memoire.thread;

/**
 * This exception is raised if there's an error on a thread pool.
 * @author Guillaume Humbert
 */
public final class ThreadPoolException extends Exception {

    /**
     * Serialization identifier.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructeur.
     * @param message The message of the exception.
     */
    public ThreadPoolException(final String message) {
        super(message);
    }
    
}
