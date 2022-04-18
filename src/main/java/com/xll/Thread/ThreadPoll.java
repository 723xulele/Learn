package com.xll.Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author xulele
 * @Date: 2022/04/19/1:03
 * @Description:
 * 创建线程的方式4: 使用线程池
 *
 * 好处: 1.提高响应速度 (减少了创建线程的时间)
 *      2.降低资源消耗(重复利用线程池中线程,不需要每次都创建)
 *      3.便于线程管理
 *       corePollSize: 核心池大小
 *       maximumPoolSize: 最大线程数
 *       keepAliveTime: 线程没有任务时最多保持多长时间后终止
 *
 *  创建多线程有几种方式?
 *  四种
 *
 */
public class ThreadPoll {
    public static void main(String[] args) {
        /**1. 提供指定数量的线程池 */
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        /** 设置线程池的一些属性 */
        executorService.setCorePoolSize(10);
        System.out.println(executorService.getCorePoolSize());
        executorService.setKeepAliveTime(1000, TimeUnit.SECONDS);
        /**2. 执行指定线程的操作 需提供实现Runnable接口或Callable接口实现类方式的对象 */
        executorService.execute(new NumberThread1());//适用于Runnable
        executorService.execute(new NumberThread2());//适用于Runnable
        /**3. 关闭连接池*/
        executorService.shutdown();
        //executorService.submit();//适用于Callable
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() +  "----" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
            }
        }
    }
}
