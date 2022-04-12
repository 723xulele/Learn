package com.xll.test;

/**
 * @Author xulele
 * @Date: 2022/04/12/23:30
 * @Description:
 * 创建多线程的方式2: 实现Runnable接口
 * 1. 创建类实现Runnable接口
 * 2. 实现run()方法
 * 3. 创建类对象
 * 4. 将对象作为参数传递到Thread类的构造器中,创建Thread对象
 * 5. 调用Thread类的run()方法
 *
 *
 * 比较创建线程的两种方式:
 * 开发中优先选择实现Runnable接口的方式
 * 原因: 1.实现的方式没有类的单继承的局限性
 *      2.实现的方式更适合处理多个线程有共享数据的情况
 * 联系: 两种方式都需要重写run(), 将线程要执行的逻辑声明在run()中
 */
class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread1= new Thread(mThread);
        thread1.start();

        //再启动一个线程
        Thread thread2 = new Thread(mThread);
        thread2.start();
    }
}
