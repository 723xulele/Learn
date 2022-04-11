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
 */
public class ThreadMethod {
}
