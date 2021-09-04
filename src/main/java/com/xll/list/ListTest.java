package com.xll.list;

import com.google.common.collect.Lists;
import com.xll.model.po.Person;
import org.testng.annotations.Test;

import java.util.*;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author: xll
 * @Date: 2021/08/25/16:01
 * @Description: List集合测试类
 */
public class ListTest {

    public static List<Person> personList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("小红", 20));
        personList.add(new Person("小红", 20));
        personList.add(new Person("小明", 25));
        personList.add(new Person("小明", 28));
        personList.add(new Person("小李", 30));
        return personList;
    }

    @Test
    public void test() {
        List<Person> personList = personList();
        try {
            Map<String, List<Person>> map = personList.stream().collect(Collectors.groupingBy(Person::getName));
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 集合去重,泛型是对象
     */
    @Test
    public void testDistinct() {
        List<Person> personList = this.personList();
        List<Person> personListDistinct = personList.stream().distinct().collect(toList());
        List<Person> personListDistinct1 = personList.stream().distinct().collect(Collectors.toList());
        System.out.println(personListDistinct);
        System.out.println(personListDistinct1);
        System.out.println(personListDistinct == personListDistinct1);
        /**[Person(name=小红, age=20), Person(name=小明, age=25), Person(name=小明, age=28), Person(name=小李, age=30)] */
    }

    @Test
    public void testDistinctAge() {
        List<Person> personList = this.personList();
        List<Person> collect = personList.stream().filter(person -> person.getAge() <= 20).collect(toList());
        System.out.println(collect);
    }

    @Test
    public void testMap() {
        List<Map> list = new ArrayList<>();
        List<Person> personList = this.personList();
        Map<String, Object> map = new HashMap();
        for (Person person : personList) {
            System.out.println(person);
            map.put("a", person.getName());
            map.put("b", person.getAge());
            list.add(map);
        }
        System.out.println(list);
    }

    @Test
    public void testMap2(){
        List<Map> list = new ArrayList<>();
        Map<String, Object> map = new HashMap();
        for (int i = 0; i < 5; i++) {
            map.put("a", i);
            System.out.println(i);
            i += 1;
            list.add(map);
        }
        System.out.println(list);
    }

    /**
     * Lists.newArrayList()的用法
     * Arrays.asList()的用法
     */
    @Test
    public void testLists(){
        ArrayList<Integer> integers = Lists.newArrayList(2, 3);
        List<Integer> integers1 = Arrays.asList(2, 3);
        System.out.println(integers);
        System.out.println(integers1);
        System.out.println(integers1 == integers);
    }
}
