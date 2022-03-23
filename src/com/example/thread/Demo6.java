package com.example.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liuming
 * @description
 * @date 2022/3/23
 */
public class Demo6 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);
        Foodie1 f = new Foodie1(bd);
        Cooker1 c = new Cooker1(bd);

        f.start();
        c.start();
    }
}

class Cooker1 extends Thread{
    private ArrayBlockingQueue<String> bd;

    public Cooker1(ArrayBlockingQueue<String> bd){
        this.bd = bd;
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(1000);
                bd.put("汉堡包");
                System.out.println("厨师放入一个汉堡包");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Foodie1 extends Thread{
    private ArrayBlockingQueue<String> bd;

    public Foodie1(ArrayBlockingQueue<String> bd){
        this.bd = bd;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                String take = bd.take();
                System.out.println("吃货将" + take + "拿出来吃了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
