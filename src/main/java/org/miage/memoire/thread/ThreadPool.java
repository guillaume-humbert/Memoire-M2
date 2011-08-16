package org.miage.memoire.thread;

/**
 * This class implements a simple thread pool.
 * @author Guillaume Humbert
 */
public final class ThreadPool implements ThreadListener {

    /**
     * The number of threads that are running simultaneously.
     */
    private int threadsNb;
    
    /**
     * The maximum number of threads that are allowed to run simultaneously.
     */
    private int maxThreads;
    
    /**
     * Default empty constructor.
     * @param maxThreads The maximum number of threads that are allowed to run
     * simultaneously.
     */
    public ThreadPool(final int maxThreads) {
        super();
        this.maxThreads = maxThreads;
    }
    
    /**
     * Runs a thread in the pool.
     * @param thread The thread to be runned.
     * @throws ThreadPoolException If the pool is full.
     */
    public synchronized void runThread(final SimpleThread thread)
        throws ThreadPoolException {
        
        thread.setListener(this);
        
        if (this.threadsNb < this.maxThreads) {
            thread.start();
            this.threadsNb += 1;
        } else {
            throw new ThreadPoolException("The thread cannot be runned: the "
                    + "pool is full.");
        }
    }
    
    @Override
    public synchronized void notifyJobCompleted() {
        this.threadsNb -= 1;
    }
    
}
