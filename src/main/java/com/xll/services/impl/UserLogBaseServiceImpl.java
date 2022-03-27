package com.xll.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xll.mapper.UserLogMapper;
import com.xll.model.po.UserLog;
import com.xll.services.UserLogBaseService;
import org.springframework.stereotype.Service;

/**
 * @Author xulele
 * @Date: 2022/03/27/15:57
 * @Description:
 */
@Service
public class UserLogBaseServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements UserLogBaseService {
}
