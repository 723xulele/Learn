package com.xll.model.po;

import lombok.Data;

/**
 * @Author: xll
 * @Date: 2021/08/24/14:50
 * @Description:
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

