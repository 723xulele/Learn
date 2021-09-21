package com.xll.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xulele
 * @date 2021/09/21/23:51
 * mybaitsPlus代码生成器
 */


public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        //数据源地址
        String dataUrl = "jdbc:mysql://localhost:3306/Test?useUnicode=true&characterEncoding=utf8&useSSL=false";
        //数据源账户
        String username = "root";
        //数据源密码
        String password = "123456";
        //待生成表名
        String tableName = "student";
        //待生成文件名
        String fileName = "Student";

        String path = System.getProperty("user.dir") + "\\src\\main\\java";

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path);//输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("xulele");// 作者

        String name = fileName;
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        //gc.setEntityName("%sPo");
//        gc.setEntityName(name + "Po");
        gc.setDateType(DateType.ONLY_DATE);
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        //gc.setMapperName("%sMapper");
        gc.setMapperName("%sMapper");
        //gc.setXmlName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(dataUrl);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        ////strategy.setTablePrefix(new String[] { "tlog_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setEntityLombokModel(true); // 启用lombok增加实体类的get，set方法简化代码；如果不启用可以改为false
        strategy.setInclude(new String[]{tableName}); // 需要生成的表
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xll");
        /*pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");*/
        pc.setEntity("model.po");
        Map<String, String> packageInfo = new HashMap<>();
        packageInfo.put("Base" + ConstVal.SERVICE, ".com.xll.services");
        packageInfo.put("Base" + ConstVal.SERVICE_IMPL, ".com.xll.services.impl");
        packageInfo.put(ConstVal.ENTITY, ".com.xll.model.po");
        packageInfo.put(ConstVal.MAPPER, ".com.xll.mapper");
        Map pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.SERVICE_PATH, path + packageInfo.get(ConstVal.SERVICE).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, path + packageInfo.get(ConstVal.SERVICE_IMPL).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.ENTITY_PATH, path + packageInfo.get(ConstVal.ENTITY).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.MAPPER_PATH, path + packageInfo.get(ConstVal.MAPPER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.XML_PATH, System.getProperty("user.dir") + "\\src\\main\\resources\\mapper\\");
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}
