package hw_12.taskOnewater;

public class Main {
    public static void main(String[] args) {
        Water water = new Water();
        String ss = "OOHHHHOOHHHHOOHHHH";

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        for (int i = 0; i < ss.length(); i++) {
            char ch = ss.charAt(i);
            if(ch=='O'){
                new Thread(() ->{
                    try{
                        water.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }else if(ch=='H'){
                new Thread(() ->{
                    try {
                        water.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
