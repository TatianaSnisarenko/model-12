package hw_12.taskTwo;

@Repeat(count = 3)
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello!");
    }
}
