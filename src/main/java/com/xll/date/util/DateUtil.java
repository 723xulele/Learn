package com.xll.date.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xll
 * @Date: 2021/08/24/16:57
 * @Description: 日期工具类
 */
public class DateUtil {

    /**
     * Date类型时间转为String类型时间
     * @param format 要返回的日期格式
     * @return String类型时间
     */
    public static String currentDateByFormat(String format,Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * String类型时间转为Date类型时间
     * 需保证format和stringDate类型一致,不然会出错,原因不明
     * @param format 需要转换的日期格式
     * @param stringDate String类型时间
     * @return
     */
    public static Date parseDate(String format,String stringDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(stringDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
