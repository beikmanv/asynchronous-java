package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TaskFour {
    public static void main(String[] args) {

        CompletableFuture<String> exampleOne = CompletableFuture.supplyAsync(() -> {
            System.out.println("Asynchronous One!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello first world!");
            return "Hello first world!";
        });

        CompletableFuture<String> exampleTwo = CompletableFuture.supplyAsync(() -> {
            System.out.println("Asynchronous Two!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello second world!");
            return "Hello second world!";
        });

        // Combine results from both tasks
        CompletableFuture<String> combinedResult = exampleOne.thenCombine(exampleTwo,
                (helloFirst, helloSecond) -> helloFirst + " " + helloSecond);

        // Print the combined result
        combinedResult.thenAccept(System.out::println);

        // Wait for combined result to ensure the program does not terminate prematurely
        combinedResult.join();
    }
}