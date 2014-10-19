package com.test.concurency;

public class JavaDaemonThread {
    public static void main(String[] args) throws InterruptedException {

        Thread daemonThread = new Thread(new DaemonThread(),"dt");
        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread.sleep(5000);
        System.out.println("Finishing program");

    }

}
