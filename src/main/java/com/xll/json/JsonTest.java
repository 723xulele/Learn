package com.xll.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author: xll
 * @Date: 2021/08/24/14:44
 * @Description: JSON使用
 */
public class JsonTest {

    /**
     * JSONObject.parseArray()
     * 该方法将字符串数据转换成集合对象
     */
    @Test
    public void jsonArray(){
        String str = "[{\"rptInfo\":[\"jG3lSuOO\",\"KPI_DATE\"]},{\"rptInfo\":[\"jG3lSuOO\",\"KPI_DATE\"]}]";
        JSONArray jsonArray = JSONObject.parseArray(str);
        System.out.println(jsonArray.size());
        /**2 */
        System.out.println(jsonArray);
        /**[{"rptInfo":["jG3lSuOO","KPI_DATE"]},{"rptInfo":["jG3lSuOO","KPI_DATE"]}] */


        List<Map> maps = JSONObject.parseArray(str, Map.class);
        System.out.println(maps.size());
        /**2 */
        System.out.println(maps);
        /**[{rptInfo=["jG3lSuOO","KPI_DATE"]}, {rptInfo=["jG3lSuOO","KPI_DATE"]}] */
    }
}
