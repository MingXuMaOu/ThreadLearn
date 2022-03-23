package com.example.thread;

import java.util.concurrent.FutureTask;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class DemoTest {
    public static void main(String[] args) throws Exception{
        MyCallable mc = new MyCallable();

        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);

        t1.start();
        String s = ft.get();
        System.out.println(s);
    }
}
