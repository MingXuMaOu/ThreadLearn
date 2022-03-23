package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("测试：" + i);
        }
        return "回复";
    }

}
class Demo{
    public static void main(String[] args) throws Exception{
        MyCallable mc = new MyCallable();

        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);
        t1.start();
        String s = ft.get();

        System.out.println(s);
    }
}
