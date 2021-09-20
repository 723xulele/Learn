package com.xll.string;

/**
 * @Author: xll
 * @Date: 2021/08/23/9:09
 * @Description:
 */
public class StringTest {

    public static void main(String[] args) {
        String str = " dlkaskk j ";
        System.out.println(str.replace(" ","").length());
        System.out.println(str.replaceAll(" ","").length());
    }
}
