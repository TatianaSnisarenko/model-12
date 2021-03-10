package hw_12.TaskOneWithSemaphore;

import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {
    Semaphore semaphore;

    public Oxygen(Semaphore semaphore) {
        super("O");
        this.semaphore = semaphore;
    }

    public void releaseOxygen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            releaseOxygen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}