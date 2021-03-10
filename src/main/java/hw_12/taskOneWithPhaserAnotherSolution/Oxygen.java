package hw_12.taskOneWithPhaserAnotherSolution;

import java.util.concurrent.Phaser;

public class Oxygen extends Thread {
    Phaser phaser;
    public int stage;

    public Oxygen(Phaser phaser, int phase) {
        super("O");
        this.phaser = phaser;
        this.stage = phase;
        phaser.register();
    }

    public void releaseOxygen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        while (stage < phaser.getPhase()) {
            phaser.arriveAndAwaitAdvance();
        }
        releaseOxygen();
        phaser.arriveAndDeregister();
    }
}
