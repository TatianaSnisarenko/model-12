package hw_12.taskOne;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {

        List<Thread> threadList = new CopyOnWriteArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        final int countOfOxygen = 3;
        final int countOfHydrogen = countOfOxygen * 2;

        for (int i = 0; i < countOfOxygen; i++) {
            threadList.add(new Oxygen(cyclicBarrier));
        }

        for (int i = 0; i < countOfHydrogen; i++) {
            threadList.add(new Hydrogen(cyclicBarrier));
        }
        while (threadList.size() > 0) {
            Objects.requireNonNull(ThreadUtils.getOxygenThread(threadList)).start();
            Objects.requireNonNull(ThreadUtils.getHydrogenThread(threadList)).start();
            Objects.requireNonNull(ThreadUtils.getHydrogenThread(threadList)).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
