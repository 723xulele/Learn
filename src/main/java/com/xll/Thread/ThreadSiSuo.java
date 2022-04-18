package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/17/0:31
 * @Description:
 * 演示线程死锁问题
 * 1.都在等待对方释放锁资源
 * 2.出现死锁后不会异常,只是所有线程处于阻塞状态
 * 3.使用同步代码块时,需注意死锁问题
 */
public class ThreadSiSuo {

    public static void main(String[] args) {

        StringBuffer s1 =  new StringBuffer();
        StringBuffer s2 =  new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");
                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");
                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
