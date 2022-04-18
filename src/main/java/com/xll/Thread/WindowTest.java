package com.xll.Thread;

import lombok.SneakyThrows;

/**
 * @Author xulele
 * @Date: 2022/04/12/23:15
 * @Description: 创建三个窗口卖100张票 存在线程安全问题 使用继承Thread的方式
 *
 * 使用同步代码块解决继承Thread类的线程安全问题
 *
 * 在继承Thread类创建多线程的方式中,慎用this充当锁,可以考虑使用当前类充当同步监视器
 */
class Window extends Thread{

    private static int count = 100;
    /** 三个window对象 需要保证锁对象唯一 */
    private static Object o = new Object();

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            //synchronized (this) { 此处不能使用 此处的window有三个不同的对象
            synchronized (Window.class) { //类也是对象 Class clazz = Window.class 类对象只会加载一次 所以他是唯一的
            //synchronized (o) {
                if (count > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "---" + "第" + count + "张票");
                    count--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        w1.setName("窗口1");
        Window w2 = new Window();
        w2.setName("窗口2");
        Window w3 = new Window();
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
