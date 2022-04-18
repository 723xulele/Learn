package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/12/1:11
 * @Description:
 */

/** *
 * Thread类中的常用方法
 * 1. start(): 启动当前线程; 调用当前线程的run();
 * 2. run(): 通常需要重写Thread类中的run(),将创建线程需要执行的操作声明在此方法中
 * 3. currentThread(): 静态方法,返回执行当前代码的线程
 * 4. getName(); 获取当前线程的名字
 * 5. setName(); 设置当前线程的名字
 * 6. yield(); 释放当前cpu的执行权 但是有可能会再次争抢到
 * 7. join(); 在线程a中调用线程b的join()方法,此时线程a将进入阻塞状态,直到线程b完全执行结束后,线程a才能结束阻塞状态
 * 8. stop();强制结束当前线程 已过时
 * 9. sleep(long millTime): 让当前线程"睡眠"指定毫秒,在指定的时间内,当前线程是阻塞状态
 * 10. isAlive(): 判断当前线程是否还存活
 *
 *
 * 线程的优先级
 * 1. 优先级高的可能被优先执行 但不一定,只是概率高
 * MAX_PRIORITY: 10
 * MIN_PRIORITY: 10
 * NORM_PRIORITY: 5 默认优先级
 * 2. getPriority(): 获取当前线程的优先级
 *    setPriority(int priority): 设置线程优先级
 *    说明: 高优先级的线程要抢占低优先级线程cpu的行权, 但只是从概率上讲,高优先级的线程高概率情况下被执行,但并不意味着高优先级的线程执行完以后,低优先级的线程才执行
 *
 *线程的几种状态:
 * 新建 -> 就绪(调用start()) <---> 运行(获取或丢失cpu执行权) -> 死亡(执行完run(),调用stop(),出现error/Exception)
 * 阻塞: 运行->阻塞 不是线程的最终状态; sleep()方法,join(),等待同步锁,wait(),suspend()挂起
 *       阻塞 -> 就绪 -> 运行
 *       阻塞 -> 就绪 sleep()时间到,join()结束,获取同步锁,notify()/notifyAll(),resume()取消挂起
 */
public class ThreadMethod {

    public static void main(String[] args) {
        new thread1().run();
        Thread.currentThread().setPriority(1);
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getPriority() + "--" + i);
            }
        }
    }


}

class thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + "--" + getPriority() + "--" + i);
            }
        }
    }
}
