package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/17/1:09
 * @Description:
 *
 * 银行有一个账户
 * 有两个出户分别向同一账户存3000 每次存1000 存3次  每次存完打印账户余额
 *
 * 1.是否是多线程问题? 是 两个储存线程
 * 2.是否有共享数据? 有  账户余额
 * 3.是否有线程安全问题? 有 如何解决?
 */
public class AccountTest {


static class SaveMoney implements Runnable{
    private static int total = 0;
    private static int money = 1000;


    @Override
    public  void run() {
        save();
    }

    private static synchronized void save() {
        int frequency = 3;
        for (;frequency > 0;frequency--) {
            total += money;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---" + total);
        }
    }
}
    public static void main(String[] args) {
        SaveMoney saveMoney = new SaveMoney();
        Thread t1 = new Thread(saveMoney);
        t1.setName("储户1");
        t1.start();
        Thread t2 = new Thread(saveMoney);
        t2.setName("储户2");
        t2.start();

    }
}
