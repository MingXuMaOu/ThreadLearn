package com.example.thread;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class MyRunnableDemo {

    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();
        Thread t1 = new Thread(my,"坦克");
        Thread t2 = new Thread(my,"飞机");

        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
