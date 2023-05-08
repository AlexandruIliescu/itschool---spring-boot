package ro.itschool.springboot.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPractice implements Runnable {

    private final int[] arr;
    private final int start;
    private final int end;
    private final AtomicLong result;

    public ThreadPractice(int[] arr, int start, int end, AtomicLong result) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int index = start; index < end; index++) {
            sum += (long) arr[index] * arr[index];
        }
        result.addAndGet(sum);
    }
}

class MainExecutionClass {

    public static void main(String[] args) throws InterruptedException {
        int number = 100_000_000;
        int[] arr = new int[number];
        for (int index = 0; index < number; index++) {
            arr[index] = index;
        }

        //single-threaded
        long startTime = System.currentTimeMillis();
        AtomicLong singleThreadedResult = new AtomicLong();
        new ThreadPractice(arr, 0, number, singleThreadedResult).run();
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded sum: " + singleThreadedResult);
        System.out.println("Single-threaded time: " + (endTime - startTime) + " ms");

        //multi-thread with ExecutorService
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread count for local machine: " + threadCount);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int partSize = number / threadCount;
        AtomicLong multiThreadedResult = new AtomicLong();
        startTime = System.currentTimeMillis();
        for (int index = 0; index < threadCount; index++) {
            int start  = index * partSize;
            int end = (index == threadCount - 1) ? number : start + partSize;
            executor.execute(new ThreadPractice(arr, start, end, multiThreadedResult));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded sum: " + multiThreadedResult);
        System.out.println("Multi-threaded time: " + (endTime - startTime) + " ms");
    }
}