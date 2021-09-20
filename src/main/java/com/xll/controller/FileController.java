package com.xll.controller;

import com.xll.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Date: 2021/09/15/16:07
 * @Description:
 */
@RestController
@RequestMapping("/file")
@Api(value = "/file", tags = "文件接口")
@Slf4j
public class FileController {

    @Resource
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {

       return fileUploadService.uploadFile(multipartFile);
    }


}
