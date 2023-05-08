package ro.itschool.springboot.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        Runnable task1 = () -> System.out.println("First task executed in a single thread.");
        Runnable task2 = () -> System.out.println("Second task executed in a single thread.");
        executor.execute(task1);
        executor.execute(task2);
    }
}