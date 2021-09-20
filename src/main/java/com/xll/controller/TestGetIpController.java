package com.xll.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xll
 * @Date: 2021/08/26/16:11
 * @Description:
 */
@RestController
@Slf4j
public class TestGetIpController {


    @Resource
    private StringRedisTemplate stringRedisTemplate;
//    @Resource
//    private Redisson redisson;
    @GetMapping("getIpAddr")
    public String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

//    @GetMapping("/tryLock")
//    public String tryLock() {
//        int total = Integer.parseInt(stringRedisTemplate.opsForValue().get("total"));
//        if (total > 0) {
//            total -= 1;
//            stringRedisTemplate.opsForValue().set("total",String.valueOf(total));
//            log.info("扣减成功, 剩余: " + total);
//        } else {
//            log.info("扣减失败, 剩余不足");
//        }
//        return "完成";
//    }

//    @GetMapping("/tryLock")
//    public String tryLock() {
//        String lockKey = "xll";
//        RLock rLock =   redisson.getLock(lockKey);
//        try {
//            rLock.lock(30, TimeUnit.SECONDS);
//            int total = Integer.parseInt(stringRedisTemplate.opsForValue().get("total"));
//            if (total > 0) {
//                total -= 1;
//                stringRedisTemplate.opsForValue().set("total",String.valueOf(total));
//                log.info("扣减成功, 剩余: " + total);
//            } else {
//                log.info("扣减失败, 剩余不足");
//            }
//        } finally {
//            rLock.unlock();
//        }
//        return "完成";
//    }
}
