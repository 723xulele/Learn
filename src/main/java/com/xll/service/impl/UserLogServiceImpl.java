package com.xll.service.impl;

import com.xll.model.po.UserLog;
import com.xll.service.UserLogService;
import com.xll.services.UserLogBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xulele
 * @Date: 2022/03/27/16:03
 * @Description:
 */
@Service
public class UserLogServiceImpl implements UserLogService{

    @Resource
    private UserLogBaseService userLogBaseService;

    @Override
    public void saveUserLog(UserLog userLog) {
        if (userLog != null) {
            userLogBaseService.save(userLog);
        }
    }
}
