package com.xll.date.test;

import com.xll.date.util.DateUtil;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: xll
 * @Date: 2021/08/24/16:10
 * @Description: 日期类方法
 */
public class DateTest {

    /**
     * Date类型时间转换为String类型时间
     * 获取当前日期 格式为 年月日 返回值类型为String
     * 入参格式: yyyy-MM-dd
     * 入参格式为 yyyy-MM-dd HH:mm:ss
     */
    @Test
    public void getCurretnDate() {
        String stringDateDay = DateUtil.currentDateByFormat("yyyy-MM-dd",new Date());
        System.out.println(stringDateDay);
        /**2021-08-25 */

        String stringDateTime = DateUtil.currentDateByFormat("yyyy-MM-dd HH:mm:ss",new Date());
        System.out.println(stringDateTime);
        /**2021-08-25 09:15:58 */

    }

    /***
     * String类型时间转换为Date类型时间
     */
    @Test
    public void stringParseDate() {
        Date dateMin = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", "2021-08-18 12:05:35");
        Date dateMax = DateUtil.parseDate("yyyy-MM-dd", "2021-08-20");
        System.out.println(dateMin);
        /**Wed Aug 18 12:05:35 GMT+08:00 2021 */

       /**比较Date类型时间先后 Date.before()  */
        System.out.println(dateMin.before(dateMax));
        /**true */
    }

}
