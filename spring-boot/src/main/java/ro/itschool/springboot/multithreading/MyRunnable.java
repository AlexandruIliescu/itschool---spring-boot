package ro.itschool.springboot.multithreading;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int index = 0; index < 5; index++) {
            System.out.println("My thread: " + index);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MainRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
