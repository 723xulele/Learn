package com.xll.stream;

import lombok.Data;

/**
 * @Author: xll
 * @Date: 2021/08/17/14:18
 * @Description: 实体Person
 */
@Data
public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

}
