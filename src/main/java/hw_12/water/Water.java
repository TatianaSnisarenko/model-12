package hw_12.water;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {
    private final CyclicBarrier cyclicBarrier;
    private final Semaphore oxygenSemaphore;
    private final Semaphore hydrogenSemaphore;

    public Water(){
        cyclicBarrier = new CyclicBarrier(3);
        oxygenSemaphore = new Semaphore(1);
        hydrogenSemaphore = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException{
        hydrogenSemaphore.acquire();
        try{
            cyclicBarrier.await();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
        releaseHydrogen.run();
        hydrogenSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException{
        oxygenSemaphore.acquire();
        try{
            cyclicBarrier.await();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
        releaseOxygen.run();
        oxygenSemaphore.release();
    }
}
