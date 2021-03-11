package hw_attempts.TaskOneWithSemaphore;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args)  {

        List<Thread> threads = new CopyOnWriteArrayList<>();
        Semaphore semaphore = new Semaphore(3);

        final int countOfOxygen = 3;
        final int countOfHydrogen = countOfOxygen * 2;

        for (int i = 0; i < countOfOxygen; i++) {
            threads.add(new Oxygen(semaphore));
        }

        for (int i = 0; i < countOfHydrogen; i++) {
            threads.add(new Hydrogen(semaphore));
        }
        while (threads.size() > 0) {
            Objects.requireNonNull(ThreadUtils.getOxygenThread(threads)).start();
            Objects.requireNonNull(ThreadUtils.getHydrogenThread(threads)).start();
            Objects.requireNonNull(ThreadUtils.getHydrogenThread(threads)).start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
