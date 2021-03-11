package hw_attempts.taskOneWithPhaser;


import hw_attempts.taskOne.ThreadUtils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Thread> threadList = new CopyOnWriteArrayList<>();
        Phaser phaser = new Phaser(0);

        final int countOfOxygen = 3;
        final int countOfHydrogen = countOfOxygen * 2;

        for (int i = 0; i < countOfOxygen; i++) {
            threadList.add(new Oxygen(phaser));
        }

        for (int i = 0; i < countOfHydrogen; i++) {
            threadList.add(new Hydrogen(phaser));
        }
        while (threadList.size() > 0) {
            service.submit(Objects.requireNonNull(ThreadUtils.getOxygenThread(threadList)));
            service.submit(Objects.requireNonNull(ThreadUtils.getHydrogenThread(threadList)));
            service.submit(Objects.requireNonNull(ThreadUtils.getHydrogenThread(threadList)));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}