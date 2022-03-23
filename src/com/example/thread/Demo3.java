package com.example.thread;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class Demo3 {
    public static void main(String[] args) {
        MyThread31 t1 = new MyThread31();
        MyThread32 t2 = new MyThread32();

        t1.setName("女神");
        t2.setName("备胎");

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}

class MyThread31 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "----" + i);
        }
    }
}
class MyThread32 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "----" + i);
        }
    }
}
