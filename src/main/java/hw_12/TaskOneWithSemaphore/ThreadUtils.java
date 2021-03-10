package hw_12.TaskOneWithSemaphore;

import java.util.List;

public class ThreadUtils {
    public static Thread getOxygenThread(List<Thread> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals("O")) {
                return list.remove(i);
            }
        }
        return null;
    }

    public static Thread getHydrogenThread(List<Thread> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals("H")) {
                return list.remove(i);
            }
        }
        return null;
    }
}
