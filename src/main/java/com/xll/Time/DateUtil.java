package com.xll.Time;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: xll
 * @Date: 2021/09/01/10:21
 * @Description:
 */
public class DateUtil {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(now.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);// 前一天
        System.out.println(cal);
        long times = cal.getTimeInMillis() - now.getTimeInMillis();
        System.out.println(times/1000);
        System.out.println(86400 - new DateTime().getSecondOfDay());
    }
}
