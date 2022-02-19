package com.xll.utils;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date: 2021/09/26/19:47
 * @Description:
 * 正则表达式工具类
 */
public class ShortCodeUtil {

    public static boolean isNumber(String string) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(string);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(ShortCodeUtil.isNumber("245452"));
    }
}
