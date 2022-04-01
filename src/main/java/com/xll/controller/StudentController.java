package com.xll.controller;

import com.xll.aop.UserLog;
import com.xll.model.po.Student;
import com.xll.service.StudentService;
import com.xll.utils.JWTUtils;
import com.xll.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/09/14/14:50
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/student")
@Api(value = "/student", tags = "学生信息接口")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/login")
    @UserLog
    @ApiOperation(value = "学生登录")
    public String login(Integer id) {
        String token = null;
        Student student = studentService.login(id);
        if (student != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("id",student.getId());
            map.put("userName",student.getUserName());
            map.put("address",student.getAddress());
            token = JWTUtils.getToken(map);
        }
        return token;
    }

    @GetMapping("/getAllStudent")
    @UserLog
    @ApiOperation(value = "查询所有学生接口")
    public R<List<Student>> getAllStudent() {
        List<Student> allStudent = studentService.getAllStudent();
        return R.ok(allStudent);
    }

    @GetMapping("/getStudentById")
    @UserLog
    @ApiOperation(value = "根据ID查找学生")
    public R<Student> getAllStudentById(Integer id) {
        Student student = studentService.getStudentById(id);
        return R.ok(student);
    }

    @PostMapping("/addStudent")
    @ApiOperation(value = "新增学生接口")
    @UserLog
    public R<String> addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage(),e);
            throw e;

        }
        return R.ok();
    }

}
