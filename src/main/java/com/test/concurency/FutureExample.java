/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.concurency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Eugen.Popa
 */
public class FutureExample {

    public static void main(String[] args) throws Exception {
        System.out.println("Using fixed thread pool:");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        test(executor);

        System.out.println("\nUsing cached thread pool:");
        executor = Executors.newCachedThreadPool();
        test(executor);

        System.out.println("\nUsing single thread executor:");
        executor = Executors.newSingleThreadExecutor();
        test(executor);
    }

    private static void test(ExecutorService executor)
            throws ExecutionException, InterruptedException {
        Counter counter = new Counter();

        Future<?> f1 = executor.submit(new Worker(counter, true, 10000));
        Future<?> f2 = executor.submit(new Worker(counter, false, 10000));

        // reject new tasks, must call in order to exit VM
        executor.shutdown();

        // wait for termination, much like Thread.join()
        f1.get();
        f2.get();

        System.out.println("Final count: " + counter.getCount());
    }
}
