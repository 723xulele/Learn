package com.xll.service.impl;

import com.xll.service.FileUploadService;
import com.xll.utils.RegexUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * @Date: 2021/09/15/16:15
 * @Description:
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {

        String fileSuffix = fileSuffix(multipartFile);
        if (!(fileSuffix.equals("txt") || (fileSuffix.equals("png"))) ) {
            log.error("文件格式不符合要求");
            return "error";
        }

        if (multipartFile.isEmpty()) {
            log.error("上传文件为空");
            return "error";
        }
        System.out.println(multipartFile.getOriginalFilename());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));

        List<String> collect = bufferedReader.lines().filter(mobile -> RegexUtil.validateMobile(mobile) == true).collect(toList());
        System.out.println(collect.size());
        System.out.println(collect);
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

    @Override
    public void testFile() throws IOException {
        String path = System.getProperty("user.dir");
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        FileWriter fw = null;
        File file = new File(path, "hello.txt");
        //判断路径是否存在，如果不存在就创建一个
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
        List<String> collect = bufferedReader.lines().collect(toList());
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(collect);
        System.out.println(collect.size());
        try {
            //2.提供FileWriter的对象，用于数据的写出
            //FileWriter(file,append)第二个参数，append是true则在后面添加，是false就覆盖
            fw = new FileWriter(file,true);
            for (String s : list) {
                fw.write(s.concat("\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw!=null)
                    //4.流资源的关闭
                    fw.close();
                System.out.println(file.delete());
            } catch (IOException e) {
                e.printStackTrace();
            }
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
