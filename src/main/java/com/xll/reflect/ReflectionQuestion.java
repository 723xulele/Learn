package com.xll.reflect;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Date: 2021/09/04/23:14
 * @Description:
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //根据配置文件 re.properties 创建Cat对象,调用hi方法

        //传统方式 new 对象 调用方法
//        Cat cat = new Cat();
//        cat.hi(); ==>> car.cry() 修改源码

        //尝试做一下 ==>> 明白反射

        //1. 使用Properties类,读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\re.properties"));
        String classFullPath = properties.getProperty("classFullPath");
        String methodName = properties.getProperty("method");
        System.out.println(classFullPath);
        System.out.println(methodName);

        //2.创建对象, 传统的方法行不通, ==>> 反射机制
        //new classFullPath(); //classFullPath是一个字符串类型

        //3.使用反射机制解决
        // (1) 加载类, 返回一个Class类型的对象
        Class<?> cls = Class.forName(classFullPath);
        // (2) 通过cls 得到你加载的类 (com.xll.model.po.Cat) 的实例对象
        Object o = cls.newInstance();
        System.out.println("o的运行类型" + o.getClass());  //运行类型 class com.xll.model.po.Cat
        // (3) 通过cls 得到你加载的类 com.xll.model.po.Cat 的methodName"hi" 的方法对象
        //  即: 在反射中,可以把方法视为对象 万物皆可对象
        Method method1 = cls.getMethod(methodName);
        // (4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=================");
        method1.invoke(o); // 传统方法: 对象.方法(); 反射机制: 方法.invoke(对象)
    }

    @Test
    public void  testReflect() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\re.properties"));
        String classFullPath = properties.getProperty("classFullPath");
        String methodName = properties.getProperty("method");

        //2.创建对象, 传统的方法行不通, ==>> 反射机制
        //new classFullPath(); //classFullPath是一个字符串类型

        //3.使用反射机制解决
        // (1) 加载类, 返回一个Class类型的对象
        Class<?> cls = Class.forName(classFullPath);
        // (2) 通过cls 得到你加载的类 (com.xll.model.po.Cat) 的实例对象
        Object o = cls.newInstance();
        System.out.println("o的运行类型" + o.getClass());  //运行类型 class com.xll.model.po.Cat
        // (3) 通过cls 得到你加载的类 com.xll.model.po.Cat 的methodName"hi" 的方法对象
        //  即: 在反射中,可以把方法视为对象 万物皆可对象
        Method method1 = cls.getMethod(methodName);
        // (4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=================");
        method1.invoke(o); // 传统方法: 对象.方法(); 反射机制: 方法.invoke(对象)
        //getField()不能得到私有属性
          Field age = cls.getDeclaredField("name");
        Constructor<?> constructor = cls.getConstructor();//()中可以指定构造器参数 , 返回无参构造器
        Constructor  constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);//有参构造器
        System.out.println(constructor);
        System.out.println(age);

    }
















































}
