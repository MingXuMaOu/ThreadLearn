package com.example.thread;

/**
 * @author liuming
 * @description
 * @date 2022/3/22
 */
public class SellTicket implements Runnable{
    private int tickets = 100;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                if (tickets <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + tickets + "张票");
                }
            }

        }
    }
}

class SellTicketDemo{
    public static void main(String[] args) {
        SellTicket st = new SellTicket();
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
