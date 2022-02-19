package com.xll.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xulele
 * @Date: 2021/11/09/9:53
 * @Description:
 */
public class RegexUtil {

    public static final String MOBILE_REGEX = "^[1]\\d{10}$";

    /**
     * 验证手机号码是否合法
     *
     * @param mobile
     *
     * @return
     */
    public static boolean validateMobile(String mobile) {
        return verify(mobile, MOBILE_REGEX);
    }

    /**
     * 验证内容和正则规则是否匹配
     *
     * @param content
     *            内容
     * @param regex
     *            正则规则
     * @return
     */
    public static boolean verify(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    public static void main(String[] args) {
        boolean flag = validateMobile("18691050273 ");
        System.out.println(flag);
    }
}
