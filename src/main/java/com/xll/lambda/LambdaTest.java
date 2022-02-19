package com.xll.lambda;

import com.xll.model.po.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xll
 * @Date: 2021/08/24/14:47
 * @Description: lambda表达式
 * lambda表达式在Java语言中引入了一个操作符" -> ",该操作符被称为Lambda操作符,将Lambda分为两部分
 * 左侧: 指定了Lambda需要用到的参数
 * 右侧: 制定了Lambda体,即Lambda表达式要执行的功能
 * 函数式接口: 一个接口,如果只有一个显示声明的抽象方法,那么它就是一个函数式接口.一般用@FunctionInterface标注出来
 */
public class LambdaTest {

    public static List<Person> personList() {
        //List<Person> personList = new ArrayList<>();
        //personList.add(new Person("小明", 20));
        //personList.add(new Person("小红", 15));
        //personList.add(new Person("小李", 25));
        //personList.add(new Person("小陈", 30));
        //personList.add(new Person("小王", 27));
        //return personList;
        return null;
    }

    public static Person getPerson(Person person) {
        if (person.getAge() >= 20) {
            person.setAge(60);
        }
        System.out.println(person);
        return person;
    }

    @Test
    public void learnLambda(){

        Runnable runnable = () -> {System.out.println("hello");};
//        Object o1 = () -> {System.out.println("world");}
        /**上述Object会报编译异常 Target type of a lambda conversion must be an interface*/
    }
}
