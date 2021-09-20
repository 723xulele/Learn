package com.xll.service.impl;

import com.xll.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * @Date: 2021/09/15/16:15
 * @Description:
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadFile(MultipartFile multipartFile) {

        String fileSuffix = fileSuffix(multipartFile);
        if (!(fileSuffix.equals("txt") || (fileSuffix.equals("png"))) ) {
            log.error("文件格式不符合要求");
            return "error";
        }

        if (multipartFile.isEmpty()) {
            log.error("上传文件为空");
            return "error";
        }

        //如果文件不为空，写入上传路径
        if (!multipartFile.isEmpty()) {

            String path = fileDir();

            //检验是否为图片
            boolean flag = isImage(multipartFile);

            //上传文件的目的路径
            if (flag) {
                //图片存放路路径
                path = path + "\\image";
            } else {
                //文件存放路径
                path = path + "\\file";
            }
            //上传文件名的文件名
            String filename = multipartFile.getOriginalFilename();

            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                if (flag) {
                    multipartFile.transferTo(new File(path + File.separator + filename));
                } else {
                    multipartFile.transferTo(new File(path + File.separator + filename));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return "success";
        } else {
            return "error";
        }
    }

    // 获取当前项目的路径
    public String fileDir() {
        return System.getProperty("user.dir");
    }

    //获取文件的后缀名
    String fileSuffix(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        return originalFilename.substring(originalFilename.indexOf(".") + 1);
    }

    // 上传文件是否是文件
    boolean isImage(MultipartFile multipartFile) {
        Image image = null;
        try {
            image = ImageIO.read(multipartFile.getInputStream());
            if (image == null || image.getWidth(null) <= 0 || image.getHeight(null) <= 0) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
