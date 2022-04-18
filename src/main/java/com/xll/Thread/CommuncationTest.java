package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/18/23:17
 * @Description:  线程通信的例子: 使用两个线程交替打印1-100 线程1 2  交替打印
 * 涉及到的三个方法: wait() notify() notifyAll();
 * wait(): 一旦执行此方法,当前线程进入阻塞状态,并释放同步监视器
 * notify(): 一旦执行此方法,就会唤醒一个被wait()的线程`,如果有多个被wait()的线程,就唤醒优先级高的线程
 * notifyAll(): 一旦执行此方法,就会唤醒所有被wait()的线程
 *
 * 说明:
 * 1. wait(), notify(),notifyAll() 只能在同步代码块或同步方法种使用
 * 2. 这三个方法的调用者,必须是同步代码块,同步方法中的同步监视器,否则会出现异常
 * 3. 这三个方法定义在Object类中
 *
 *
 * 面试题:
 * 1. sleep()和wait()的异同?
 *   相同点: 一旦执行方法,都会使当前线程进入阻塞状态
 *   不同点: 关于是否释放同步监视器: 如果两个方法都使用在同步代码块或同步方法中 sleep()不会释放锁,wait()会释放锁;
 *          两个方法声明的位置不一样,一个Thread类中声明sleep()方法,Object()类中声明wait();
 *          调用的范围不同: sleep()可以在任何需要的场景下调用, wait()必须在同步代码块或同步方法中
 *
 */
public class CommuncationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        thread1.setName("线程1");
        thread1.start();
        Thread thread2 = new Thread(number);
        thread2.setName("线程2");
        thread2.start();

    }
}
class Number implements Runnable {

    private static int number = 0;

    @Override
    public void run() {

        pringNum();
    }

    private synchronized void pringNum() {

        while (true) {
            notify();
            if (number <= 100) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------" + number);
                number++;
                try {
                    /** 使得调用wait方法的线程进入阻塞状态  wait()会释放锁 */
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                break;
            }
        }
    }
}
