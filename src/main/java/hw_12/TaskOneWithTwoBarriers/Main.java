package hw_12.TaskOneWithTwoBarriers;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {

        List<Thread> threadList = new CopyOnWriteArrayList<>();
        CyclicBarrier startCyclicBarrier = new CyclicBarrier(4);
        CyclicBarrier endCyclicBarrier = new CyclicBarrier(4);
        final int countOfOxygen = 6;
        final int countOfHydrogen = countOfOxygen * 2;

        for (int i = 0; i < countOfOxygen; i++) {
            threadList.add(new Oxygen(startCyclicBarrier, endCyclicBarrier));
        }

        for (int i = 0; i < countOfHydrogen; i++) {
            threadList.add(new Hydrogen(startCyclicBarrier, endCyclicBarrier));
        }
        while (threadList.size() > 0) {
            Objects.requireNonNull(ThreadUtils.getOxygenThread(threadList)).start();
            Objects.requireNonNull(ThreadUtils.getHydrogenThread(threadList)).start();
            Objects.requireNonNull(ThreadUtils.getHydrogenThread(threadList)).start();
            try {
                startCyclicBarrier.await();
                endCyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
