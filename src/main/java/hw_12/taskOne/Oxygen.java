package hw_12.taskOne;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Oxygen extends Thread {
    CyclicBarrier cyclicBarrier;

    public Oxygen(CyclicBarrier cyclicBarrier) {
        super("O");
        this.cyclicBarrier = cyclicBarrier;
    }

    public void releaseOxygen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            releaseOxygen();
        } catch (InterruptedException | BrokenBarrierException ex) {
            return;
        }
    }
}
