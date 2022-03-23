package com.example.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liuming
 * @description
 * @date 2022/3/23
 */
public class Demo02 {
    public static void main(String[] args) throws Exception{
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        arrayBlockingQueue.put("汉堡包");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());

        System.out.println("程序结束了");

    }


}
