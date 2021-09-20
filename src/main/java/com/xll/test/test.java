package com.xll.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xll.model.po.Student;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/09/17/8:54
 * @Description:
 */
public class test {

    /**
     * RequestBody 接受参数的形式 是一个Json字符串
     */
    @Test
    public void testJson(){

        Student s = new Student();
        s.setAddress("address");
        s.setBirthday(new Date());
        s.setId(1);
        s.setSex("sex");
        s.setUser_name("user_name");
        Map<String,Object> map = new HashMap<>();
        map.put("address",s.getAddress());
        map.put("birthday",s.getBirthday());
        map.put("id",s.getId());
        map.put("sex",s.getSex());
        map.put("user_name",s.getUser_name());
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSONObject.toJSONString(s));
    }

    @Test
    public void test() {
        String string = "ABC5156163_1";
        try {
            String abc = string.replaceAll("ABC", "");
            long l = Long.parseLong(abc);
            System.out.println(l);
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        System.out.println(111);
    }
}
