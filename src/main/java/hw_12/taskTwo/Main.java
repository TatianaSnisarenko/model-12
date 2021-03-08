package hw_12.taskTwo;

public class Main {
    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(10);
        executor.execute(new MyRunnable());
        executor.shutdown();
    }
}
