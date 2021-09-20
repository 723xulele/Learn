package com.xll.model.po;

import lombok.Data;

/**
 * @Date: 2021/09/04/23:11
 * @Description:
 */
@Data
public class Cat {

    private String name  = "招财猫";
    public void hi () {

        //System.out.println("hi" + name);
    }
    public void cry () {
        System.out.println("cry" + "喵喵叫");
    }

    public Cat(String name) {
        this.name = name;
    }
    public Cat() {}
}
