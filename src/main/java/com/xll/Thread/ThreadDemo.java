package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/12/0:37
 * @Description:
 */
public class ThreadDemo {

    public static void main(String[] args) {
        // 创建匿名子类对象的方式
        new Thread(){
            @Override
            public void run() {
                for (int i= 0; i<= 100; i++) {
                    if ( i % 2 == 0) {
                        System.out.println(getName() + i);
                    }
                }
            }
        }.start();
    }
}
