package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/12/23:15
 * @Description: 创建三个窗口卖100张票 存在线程安全问题 使用继承Thread的方式
 */
class Window extends Thread{

    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                System.out.println(getName() + "---" + "第" + count + "张票");
                count--;
            } else {
                break;
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
