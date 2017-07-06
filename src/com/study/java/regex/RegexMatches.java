package com.study.java.regex;

import org.junit.Test;

/**
 * Created by YLS on 2017/5/28.
 */
public class RegexMatches {

    /**
     * 运用正则表达式验证QQ号码是否合法，长度为5到15，只能是数字，不能以0开头
     */
    @Test
    public void check_qq(){
        String qq1 = "1234";
        String qq2 = "123405";
        String qq3 = "1234567890123456";
        String qq4 = "0123456";
        String qq5 = "123456j23";

        String regex = "[1-9][0-9]{4,14}";//定义规则:第一位是数字并且只能是0到9，第二位只要是数字就可以，第二位数可以出现4到14次

        boolean flag = qq2.matches(regex);
        if (flag)
            System.out.println("qq号码正确！");
        else
            System.out.println("qq号码不合法！");
    }

    /**
     * 字符类
     * [abc] a、b 或 c（简单类）
     * 规则中定义了对几个字符的识别就一定要几个，不能多也不能少
     * 至于规则如何定义可以灵活运用
     */
    @Test
    public void testRegString(){
        String a = "x";
        String regexA = "[aoc]";//只能识别一个字符，并且只能是a或o或c（都是小写）
        String b = "h";
        String regexB = "[agxh]";//只能识别一个字符，并且只能是a或g或x或h（都是小写）

        String c = "olk";
        String regexC = "[ogewac][lpc][k]";//只能识别三个字符：并且第一个只能是ogewac中的一个，第二个只能是lpc中的一个，第三个只能是k（都是小写）

        String d = "ok";
        String regexD = "[ogewac][a-z][A-Z]";//只能识别两个字符：别且第一个只能是ogewac中的一个，第二个是a到z中的任意一个（都是小写）

        boolean flagA = a.matches(regexA);
        System.out.println("flagA:"+flagA);

        boolean flagB = b.matches(regexB);
        System.out.println("flagB:"+flagB);

        boolean flagC = c.matches(regexC);
        System.out.println("flagC:"+flagC);

        boolean flagD = d.matches(regexD);
        System.out.println("flagD:"+flagD);
    }

    /**
     * 预定义字符类，预定义字符类在某种程度上可以代替字符类，简化了字符类的定义规则。
     */
    @Test
    public void testReg1(){

        String num1 = "a9";
        String regex1 = "[a-z]\\d";//第一个是a到z的字符，第二个是数字
        String num2 = "b3";
        String regex2 = "[a-z]\\D";//第一个是a到z的字符，第二个是非数字

        boolean flag1 = num1.matches(regex1);
        boolean flag2 = num2.matches(regex2);

        System.out.println("flag1:"+flag1);
        System.out.println("flag2:"+flag2);

    }

    /**
     * Greedy 数量词
     * @return
     */
    @Test
    public void testReg2(){
        String a = "a9";
        String regex1 = "[a-zA-Z]\\d?";//第一个只能是字母，第二个只能是数字，但是可以有也可以没有

        System.out.println(a.matches(regex1));

        String b = "a8";
        String regex2 = "[a-zA-Z]\\d*";
    }

    /**
     * 验证电话号码：13，15，18开头
     */
    @Test
    public void checkTel(){

        String tel = "13545747687";
        String regex = "1[358]\\d{9}";//第一个是1，第二个是358中的一个，剩下的都是数字并且长度应该为9
        System.out.println(tel.matches(regex));

    }


}
