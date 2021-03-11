package hw_12.taskOneWithOnePhaser;

import java.util.concurrent.Phaser;

public class Oxygen extends Thread {
    private Phaser phaser;
    private int phase;

    public Oxygen(Phaser phaser, int phase) {
        super("O");
        this.phaser = phaser;
        this.phase = phase;
        phaser.register();
    }

    public void releaseOxygen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        while (phase < phaser.getPhase()) {
            phaser.arriveAndAwaitAdvance();
        }
        releaseOxygen();
        phaser.arriveAndDeregister();
    }
}
