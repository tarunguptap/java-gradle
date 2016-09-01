package com.example.core.MemOutBound.thread;

public class Mythread {

    public static void main(String[] args) {
        Runnable r = new Runnable1();
        Thread t = new Thread(r);
        t.setName("Test thread1");
        Runnable r2 = new Runnable2();
        Thread t2 = new Thread(r2);
        t2.setName("Test thread2");
        t.start();

        t2.start();
    }
}

class Runnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1100; i += 2) {
            System.out.println(i);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) { // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 11; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
