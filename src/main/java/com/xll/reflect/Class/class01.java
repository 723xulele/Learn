package com.xll.reflect.Class;

/**
 * @Date: 2021/09/13/23:01
 * @Description:
 */
public class class01  {

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * ClassLoader
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        //Cat cat = new Cat();


        /**
         * ClassLoader类,仍然是通过ClassLoader类加载Cat类的Class对象
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */

        //3.对于某个类的Class类对象,在内存中只有一份,因为类只加载一次
        Class<?> clz1 = Class.forName("com.xll.model.po.Cat");
        System.out.println(clz1.hashCode());
        Class<?> clz2 = Class.forName("com.xll.model.po.Cat");
        System.out.println(clz2.hashCode());
        Class<?> clz3 = Class.forName("com.xll.model.po.Person");
        System.out.println(clz3.hashCode());

    }
}
