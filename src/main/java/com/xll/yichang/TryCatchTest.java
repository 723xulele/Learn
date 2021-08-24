package com.xll.yichang;

import org.testng.annotations.Test;

/**
 * @Author: xll
 * @Date: 2021/08/23/17:58
 * @Description: 异常捕获的是
 */
public class TryCatchTest {

    @Test
    public void testTryCatch(){
        int a = 1;
        int b = 5;

        try {
            if(a > b ){
                System.out.println("a > b");
            }
            if(b > a){
                System.out.println("b > a");
            }
        } catch (Exception e) {
            System.out.println("出错");
            e.printStackTrace();
        }
    }
}
