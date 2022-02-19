package com.xll.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xll.model.po.Person;
import com.xll.model.po.Warn;
import com.xll.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author: xll
 * @Date: 2021/08/17/14:19
 * @Description: 学习Stream的基础使用
 */
@Slf4j
public class StreamTest {

    public static  List<Person> personList(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("小明",20, DateUtil.deleteDate(new Date(),0L)));
        list.add(new Person("小明",20,DateUtil.deleteDate(new Date(),2L)));
        list.add(new Person("小红",15,DateUtil.deleteDate(new Date(),3L)));
        list.add(new Person("小李",25,DateUtil.deleteDate(new Date(),4L)));
        list.add(new Person("小陈",30,DateUtil.deleteDate(new Date(),5L)));
        list.add(new Person("小王",25,DateUtil.deleteDate(new Date(),6L)));
        return list;
    }

    @Test
    public void testStream(){
        List<Person> list = StreamTest.personList();
        /**stream() 将集合转换为流 */
        Stream<Person> stream = list.stream();
        System.out.println(stream);
    }
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**collect(toList()) 可以把流转换为 List 类型 */
    @Test
    public void testFilter(){
        List<Person> list = StreamTest.personList();
        System.out.println(list);
        List<Person> collect2 = list.stream().filter(distinctByKey(Person::getName)).collect(toList());
        System.out.println(collect2);
//        List<Person> collect3 = collect2.stream().filter(distinctByKey(Person::getAge)).collect(toList());
//        System.out.println(collect3);
//        List<Person> collect = list.stream().filter(person -> person.getAge() == 25).collect(toList());
//        System.out.println(collect);
//        /**[Person(name=小李, age=25), Person(name=小王, age=25)] */
//        List<Person> collect1 = list.stream().filter(person -> person.getAge() >= 25).collect(toList());
//        System.out.println(collect1);
//        /**[Person(name=小李, age=25), Person(name=小陈, age=30), Person(name=小王, age=25)]*/
    }


    /**distinct()
     *去除重复元素 该方法的实现依赖于实体类中的equals()方法来实现
     */
    @Test
    public void testDistinct(){
        List<Person> list = StreamTest.personList();
        List<Person> personCollect = list.stream().distinct().collect(toList());
        System.out.println(personCollect);
    }


    /**
     * sorted()排序
     * 如果流中的元素实现了Comparable接口马,有自己的排序规则,即可直接调用sorted()方法实现排序
     * 反之需要在sorted((T,T) -> int)实现Comparable接口
     */
    @Test
    public void testSort(){
        List<Person> list = StreamTest.personList();
        List<Person> collect = list.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge()).collect(toList());
        System.out.println(collect);

        /**[Person(name=小陈, age=30), Person(name=小李, age=25), Person(name=小王, age=25), Person(name=小明, age=20), Person(name=小明, age=20), Person(name=小红, age=15)] */
        List<Person> collect1 = list.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(toList());
        System.out.println(collect1);
        /**[Person(name=小红, age=15), Person(name=小明, age=20), Person(name=小明, age=20), Person(name=小李, age=25), Person(name=小王, age=25), Person(name=小陈, age=30)] */
    }


    /**
     * limit(long n)返回前n个元素 若n大于集合本身大小,将返回全部信息
     */
    @Test
    public void testLimit(){
        List<Person> list = StreamTest.personList();
        List<Person> personCollect = list.stream().limit(3).collect(toList());
        System.out.println(personCollect);
        /**[Person(name=小明, age=20), Person(name=小明, age=20), Person(name=小红, age=15)] */
        List<Person> personCollect1 = list.stream().limit(10).collect(toList());
        System.out.println(personCollect1);
        /**若n大于集合本身大小,将返回全部信息 */
        List<Person> personCollect2 = list.stream().limit(5).distinct().collect(toList());
        System.out.println(personCollect2);
        /**[Person(name=小明, age=20), Person(name=小红, age=15), Person(name=小李, age=25), Person(name=小陈, age=30)] */
    }


    /**
     *skip(long n) 去除前n个元素,若n大于list原始大小,则返回空集合
     * ship()用在limit()前面.可先去除几个元素,再返回剩余的前几个元素
     * limit()用在ship()前面,先返回前几个元素,再去除几个元素
     */
    @Test
    public void testSkip(){
        List<Person> list = StreamTest.personList();
        List<Person> personCollect = list.stream().skip(10).collect(toList());
        System.out.println(personCollect);
        /**[Person(name=小王, age=25)] */
    }

    /**
     * map(T -> R)
     * 将流中的每一个元素T映射为R (类似于类型转换)
     */
    @Test
    public void testMapTR(){
        List<Person> list = StreamTest.personList();
        System.out.println(list.stream().distinct().collect(toList()));
        List<Integer> collectAge = list.stream().map(Person::getAge).distinct().collect(toList());
        System.out.println(collectAge);
        /**[20, 20, 15, 25, 30, 25] */
        List<String> collectName = list.stream().map(Person::getName).distinct().collect(toList());
        System.out.println(collectName);
        /**[小明, 小明, 小红, 小李, 小陈, 小王] */
    }

    /**
     * flat(T -> Stream(R))
     * 将流中的每一个元素T映射为一个流,再把每一个流连接为一个流
     * 首先在map()方法中分割字符串元素,此时类型为Stream<String[]>,所以需要用flatMap()方法,先使用Arrays :: stream
     * 将每一个String[]元素变成一个Stream<String>流,然后flatMap会将每一个流连接成为一个流,最终返回需要的Stream<String>
     */
    @Test
    public void testFlatMap(){
        List<String> list = new ArrayList();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");
        List<String> collect = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
        System.out.println(collect);
        /**[aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii] */
    }


    /**
     * anyMatch()
     * 流中是否存在一个元素匹配给定的 T -> boolean条件
     */
    @Test
    public void testAnyMach(){
        List<Person> list = StreamTest.personList();
        boolean resultName = list.stream().anyMatch(p -> p.getName().equals("小红"));
        System.out.println(resultName);
        /**true */
        boolean resultAge = list.stream().anyMatch(p -> p.getAge() < 10);
        System.out.println(resultAge);
        /**false */
    }


    /**
     * allMatch()
     * 流中的所有元素是否都匹配给定的 T -> boolean条件
     */
    @Test
    public void testAllMatch(){
        List<Person> list = StreamTest.personList();
        boolean resultAge1 = list.stream().allMatch(p -> p.getAge() > 20);
        System.out.println(resultAge1);
        /**false */
        boolean resultAge2 = list.stream().allMatch(p -> p.getAge() >= 10);
        System.out.println(resultAge2);
        /**true */
    }


    /**
     * noMatch()
     * 流中的所有元素是否存在不匹配给定的 T -> boolean条件
     * 与anyMatch() 相反
     */
    @Test
    public void testNoMatch(){
        List<Person> list = StreamTest.personList();
        boolean resultAge = list.stream().noneMatch(p -> p.getAge() > 40);
        System.out.println(resultAge);
        /**true */
    }


    /**
     * findAny() 找到其中一个元素
     * 使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素
     * 返回的是Optional<T>对象,它是一个容器类
     */
    @Test
    public void testFindAny(){
        List<Person> list = StreamTest.personList();
        Optional<Person> any = list.stream().findAny();
        System.out.println(any);
        /**Optional[Person(name=小明, age=20)] */
    }


    /**
     * findFirst() 找到第一个元素
     * 返回的是Optional<T>对象,它是一个容器类
     */
    @Test
    public void testFindFirst(){
        List<Person> list = StreamTest.personList();
        Optional<Person> first = list.stream().findFirst();
        System.out.println(first);
        /**Optional[Person(name=小明, age=20)] */
    }


    /**
     * count() 返回流中的元素的个数
     */
    @Test
    public void testCount(){
        List<Person> list = StreamTest.personList();
        long count = list.stream().count();
        System.out.println(count);
        /**6 */
        long count1 = list.stream().filter(p -> p.getAge() >= 20).count();
        System.out.println(count1);
        /**3 */
    }


    /**
     *reduce((T,T) -> T) 用于组合流中的元素进行求和 求积 求最大值 求最小值
     */
    @Test
    public void testReduce(){
        List<Person> list = StreamTest.personList();
        /**求和 */
        Integer resultAdd1 = list.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);
        System.out.println(resultAdd1);
        Integer resultAdd2 = list.stream().map(Person::getAge).reduce(0,Integer::sum);
        System.out.println(resultAdd2);
        /**135 */

        /**求积 */
        Integer resultMulti1 = list.stream().map(Person::getAge).reduce(1, (a, b) -> a * b);
        System.out.println(resultMulti1);
        Integer resultMulti2 = list.stream().map(Person::getAge).reduce((a,b) -> a * b).get();
        System.out.println(resultMulti2);
        /**112500000*/

        /**求最值 */
        Integer resultMax = list.stream().map(Person::getAge).reduce(Integer::max).get();
        System.out.println(resultMax);
        /**30 */

        /**最小值 */
        Integer resultMin = list.stream().map(Person::getAge).reduce(Integer::min).get();
        System.out.println(resultMin);
        /**15 */
    }

    /**
     *filter和foreach
     */

    @Test
    public void test5() {
        List<Person> list = StreamTest.personList();
        list=list.subList(0,2);
        list.stream().filter((s) -> s.getName().length() > 1)
                .forEach((s) -> s.setName(s.getName().substring(0, 1) + "..."));
        System.out.println(list);
    }

    /**
     * Collectors.joining() 的用法
     */
    @Test
    public void testCollectors() {
        List<Person> list = StreamTest.personList();
        String collectName = list.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(collectName);
        if (list.size() > 2) {
            list  = list.subList(0,2);
        }
        String str = "dasd dadasda dasd";
        System.out.println(str.length()>9);
        list.stream().filter((P) -> P.getAge() > 20)
                        .forEach((P) -> P.setName(P.getName().substring(0,1) + "..."));
        System.out.println(list);
    }

    @Test
    public void test232312() {
        String string = null;
        String[] stringSourceList = null;
        for (String s : stringSourceList) {
            System.out.println(s);
        }
    }

    @Test
    public void test23231221321() {
        String string = "[{\"contentId\":1,\"warnContent\":\"撞墙检测\"},{\"contentId\":2,\"warnContent\":\"早恋检测\"}]";
        List<Warn> warns = (List<Warn>) JSONArray.parseArray(string, Warn.class);
        for (Warn w : warns) {
            System.out.println(w.getWarnContent());
        }
        String string1 = "{\"contentId\":1,\"warnContent\":\"撞墙检测\"}";
        Warn warn = JSONObject.parseObject(string1, Warn.class);
        log.info(warn.getWarnContent());
        System.out.println(warn.getWarnContent());



    }

}

