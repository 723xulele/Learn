package com.xll.reflect;

import com.xll.model.po.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date: 2021/09/13/22:37
 * @Description: 测试反射性能以及优化
 */
public class Reflect02Time {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        hi();
        reflect();
        reflect2();
    }
    //传统方法 调用hi
    public static void hi() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统时差" + (end - start));
    }

    //反射机制
    public static void reflect() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<Cat> catClass = Cat.class;
        Cat cat = catClass.newInstance();
        Method hi = catClass.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hi.invoke(cat);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射时差" + (end - start));

    }

    //反射调用优化 关闭访问检测
    //反射机制
    public static void reflect2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<Cat> catClass = Cat.class;
        Cat cat = catClass.newInstance();
        Method hi = catClass.getMethod("hi");
        hi.setAccessible(true); //在反射调用方法时 取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hi.invoke(cat);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射时差" + (end - start));

    }
}
