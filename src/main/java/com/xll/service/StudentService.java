package com.xll.service;

import com.xll.model.po.Student;

import java.util.List;

/**
 * @Date: 2021/09/14/14:40
 * @Description:
 */
public interface StudentService {

    //获取所有的学生
    List<Student> getAllStudent();

    //新增学生
    void addStudent(Student student);

    Student getStudentById(Integer id);
}
