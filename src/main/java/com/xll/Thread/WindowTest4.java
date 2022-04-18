package com.xll.Thread;

import lombok.SneakyThrows;

/**
 * @Author xulele
 * @Date: 2022/04/16/16:33
 * @Description: 同步方法解决继承Thread类的线程安全问题
 *
 * 同步方法的总结:
 * 1.同步方法仍然涉及到同步监视器,只是不需要显示的声明
 * 2. 非静态的同步方法,同步监视器是 this
 *    静态的同步方法,同步监视器是 当前类本身
 */
public class WindowTest4 {

    static class Window4 extends Thread{

        private static int count = 100;

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                if (cellTicket()) break;
            }
            }

        private static synchronized boolean cellTicket() { //同步监视器 Window4.class
        //private  synchronized boolean cellTicket() { 同步监视器 this 此处是错误的
            if (count > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---" + "第" + count + "张票");
                count--;
            } else {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Window4 w1 = new Window4();
        w1.setName("窗口1");
        Window4 w2 = new Window4();
        w2.setName("窗口2");
       Window4 w3 = new Window4();
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
    }


