package com.xll.reflect.Class;

import com.xll.model.po.Car;

import java.lang.reflect.Field;

/**
 * @Date: 2021/09/14/0:12
 * @Description:
 */
public class classs02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        String classPath = "com.xll.model.po.Car";
        //1.获取car类的Class对象
        //<?> 表示不确定的Java类型
        Class cls = Class.forName(classPath);
        //2.输出cls
        System.out.println(cls); //显示cls对象 是哪个类的Class对象 com.xll.model.po.Car
        System.out.println(cls.getClass());//输出cls运行类型 class java.lang.Class
        //3.得到包名
        System.out.println(cls.getPackage().getName());//com.xll.model.po
        //4.得到全类名
        System.out.println(cls.getName());
        //5.通过cls 创建对象实例
        Car car = (Car)cls.newInstance();
        System.out.println(car);
        //6. 通过反射获取属性
        Field brand = cls.getDeclaredField("brand");
        brand.setAccessible(true);
        System.out.println(brand.get(car)); //宝马
        //7.通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));//奔驰
        //8.可以得到所有的属性
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
