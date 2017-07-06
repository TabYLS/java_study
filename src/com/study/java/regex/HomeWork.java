package com.study.java.regex;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YLS on 2017/5/29.
 */
public class HomeWork {

    /*到底用四种功能中的哪一个呢？或者哪几个呢？
    思路方式：
            1，如果只想知道该字符是否对是错，使用匹配。
            2，想要将已有的字符串变成另一个字符串，替换。
            3，想要按照自定的方式将字符串变成多个字符串。切割。获取规则以外的子串。
            4，想要拿到符合需求的字符串子串，获取。获取符合规则的子串。
     */

    /**
     * 需求：
     * 将下列字符串转成：我要学编程.
     */
    @Test
    public void work1(){
        String str = "我我...我我...我要..要要...要要...学学学....学学...编编编...编程..程.程程...程...程";
        //1.去掉点
        String regex1 = "\\.+";//去掉点，点可以是多个或者一个
        String replacement1 = "";//换成空字符串
        str = str.replaceAll(regex1,replacement1);
        System.out.println(str);

        String regex2 = "(.)\\1+";//第一个是任意字符，第二个和第一个一致
        String replacement2 = "$1";//获取前面规则的第一个组
        str = str.replaceAll(regex2,replacement2);
        System.out.println(str);
    }

    /**
     *
     * 192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30
     * 将ip地址进行地址段顺序的排序。
     *
     * 还按照字符串自然顺序，只要让它们每一段都是3位即可。
     * 1，按照每一段需要的最多的0进行补齐，那么每一段就会至少保证有3位。
     * 2，将每一段只保留3位。这样，所有的ip地址都是每一段3位。
     */
    @Test
    public void work2(){
        String ip = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";
        String regex1 = "(\\d+)";//连续的数字，而且数字需要被再次重复利用，所以应该分组
        String replacement1 = "00$1";//给高位补上最多的零
        ip = ip.replaceAll(regex1,replacement1);

        String regex2 = "0*(\\d{3})";//零可以没有或多个，数字是三个
        String replacement2 = "$1";//取第一个组
        ip = ip.replaceAll(regex2,replacement2);

        System.out.println(ip);

        String regex3 = " +";//一个或多个空格
        String[] results = ip.split(regex3);
        /*for (String result:results){
            System.out.println(result);
        }*/

        TreeSet<String> sortIP = new TreeSet<String>();
        for (String result : results){
            sortIP.add(result);
        }
        for (String sort : sortIP){
            String regex4 = "0*(\\d{1,})";
            String replacement4 = "$1";//取第一个组
            sort = sort.replaceAll(regex4,replacement4);
            System.out.println(sort);
        }

    }

    /**
     * 需求：对邮件地址进行校验。
     *
     * 13555adasd@qq.com
     * 13555adasd@qq.com..cn
     */
    @Test
    public void work3(){
        String one = "@";//1. 首先定位@符号
        String two = "[a-zA-Z0-9_]{6,12}@";//2. @符号之前的符号长度为6到12
                       //[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+
        String three = "[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){0,3}";//封装组重用
        String str = "13555adasd@qq.com";
        boolean result = str.matches(three);
        System.out.println(result);

    }

    /**
     * 网页爬虫1
     * 获取指定文档中的邮件地址。
     * 使用获取功能。Pattern  Matcher
     */
    @Test
    public void work4(){

        try {
            BufferedReader bufr = new BufferedReader(new FileReader("./src/com/study/java/regex/mail.txt"));
            String line = null;
            String mailreg = "\\w+@\\w+(\\.\\w+)+";

            Pattern pattern = Pattern.compile(mailreg);
            while ((line=bufr.readLine())!= null){
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    System.out.println(matcher.group());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 网页爬虫2
     * 获取页面中的信息
     */
    @Test
    public void work5(){
        try {
            URL url = new URL("http://localhost:8080/mail-test/mail.html");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            String mailreg = "\\w+@\\w+(\\.\\w+)+";

            Pattern pattern = Pattern.compile(mailreg);
            while ((line=bufferedReader.readLine())!= null){
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    System.out.println(matcher.group());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
