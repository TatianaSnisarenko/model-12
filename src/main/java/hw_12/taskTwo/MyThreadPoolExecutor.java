package hw_12.taskTwo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    private static final int maximumPoolSize = Integer.MAX_VALUE;
    private static final long keepAliveTime = 60;
    private static final TimeUnit unit = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(50);

    public MyThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        int count = 1;
        if (command.getClass().isAnnotationPresent(Repeat.class)) {
            Repeat annotation = command.getClass().getAnnotation(Repeat.class);
            count = annotation.count();
        }

        for (int i = 0; i < count; i++) {
            super.execute(command);
        }

    }
}
