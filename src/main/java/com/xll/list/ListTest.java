package com.xll.list;

import com.xll.model.po.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}
