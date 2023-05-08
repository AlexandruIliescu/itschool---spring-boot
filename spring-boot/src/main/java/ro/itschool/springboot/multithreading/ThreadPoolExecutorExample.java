package ro.itschool.springboot.multithreading;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, // corePoolSize
                4, // maximumPoolSize
                60, // keepAliveTime
                TimeUnit.SECONDS, // unit of keepAliveTime
                new LinkedBlockingQueue<>() // workQueue;
        );

        Runnable task1 = () -> System.out.println("Task 1 executed in a custom thread pool.");
        Runnable task2 = () -> System.out.println("Task 2 executed in a custom thread pool.");

        threadPoolExecutor.execute(task1);
        threadPoolExecutor.execute(task2);
        threadPoolExecutor.shutdown();
    }
}