package org.miage.memoire.thread;

/**
 * This interface defines the methods that a listener on a thread must
 * implement.
 * @author Guillaume Humbert
 */
public interface ThreadListener {

    /**
     * Called when a thread has completed its job.
     */
    void notifyJobCompleted();
    
}
