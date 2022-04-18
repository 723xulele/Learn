package com.xll.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author xulele
 * @Date: 2022/04/19/0:32
 * @Description: 创建线程的实现方式3 实现Callable接口
 *
 * 如何理解实现Callable接口比实现Runnable接口创建线程的方式强大?
 * 1. call()方法,可以有返回值
 * 2. call()方法可以抛出异常,被外面的操作捕获,获取异常信息
 * 3. Callable支持泛型 可以确定call()方法返回值类型
 */
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumberThread numberThread = new NumberThread();
        //4.将此callable接口实现类的对象作为参数传到FutureTask构造器中,创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(numberThread);
        //5. 将FutureTask对象作为参数传递到Thread类的构造器中,创建Thread()对象,调用start()方法
        new Thread(futureTask).start();
        try {
            //6. 获取callable中的返回值
            //get()方法的返回值 即位FutureTask构造器Callable实现类重写的call()的返回值
            Integer o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
/** 1.创建一个实现Callable的实现类*/
class NumberThread implements Callable<Integer>{
    // 2.将需要执行的方法声明在call()中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <=100; i++) {
            if (i%2 == 0) {
                System.out.println(i);
                sum += i;
            }

        }
        return sum;

    }
}
