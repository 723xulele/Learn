package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/12/23:45
 * @Description: 创建三个窗口卖100张票 存在线程安全问题 使用继承Thread的方式 存在线程安全问题
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
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
class Window1 implements Runnable{

    private   int count = 100;
    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "---" + "第" + count + "张票");
                count--;
            } else {
                break;
            }
        }
    }
}
