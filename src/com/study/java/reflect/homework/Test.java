package com.study.java.reflect.homework;

import java.lang.reflect.Method;

/**
* @author 叶林生 
* @date：2017年7月25日 下午5:27:11
* @version 1.0
* 
*/
public class Test {
	
	public static void main(String[] args) throws Exception {
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str));  // HELLO
        System.out.println(str);
    }

}
