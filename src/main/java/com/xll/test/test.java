package com.xll.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xll.model.po.Student;
import com.xll.utils.RegexUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Date: 2021/09/17/8:54
 * @Description:
 */
@Slf4j
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
        s.setUserName("user_name");
        Map<String,Object> map = new HashMap<>();
        //map.put("address",s.getAddress());
        //map.put("birthday",s.getBirthday());
        //map.put("id",s.getId());
        //map.put("sex",s.getSex());
        //map.put("user_name",s.getUserName());
        map.put("s",s);

        System.out.println(JSON.toJSONString(map));
        System.out.println(JSONObject.toJSONString(s));
    }
    @Test
    public void  test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);

        Map<Integer, Long> map =  list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map.size());
        for (Integer i : map.keySet()) {

            if (map.get(i) >= 1) {
                System.out.println(i);
            }
        }
        System.out.println(map);
        List<Integer> collect = list.stream().distinct().collect(toList());
        System.out.println(list);
        System.out.println(collect);
        System.out.println(RegexUtil.validateMobile("15112922793"));

    }

    @Test
    public void  testFile() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        FileWriter fw = null;
        File file = new File("hello.txt");
        file.createNewFile();
        FileInputStream input = new FileInputStream(file);
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


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
        List<String> collect = bufferedReader.lines().collect(toList());
        input.close();
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(collect);
        System.out.println(collect.size());
        System.out.println(file.delete());
    }

    @Test
    public void testString() {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a.equals(b));
        String str = "";
        List<String> list = Arrays.asList("A","B","C");
        String ss = String.join(",", list);
        // A,B,C
        System.out.println(ss);
        
    }

    @Test
    public void testBeansCopy(){
        Student student1 = new Student();
        student1.setSex("男");
        student1.setUserName("nihao");
        student1.setId(1);
        student1.setBirthday(new Date());
        student1.setAddress("咸阳");
        Student student2 = new Student();
        System.out.println("student1===>>>" + student2);
        System.out.println("student2===>>>" + student2);
        log.info("===>>>[Student]request:" + student1);
        BeanUtils.copyProperties(student1,student2);
        System.out.println(student1.equals(student2));
    }

    @Test
    public void testJsonObject() {
        String s = "sda";
        JSONObject obj =JSONObject.parseObject(s);
        System.out.println(obj.containsKey("a"));
        System.out.println(obj);
    }

//    @Test
//    public void testElement() {
//        Document doc = DocumentHelper.createDocument();
//        Element smil = doc.addElement("smil").addAttribute("xmlns", "http://www.w3.org/2000/SMIL20/CR/Language");
//        Element head = smil.addElement("head");
//        Element layout = head.addElement("layout");
//        layout.addElement("region").addAttribute("id", "Image").addAttribute("top", "0").addAttribute("left", "0")
//                .addAttribute("height", "50").addAttribute("width", "100").addAttribute("fit", "meet");
//        layout.addElement("region").addAttribute("id", "Text").addAttribute("top", "50").addAttribute("left", "0")
//                .addAttribute("height", "50").addAttribute("width", "100").addAttribute("fit", "meet");
//        Element bodyElement = smil.addElement("body");
//    }
    @Test
    public void test222(){
        String a = "123";
        String b = "456";
        log.info("开始时间 ：{} ，结束时间{} " ,b,a);
        System.out.println(a);
        Integer i= 20;
        System.out.println(i/10);
        System.out.println(i%10);
    }

    @Test
    public void test333() {
        Integer a = 20;
        Integer b = 1;
        BigDecimal value = new BigDecimal(0);
        BigDecimal value2 = new BigDecimal(0);
        System.out.println(ADivideBPercent(value, value2));
    }

    /**
     * a / b   计算百分比
     * @param a
     * @param b
     * @return eg:65.32%
     */
    @Test
    public  String ADivideBPercent(BigDecimal a,BigDecimal b){
        String percent =
                b == null ? "-" :
                        b.compareTo(new BigDecimal(0)) == 0 ? "-":
                                a == null ? "0.00%" :
                                        a.multiply(new BigDecimal(100)).divide(b,2,BigDecimal.ROUND_HALF_UP) + "%";
        return percent;
    }

    @Test
    public void test456() {
        Integer a = 0;
        a += 112;
        System.out.println(a);
        String aaa = null;
        aaa = "asas";
        System.out.println(aaa);
    }
    
    @Test
    public void a1() {

        List<Integer> channelIdList = Lists.newArrayList(1,2);
        List<Integer> list = Lists.newArrayList();
        List<Integer> collect = Stream.concat(channelIdList.stream(), list.stream()).collect(toList());
        System.out.println(collect.size());
        System.out.println(collect);
        Student student = new Student();
        Integer a = 0;
        System.out.println(a == 0);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        System.out.println(map.get(1));
        System.out.println(map.get(3) == null);

    }

    @Test
    public void a2() {

        List<Integer> channelIdList = Lists.newArrayList(1,2);
        List<Integer> list = Lists.newArrayList();
        List<Integer> collect = Stream.concat(channelIdList.stream(), list.stream()).collect(toList());
        System.out.println(collect.size());
        System.out.println(collect);
        Student student = new Student();
        Integer a = 0;
        System.out.println(a == 0);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        System.out.println(map.get(1));
        System.out.println(map.get(3) == null);

    }


}
