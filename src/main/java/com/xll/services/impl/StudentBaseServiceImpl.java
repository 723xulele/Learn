package com.xll.services.impl;

import com.xll.model.po.Student;
import com.xll.mapper.StudentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xll.services.StudentBaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author xulele
 * @since 2021-09-22
 */
@Service
public class StudentBaseServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentBaseService {

}
