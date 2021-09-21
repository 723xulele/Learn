package com.xll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xll.model.po.Student;
import com.xll.service.StudentService;
import com.xll.services.StudentBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date: 2021/09/22/0:39
 * @Description:
 */
@Service
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentBaseService studentBaseService;
    @Override
    public List<Student> getAllStudent() {
        QueryWrapper qw = new QueryWrapper();
        return studentBaseService.list(qw);
    }

    @Override
    public void addStudent(Student student) {
        studentBaseService.save(student);
    }
}
