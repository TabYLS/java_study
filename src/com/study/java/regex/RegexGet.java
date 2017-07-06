package com.study.java.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YLS on 2017/5/29.
 */
public class RegexGet {

    /**
     * 为了理解String的matches方法的底层，所以先用这个方法来帮助理解Patten类
     */
    @Test
    public void testMatches(){
        String str = "123456";
        String regex = "[1-9]\\d{4,14}";
        //1. 将规则封装成对象
        Pattern pattern = Pattern.compile(regex);
        //2. 让正则对象和要作用的字符串相关联。获取匹配器对象。
        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());
    }

    @Test
    public void get1(){

        String str = "jin tian fang jia la! chu qu wan ba ,ge wei!";
        String regex = "\\b[a-zA-Z]{3}\\b";//将连续三个字母组成的单词取出来

        //1. 将规则封装成对象
        Pattern pattern = Pattern.compile(regex);

        //2. 让正则对象和要作用的字符串相关联。获取匹配器对象(然后就有了对象的各种操作)。
        Matcher m = pattern.matcher(str);

        //m.find();将规则作用到字符串上，并进行符合规则的子串查找。
        //m.group());用于获取匹配后结果。

        while (m.find()){//先找
            System.out.println(m.group());//再取
            System.out.println("索引.............");
            System.out.println(m.start()+"..........."+m.end());
        }
    }
}
