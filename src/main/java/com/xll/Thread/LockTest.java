package com.xll.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xulele
 * @Date: 2022/04/17/0:50
 * @Description:
 * 解决线程安全问题的方式二: lock锁  JDK1.5新增的方式
 *
 * 1.面试题 synchronized与lock的异同
 * 相同: 都可以解决线程安全问题
 * 不同: synchronized机制是在执行完相应的同步代码后,自动的释放同步监视器,lock需要手动启动同步与结束同步
 *
 *
 * 2.面试题2 解决线程安全问题的几种方式 lock synchronized
 */
class Window5 implements Runnable{

    private static int ticket = 100;

    //1.实例化Lock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public  void run() {
        while (true) {
            try {
                //2.调用lock方法  保证方法内部是单线程
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "---" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                //3. 释放锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {

    public static void main(String[] args) {
        Window5 w1 = new Window5();
        new Thread(w1).start();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}
