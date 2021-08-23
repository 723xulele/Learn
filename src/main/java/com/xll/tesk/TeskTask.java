package com.xll.tesk;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: xll
 * @Date: 2021/08/23/9:25
 * @Description: 定时任务
 */
@Slf4j
@Component
@EnableScheduling
public class TeskTask {

    @Scheduled(cron = "0 0/2 * * * ?") //每两分钟执行一次
    public void testTask(){
        log.info("定时任务开始执行");
        System.out.println(new DateTime() + "定时任务执行");
    }
}
