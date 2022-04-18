package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/16/16:23
 * @Description: 使用同步方法解决Runnable()的线程安全问题
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window1 = new Window3();
        Thread thread1 = new Thread(window1);
        thread1.setName("窗口1");
        thread1.start();
        Thread thread2 = new Thread(window1);
        thread2.setName("窗口2");
        thread2.start();
        Thread thread3 = new Thread(window1);
        thread3.setName("窗口3");
        thread3.start();
    }
}
class Window3 implements Runnable{

    private  int count = 100;
    @Override
    public void run() {

        while (true) {
            if (cellTicket()) break;
        }
    }

    /** 同步方法可以保证 内部的方法只能有一处在调用*/
    private synchronized boolean cellTicket() { //同步监视器就是this
        if (count > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---" + "第" + count + "张票");
            count--;
        } else {
            return true;
        }
        return false;
    }
}
