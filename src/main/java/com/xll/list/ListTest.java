package com.xll.list;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Lists;
import com.xll.model.po.Person;
import com.xll.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
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
        personList.add(new Person("小红", 20, DateUtil.deleteDate(new Date(),1L)));
        personList.add(new Person("小红", 20,DateUtil.deleteDate(new Date(),5L)));
        personList.add(new Person("小明", 25,DateUtil.deleteDate(new Date(),3L)));
        personList.add(new Person("小明", 28,DateUtil.deleteDate(new Date(),5L)));
        personList.add(new Person("小李", 30,DateUtil.deleteDate(new Date(),9L)));
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

    @Test
    public void test222() {
        List<Person> personList = personList();
        String string = "";
        for (Person person : personList) {
            string += StringUtils.join(person.getName(),",");
        }
        System.out.println(string);
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
        List<Person> collect = personList.stream().filter(person -> person.getAge() <= 20 ).collect(toList());
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
        System.out.println(String.format("yyyy-mm-dd",new DateTime().plusMinutes(20)));
        List<Person> personList = this.personList();
        String str = "";
        for (Person person : personList) {
            str = str + StringUtils.join(person.getName(),",");
        }
        System.out.println(str);
        String collect = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(collect);;
        personList().stream().forEach((P) -> StringUtils.join(P.getAge(), ","));
        personList.stream().forEach((P) -> StringUtils.join(P.getAge(),","));

    }

    @Test
    public void testLists11(){
        ArrayList<Integer> integers = Lists.newArrayList(1,2,2, 3,4,5);
        for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            Integer next = it.next();
            if (next == 1) {
               it.remove();
               continue;
           }
           if (next == 2) {
               it.remove();
               continue;
           }
        }
        System.out.println(integers);
        Integer a = 9;
        Integer b = 5;
        Integer c = 5;
        System.out.println(a <= b+c);
    }


}
