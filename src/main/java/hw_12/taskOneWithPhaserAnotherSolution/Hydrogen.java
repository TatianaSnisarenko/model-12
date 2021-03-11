package hw_12.taskOneWithPhaserAnotherSolution;

import java.util.concurrent.Phaser;

public class Hydrogen extends Thread {
    private Phaser phaser;
    private int phase;

    public Hydrogen(Phaser phaser, int phase) {
        super("H");
        this.phaser = phaser;
        this.phase = phase;
        phaser.register();
    }

    public void releaseHydrogen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        while (phase < phaser.getPhase()) {
            phaser.arriveAndAwaitAdvance();
        }
        releaseHydrogen();
        phaser.arriveAndDeregister();
    }
}