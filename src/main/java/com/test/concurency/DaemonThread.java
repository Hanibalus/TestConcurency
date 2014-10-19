package com.test.concurency;

public class DaemonThread implements Runnable {

    @Override
    public void run() {
        while(true){
            processSomething();
        }
    }

    private void processSomething() {
        try {
            System.out.println("Processing daemon thread");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
