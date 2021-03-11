package hw_attempts.taskOneWithPhaser;

import java.util.concurrent.Phaser;

public class Hydrogen extends Thread {
    Phaser phaser;

    public Hydrogen(Phaser phaser) {
        super("H");
        this.phaser = phaser;
    }

    public void releaseHydrogen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        phaser.register();
        phaser.arriveAndDeregister();
        releaseHydrogen();


    }
}