package org.miage.memoire.thread;

/**
 * This thread just wait 5 seconds and terminates its job.
 * @author Guillaume Humbert
 */
public final class SimpleThread extends Thread {

    /**
     * The job duration of this thread.
     */
    private static final long TIMEOUT = 5000;
    
    /**
     * A class that wants to listen the events produced by this thread.
     */
    private ThreadListener listener;
    
    /**
     * Default empty constructor.
     */
    public SimpleThread() {
        super();
    }
    
    @Override
    public void run() {
        
        try {
            Thread.sleep(SimpleThread.TIMEOUT);
        } catch (InterruptedException e) {
            System.out.println(this.getId() + ": Job interrupted.");
        }
        
        if (this.listener != null) {
            this.listener.notifyJobCompleted();
        }
        
        System.out.println(this.getId() + ": Job completed.");
    }
    
    /**
     * Setter on the 'listener' attribute.
     * @param listener A class that wants to listen the events produced by this
     * thread.
     */
    public void setListener(final ThreadListener listener) {
        this.listener = listener;
    }
}
