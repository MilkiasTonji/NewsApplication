package com.company;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please wait it is loading...........");
        Timer timer = new Timer();
        while (true){
            try {
                Thread.sleep(1000);
                timer.schedule(new NewsGenerator(),5000);

            } catch (InterruptedException e) {
                System.out.println("Could not start another thread");
                e.printStackTrace();
            }
        }
    }
}
