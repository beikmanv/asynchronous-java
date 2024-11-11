package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) { /*throws InterruptedException*/   // Alternative

        CompletableFuture<Void> example = CompletableFuture.runAsync(() -> {
            System.out.println("Asynchronous!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                e.printStackTrace();
            }
            System.out.println("Hello world!");
        });
//        // Ensure the main thread waits for the CompletableFuture to complete         //  Alternative
//        example.join(); // This blocks the main thread until the async task is done   //  Alternative
        try {
            Thread.sleep(5000);
//            TimeUnit.SECONDS.sleep(5);        //  Alternative
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}