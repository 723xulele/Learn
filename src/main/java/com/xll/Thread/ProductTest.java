package com.xll.Thread;

/**
 * @Author xulele
 * @Date: 2022/04/18/23:56
 * @Description:
 * 线程通信的应用: 经典例题: 生产者/消费者问题
 *
 * 生产者(Producer)将产品交给店员,而消费者(Customer)从店员处取走产品,店员每次只能持有固定数量的产品,比如(20),如果生产者试图生产更多的产品,店员就会让生产者停一下,如果店中有空位放产品了再通知生产者继续生产,如果店中没有产品了,店员会告诉消费者等一下,如果店中有产品了再通知消费者来取走产品
 *
 *
 * 分析:
 * 1.是否是多线程问题? 是:生产者线程 消费者线程
 * 2.是否有共享数据? 是 店员
 * 3.如何解决线程安全问题?
 * 4.是否涉及到线程的通信? 是
 */
public class ProductTest {

static class Clerk{

    private int productCount = 0;
    //生产产品
    public synchronized void productProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ": 开始生产第" + productCount + "产品");
            notify();
        } else {
        // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0) {
            notify();
            System.out.println(Thread.currentThread().getName() + ": 开始消费第" + productCount + "产品");
            productCount--;
        } else {
        // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
static class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
       
        System.out.println(getName() + "开始生产产品");
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productProduct();
        }
    }
}

static class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品");
        while (true) {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        p1.start();
        Customer c1 = new Customer(clerk);
        c1.setName("消费者1");
        c1.start();
        Customer c2 = new Customer(clerk);
        c2.setName("消费者2");
        c2.start();
    }
}
