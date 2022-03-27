package com.xll.stream;

/**
 * @Author xulele
 * @Date: 2022/03/14/15:25
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception{
        int a = 0b1001;
        System.out.println(123);
        /** 整数相除取模*/
        System.out.println(5/2);
        /** 如果有小数参与则按照浮点数相除计算*/
        System.out.println(5/2.0);
        /** 浮点数 / 0 则为无穷大 */
        System.out.println(5.0/0);
        /** 整数 / 0 则报错 */
        //System.out.println(5/0);

        /** 计算算数平方根 Math.sqrt(double d)*/
        System.out.println(Math.sqrt(16d));

        /** 实际上只有字符串字面量是共享的,而 + 或 subString 等操作得到的字符串并不共享 */
        String c = "111";
        String b = "11";
        String d = b + "1";
        System.out.println(c==d);
        System.out.println("111"==d);

        //String e = "abc";
        //System.out.println(e.codePointCount(0,1));
        //System.out.println(String.join("j","e","f","a"));
        //
        //
        ////Scanner scanner = new Scanner(System.in);
        ////System.out.println("111");
        ////String name = scanner.nextLine();
        ////System.out.println(name);
        ///** printf() %s 可代替字符串*/
        //System.out.printf("nihao %s",e);
        //System.out.println();
        ///** 整数位5位 小数位1位*/
        //System.out.printf("%5.1f",123.56);
    }



}
