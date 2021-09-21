package com.xll.controller;

import com.xll.model.po.Student;
import com.xll.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date: 2021/09/14/14:50
 * @Description:
 */
@RestController
@RequestMapping("/student")
@Api(value = "/student", tags = "学生信息接口")
public class StudentController {

    @Resource
    private StudentService studentService;


    @GetMapping("/getAllStudent")
    @ApiOperation(value = "查询所有学生接口")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/addStudent")
    @ApiOperation(value = "新增学生接口")
    public void addStudent(@RequestBody(required = true) Student student) {
       studentService.addStudent(student);
    }

}
