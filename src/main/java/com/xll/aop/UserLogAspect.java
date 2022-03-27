package com.xll.aop;

import com.xll.service.UserLogService;
import com.xll.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author xulele
 * @Date: 2022/03/27/14:06
 * @Description:
 */
@Component
@Aspect//切面 定义了通知和切点的关系
@Slf4j
public class UserLogAspect {


    @Resource
    private UserLogService userLogService;

    @Pointcut("@annotation(com.xll.aop.UserLog)")
    public void UserLog() {
    }

    @After("UserLog() && @annotation(userLog)")
    public void log(JoinPoint joinPoint, UserLog userLog) {

        ServletRequestAttributes attributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        /** 获取请求 */
        HttpServletRequest request = attributes.getRequest();

        HttpServletResponse response = attributes.getResponse();
        /** 获取服务名 */
        String serverName = request.getServerName();
        /** 获取服务端口号 */
        int serverPort = request.getServerPort();
        /** 获取请求url */
        String requestURI = request.getRequestURI();
        /** 获取请求参数 */
        Object[] args = joinPoint.getArgs();
        /** 获取访问IP */
        String ipAddress = IpUtil.getIpAddress(request);

        /** 保存日志 */
        com.xll.model.po.UserLog userOperatorLog = new com.xll.model.po.UserLog();
        userOperatorLog.setCreateTime(new Date());
        userOperatorLog.setUserId("1");
        userOperatorLog.setUserIp(ipAddress);
        userOperatorLog.setRequestParams(Arrays.toString(args));
        userOperatorLog.setRequestUrl(serverName + ":" + serverPort + requestURI);
        userLogService.saveUserLog(userOperatorLog);
    }
}
