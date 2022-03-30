package unam.ciencias.computoconcurrente;
import java.util.concurrent.Semaphore;

public class Chopstick {
    public Semaphore mutex = new Semaphore(1);
    //the method grabs the chopstick
    void grab()
    {
        try
        {
//acquires a permit from the semaphore
            mutex.acquire();
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }
    //release the chopstick
    void release()
    {
//releases an acquire a permit and increases the number of available permits by one
        mutex.release();
    }
    //checks if the chopstick is free or not
    boolean isFree()
    {
//the method returns the current number of permits available in the semaphore
//returns true if available permits is greater than 0, else returns false
        return mutex.availablePermits() > 0;
    }
}
