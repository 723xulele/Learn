package com.xll.meijv;

import lombok.Getter;

/**
 * @Author: xll
 * @Date: 2021/08/23/9:17
 * @Description:
 */
@Getter
public enum DemoEnums {

    NORMAL(0, "正常"),
    ABNORMAL(1, "异常");
    private Integer code;
    private String value;

    DemoEnums(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public static DemoEnums find(Integer code) {
        for (DemoEnums instance : DemoEnums.values()){
            if(instance.getCode().equals(code)){
                System.out.println(instance);
                return instance;
            }
        }
        return null;
    }
}
