package ro.itschool.springboot.multithreading;

public class MyThread extends Thread {

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

class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}