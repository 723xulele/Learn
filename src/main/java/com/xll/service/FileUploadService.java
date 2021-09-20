package com.xll.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Date: 2021/09/15/15:54
 * @Description: 文件上传到指定目录
 */
public interface FileUploadService {

    String uploadFile(MultipartFile multipartFile);
}
