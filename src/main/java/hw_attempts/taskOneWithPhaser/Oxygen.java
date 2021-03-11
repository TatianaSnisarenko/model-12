package hw_attempts.taskOneWithPhaser;

import java.util.concurrent.Phaser;

public class Oxygen extends Thread{
    Phaser phaser;

    public Oxygen(Phaser phaser) {
        super("O");
        this.phaser = phaser;

    }

    public void releaseOxygen() {
        System.out.print(getName());
    }

    @Override
    public void run() {
        phaser.register();
        phaser.arriveAndDeregister();
        releaseOxygen();


    }

}
