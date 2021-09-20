package com.xll;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

//    @Bean
//    public Redisson redisson () {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
//        return (Redisson) Redisson.create(config);
//    }
}
