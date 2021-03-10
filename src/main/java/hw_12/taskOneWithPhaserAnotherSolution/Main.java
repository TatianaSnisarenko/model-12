package hw_12.taskOneWithPhaserAnotherSolution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Main {

    public static final Phaser PHASER = new Phaser(1);

    public static void main(String[] args) {

        final int countOfMoleculs = 3;
        final int countOfThreads = countOfMoleculs * 3;

        ExecutorService service = Executors.newFixedThreadPool(countOfThreads);

        for (int i = 0; i < countOfMoleculs; i++) {
            service.submit(new Oxygen(PHASER, i));
            service.submit(new Hydrogen(PHASER, i));
            service.submit(new Hydrogen(PHASER, i));
            PHASER.arriveAndAwaitAdvance();
        }

        PHASER.arriveAndDeregister();
        service.shutdown();
    }
}