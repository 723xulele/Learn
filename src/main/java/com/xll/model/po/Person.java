package com.xll.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: xll
 * @Date: 2021/08/24/14:50
 * @Description:
 */
@Data
public class Person {
    private String name;
    private Integer age;
    private Date date;

    public Person(String name, Integer age,Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Person() {
    }

}

