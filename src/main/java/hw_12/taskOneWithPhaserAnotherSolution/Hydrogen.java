package hw_12.taskOneWithPhaserAnotherSolution;

import java.util.concurrent.Phaser;

public class Hydrogen extends Thread {
    private Phaser phaser;
    public int stage;

    public Hydrogen(Phaser phaser, int phase) {
        super("H");
        this.phaser = phaser;
        this.stage = phase;
        phaser.register();
    }

    public void releaseHydrogen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        while (stage < phaser.getPhase()) {
            phaser.arriveAndAwaitAdvance();
        }
        releaseHydrogen();
        phaser.arriveAndDeregister();
    }
}