package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class Demo2 {
    public static void main(String[] args) {
        MyCallable2 mc = new MyCallable2();
        FutureTask<String> ft = new FutureTask<>(mc);

        Thread t1 = new Thread(ft);
        t1.setName("飞机");
        t1.setPriority(1);
        t1.start();

        MyCallable2 mc2 = new MyCallable2();
        FutureTask<String> ft2 = new FutureTask<>(mc2);
        Thread t2 = new Thread(ft2);
        t2.setName("坦克");
        t2.setPriority(10);
        t2.start();
    }
}

class MyCallable2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
        return "线程执行完毕";
    }
}