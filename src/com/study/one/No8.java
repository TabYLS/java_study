package com.study.one;

/**
 * Created by YLS on 2017/5/21.
 */
public class No8 {

    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer("abc");
        StringBuffer stringBuffer2 = new StringBuffer("abc");

        boolean a = (stringBuffer1.equals(stringBuffer2));

        String empA = new String("abc");
        String empB = new String("abc");

        boolean b = (empA == empB);

        boolean c = (stringBuffer1 == stringBuffer2);

        System.out.println(a +" "+ b+"  "+c);
    }
}
