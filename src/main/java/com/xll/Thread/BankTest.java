package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/16/16:45
 * @Description: 使用同步机制将单例模式中的懒汉式改为线程安全的
 */
public class BankTest {

}

class Bank{

    private Bank(){}

    private static Bank instance= null;

    private static Bank getInstance(){
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                    return instance;
                }

            }
        }
        return instance;
    }

    /** 同步方法
     *
     *  private static synchronized  Bank getInstance(){
     *         if (instance == null) {
     *             instance = new Bank();
     *             return instance;
     *         }
     *         return instance;
     *     }
     */

    /** 同步代码块 效率差
     *  private static Bank getInstance(){
     *         synchronized (Bank.class) {
     *             if (instance == null) {
     *                 instance = new Bank();
     *                 return instance;
     *             }
     *             return instance;
     *         }
     *     }
     */
}
