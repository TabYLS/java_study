package com.study.java.regex;

import org.junit.Test;

/**
 * Created by YLS on 2017/5/28.
 */
public class RegexSplit {

    @Test
    public void splitDemo1(){
        String a = "ye   lin    sheng      yao  nu   li    aaaa       ";
        String regexA = " +";//按空格拆分，可以有任意多个空格
        String[] results = a.split(regexA);
        System.out.println(results.length);
        for(String result:results){
            System.out.println(result);
        }

    }

    @Test
    public void splitDemo2(){
        String a = "ye.lin.sheng.yao.nu.li.aaaa.";
        String regexA = "\\.";//按点拆分，点也是正则表达式的一个特殊符号
        String[] results = a.split(regexA);
        for(String result:results){
            System.out.println(result);
        }

    }

    @Test
    public void splitDemo3(){
        String a = "D:\\aaa\\test.txt";
        String regexA = "\\\\";//按反斜杠拆分，反斜杠也是正则表达式的一个特殊符号
        String[] results = a.split(regexA);
        for(String result:results){
            System.out.println(result);
        }

    }
    /**
     * 按照叠词完成切割。
     * 为了可以让规则的结果被重用可以将规则封装成一个组。
     * 用()完成。组的出现都有编号。从1开始。 想要使用已有的组可以通过  \n(n就是组的编号)的
     */
    @Test
    public void testGroup(){
        String a = "adfdddfefggiogewwwwwsagre";
        String regexA = "(.)\\1+";//按叠词拆分，得引用组的概念;加号表示可以有大于等于一个的叠词
        String[] results = a.split(regexA);
        for(String result:results){
            System.out.println(result);
        }
    }
}
