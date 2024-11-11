package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) { /*throws InterruptedException*/   // Alternative

        CompletableFuture<String> exampleOne = CompletableFuture.supplyAsync(() -> {
            System.out.println("Asynchronous One!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
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

        // Ensure the main thread waits for the CompletableFuture to complete         //  Alternative
//        example.join(); // This blocks the main thread until the async task is done   //  Alternative
//        try {
//            Thread.sleep(9000);
////            TimeUnit.SECONDS.sleep(5);        //  Alternative
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // Combine results from both tasks
        CompletableFuture<String> combinedResult = exampleOne.thenCombine(exampleTwo,
                (helloFirst, helloSecond) -> helloFirst + " " + helloSecond);

        // Print the combined result
        combinedResult.thenAccept(System.out::println);

        // Wait for combined result to ensure the program does not terminate prematurely
        combinedResult.join();
    }
}