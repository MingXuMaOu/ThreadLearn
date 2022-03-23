package com.example.thread;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class Demo1 {

    public static void main(String[] args) {
        MyRunnable1 mr = new MyRunnable1();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.start();
        t2.start();
    }
}

class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }
}
