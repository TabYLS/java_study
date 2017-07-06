package com.study.java.test;

import java.util.ArrayList;

/**
 * Created by YLS on 2017/6/2.
 */
public class Test {

    public static void main(String[] args) {
        /*String str = "hi,你好";
        System.out.println(str.length());
        String strA = "aaa";
        String strA1 = "aaa";
        String strA2 = new String("aaa");
        System.out.println(strA.equals(strA1));
        System.out.println(strA.equals(strA2));
        System.out.println(strA == strA1);
        System.out.println(strA1 == strA2);
        
        Integer intA = 127;
        Integer intA1 = 127;
        Integer intA2 = new Integer("127");
        System.out.println(intA == intA1);
        System.out.println(intA1 == intA2);
        System.out.println(intA.equals(intA2));
        
        Integer m = 128;
		Integer n = 128;
		System.out.println(m.equals(n));*/
    	
    	ArrayList ai = new ArrayList();
    	ai.add(1);
    	ai.add("dd");
    	ai.add("d3");
    	ai.add("d4");

    	ArrayList ai1 = new ArrayList();
    	ai1.add("dd");
    	ai1.add("d4");
    	ai1.add("d3");
    	
    	ai1.iterator();
    	System.out.println(ai.contains(ai1));
    	System.out.println(ai.containsAll(ai1));
    	Test test = new Test();
    	test.test();
    }
    
    public void test(){
    	System.out.println(this.getClass().getClassLoader().getResourceAsStream("com/study/test.xml"));
    }
    
}
