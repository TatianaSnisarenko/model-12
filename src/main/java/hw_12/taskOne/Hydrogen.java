package hw_12.taskOne;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Hydrogen extends Thread {
    CyclicBarrier cyclicBarrier;

    public Hydrogen(CyclicBarrier cyclicBarrier) {
        super("H");
        this.cyclicBarrier = cyclicBarrier;

    }

    public void releaseHydrogen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            releaseHydrogen();

        } catch (InterruptedException | BrokenBarrierException ex) {
            return;
        }
    }
}