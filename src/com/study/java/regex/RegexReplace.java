package com.study.java.regex;

import org.junit.Test;

/**
 * Created by YLS on 2017/5/29.
 */
public class RegexReplace {

    /**
     * 将字符串中的数组替换成#，数字连续出现5次以上。
     */
    @Test
    public void replace1(){
        String str = "ade4232wer1389980000ty1234564uiod234345675f";
        String replacement = "#";
        String regex = "\\d{5,}";
        str = str.replaceAll(regex,replacement);
        System.out.println(str);
    }

    /**
     * $ 获取前面那个规则的组
     */
    @Test
    public void replace2(){
        String str = "erkktyqqquizzzzzo";//将叠词替换成$.  //将重叠的字符替换成单个字母。zzzz->z
        String regex = "(.)\\1+";//第一个是任意字符，第二个和第一个一致（按照叠词切割，大于等于一次）
        String replacement = "$1";//获取前面规则的第一个组

        str = str.replaceAll(regex,replacement);
        System.out.println(str);
    }

}
