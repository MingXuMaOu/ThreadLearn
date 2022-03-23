package com.example.thread;

/**
 * @author liuming
 * @description
 * @date 2022/3/23
 */
public class Desk {

    public static boolean flag = false;

    public static int count = 10;
    public static final Object lock = new Object();

}

class Cooker extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else{
                    if(!Desk.flag){
                        System.out.println("厨师正在生成汉堡包");
                        Desk.flag = true;
                        Desk.lock.notifyAll();
                    }else {
                        try {
                            Desk.lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

class Foodie extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else{
                    if(Desk.flag){
                        System.out.println("吃货正在吃汉堡");
                        Desk.flag = false;
                        Desk.lock.notifyAll();
                        Desk.count--;
                    }else{
                        try{
                            Desk.lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

class Demo5{
    public static void main(String[] args) {
        Foodie f = new Foodie();
        Cooker c = new Cooker();

        f.start();
        c.start();
    }
}
