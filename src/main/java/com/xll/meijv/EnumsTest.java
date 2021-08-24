package com.xll.meijv;

import org.testng.annotations.Test;

/**
 * @Author: xll
 * @Date: 2021/08/23/9:20
 * @Description:
 */
public class EnumsTest {

    @Test
    public void getEnums(){
        Integer code = DemoEnums.NORMAL.getCode();
        System.out.println(code);
    }
}
