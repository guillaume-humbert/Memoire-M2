package org.miage.memoire.thread;

/**
 * The main class that runs an example of the thread pool execution.
 * @author Guillaume Humbert
 */
public final class ThreadMain {

    /**
     * Default empty constructor.
     */
    private ThreadMain() {
        super();
    }
    
    /**
     * Main.
     * @param args Not used.
     */
    public static void main(final String[] args) {
        
        final int threadsNb = 5;
        final ThreadPool pool = new ThreadPool(2);
        
        final SimpleThread[] threads = new SimpleThread[threadsNb];
        
        for (int i = 0; i < threads.length; i += 1) {
            threads[i] = new SimpleThread();
            
            try {
                pool.runThread(threads[i]);
            } catch (ThreadPoolException e) {
                System.out.println(e.getMessage());
            }
        }
         
    }
    
}
