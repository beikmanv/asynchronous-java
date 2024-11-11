package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) { /*throws InterruptedException*/   // Alternative

        CompletableFuture<Void> exampleOne = CompletableFuture.runAsync(() -> {
            System.out.println("Asynchronous One!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                e.printStackTrace();
            }
            System.out.println("Hello first world!");
        });

        CompletableFuture<Void> exampleTwo = CompletableFuture.runAsync(() -> {
            System.out.println("Asynchronous Two!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello second world!");
        });

//        // Ensure the main thread waits for the CompletableFuture to complete         //  Alternative
//        example.join(); // This blocks the main thread until the async task is done   //  Alternative
        try {
            Thread.sleep(9000);
//            TimeUnit.SECONDS.sleep(5);        //  Alternative
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}