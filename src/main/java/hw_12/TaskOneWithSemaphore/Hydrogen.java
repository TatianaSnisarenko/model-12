package hw_12.TaskOneWithSemaphore;

import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {
    Semaphore semaphore;

    public Hydrogen(Semaphore semaphore) {
        super("H");
        this.semaphore = semaphore;
    }

    public void releaseHydrogen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            releaseHydrogen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}