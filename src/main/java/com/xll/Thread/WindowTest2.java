package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/12/23:45
 * @Description: 创建三个窗口卖100张票 存在线程安全问题 使用继承Thread的方式 存在线程安全问题
 *
 * 1.卖票过程中出现了重票和错票情况 --> 线程安全问题
 * 2.问题出现的原因: 当某个线程在操作车票的过程中,尚未完成时,其他的线程参与进来,也操作车票
 * 3.如何解决: 当一个线程A在操作票的时候,其他线程不能参与进来,直到线程A操作完票时,其他线程才可以开始操作,这种情况即使A线程出现了阻塞,也不能被改变(即其他线程不能操作)
 * 4. 在java中 通过同步机制来解决线程安全问题
 *
 * 方式1:  同步代码块
 * synchronized(同步监视器) {
 *     //  需要被同步的代码
 * }
 * 说明: 1.操作共享数据的代码,即为需要被同步的代码   ->>>不能包含多或少代码  就是包起来需要同步的代码
 *      2.共享数据: 多个线程共同操作的变量  比如 车票(count) 就是共享数据
 *      3.同步监视器: 俗称 锁 任何一个类的对象都可以充当锁
 *          要求: 多个线程必须共用同一把锁
 *
 *          补充: 在实现Runnable()接口创建多线程的方式中,可以考虑this作为锁
 *
 *
 * 方式2: 同步方法
 *  如果操作共享数据的代码完整的声明在一个方法中,我们不妨将此方法声明同步的
 *
 *
 * 5.同步的方式,解决了线程的安全问题. ---好处
 *   操作同步代码时只能有一个线程参与,其他线程等待.相当于是一个单线程的过程,效率低---
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

    private  int count = 100;
    Object o = new Object();
    @Override
    public void run() {

        while (true) {
            //synchronized (o) {
            synchronized (this) {  //this 指的是当前类对象 即Window1
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + "第" + count + "张票");
                    count--;
                } else {
                    System.out.println(this.getClass());
                    break;
                }
            }

        }
    }
}
