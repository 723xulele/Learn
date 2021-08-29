package com.xll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: xll
 * @Date: 2021/08/26/16:22
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.xll")
public class LearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class,args);
    }
}
