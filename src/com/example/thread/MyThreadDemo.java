package com.example.thread;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1("高铁");
        MyThread1 m2 = new MyThread1("飞机");

//        m1.setName("高铁");
//        m2.setName("飞机");


        m1.start();
        m2.start();

        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread1 extends Thread{
    public MyThread1(){}

    public MyThread1(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }


}
