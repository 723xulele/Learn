package com.xll.dao;

import com.xll.model.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2021/09/14/14:46
 * @Description:
 */
@Mapper
public interface StudentDao {

    //获取所有的学生
    List<Student> getAllStudent();

    //新增学生
    void addStudent(Student student);
}
