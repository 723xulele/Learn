package com.xll.service.impl;

import com.xll.dao.StudentDao;
import com.xll.model.po.Student;
import com.xll.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date: 2021/09/14/14:41
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
}
