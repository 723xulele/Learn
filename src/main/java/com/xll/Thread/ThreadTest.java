package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/11/23:58
 * @Description:
 */

/**
 * 多线程创建方式一: 继承Thread类
 * 1. 创建类继承Thread类
 * 2. 重写run()方法 -> 将执行的操作声明在run()方法种
 * 3. 创建Thread子类对象
 * 4. 调用start()方法
 */
//1. 创建类继承Thread类
class MyThread extends Thread {
//2. 重写run()方法 -> 将执行的操作声明在run()方法种
    @Override
    public void run() {
        for (int i= 0; i<= 100; i++) {
            if ( i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
public class ThreadTest {

    public static void main(String[] args) {
        //3. 创建Thread子类对象
        MyThread myThread = new MyThread();
        //4. 调用start()方法
        myThread.start(); //1.启动当前线程 2.调用当前线程的run()方法
        // 问题1: 不能通过run()方法方式启动线程 实际不会是一个新的线程
        //myThread.run();
        //问题2: 再启动一个线程,便利100内的偶数 不可以用已经start()的线程去执行 会报myThread.start();
        //myThread.start();
        // 需要重新创建一个线程对象
        MyThread myThread2 = new MyThread();
        myThread2.start();
        // 如下操作依然是在main()线程中执行的
        for (int i= 0; i<= 100; i++) {
            if ( i % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }

}
