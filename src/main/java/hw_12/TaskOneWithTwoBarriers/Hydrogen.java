package hw_12.TaskOneWithTwoBarriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Hydrogen extends Thread {
    CyclicBarrier startCyclicBarrier;
    CyclicBarrier endCyclicBarrier;

    public Hydrogen(CyclicBarrier startCyclicBarrier, CyclicBarrier endCyclicBarrier) {
        super("H");
        this.startCyclicBarrier = startCyclicBarrier;
        this.endCyclicBarrier = endCyclicBarrier;
    }

    public void releaseHydrogen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        try {
            startCyclicBarrier.await();
            releaseHydrogen();
            endCyclicBarrier.await();

        } catch (InterruptedException | BrokenBarrierException ex) {
            return;
        }
    }
}