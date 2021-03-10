package hw_12.TaskOneWithTwoBarriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Oxygen extends Thread {
    CyclicBarrier startCyclicBarrier;
    CyclicBarrier endCyclicBarrier;

    public Oxygen(CyclicBarrier startCyclicBarrier, CyclicBarrier endCyclicBarrier) {
        super("O");
        this.startCyclicBarrier = startCyclicBarrier;
        this.endCyclicBarrier = endCyclicBarrier;
    }

    public void releaseOxygen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        try {
            startCyclicBarrier.await();
            releaseOxygen();
            endCyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            return;
        }
    }
}
