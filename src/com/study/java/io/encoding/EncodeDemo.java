package com.study.java.io.encoding;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月17日 下午3:27:51
 *
 * @version 1.0
 * 
 */

/*
编码：字符串变成字节数组。
String-->byte[];  str.getBytes(charsetName);

解码：字节数组变成字符串。
byte[] -->String: new String(byte[],charsetName);


能够识别中文的码表只有utf-8和gbk
如果编码的时候编错了，解码肯定不能成功

一：如果中文采用的gbk编码，然后解码的时候就用iso8859-1，则会发生乱码的现象，但是，此时并不是无解，如果要还原，则需要再编译得到码，然后再用这个码通过gbk解码就可以解码成功
	String s = "你好";
	byte[] b2 = s.getBytes("gbk");//指定gbk编码，从而得到码
	System.out.println(Arrays.toString(b2));//可以看到查询码表得到的结果：[-60, -29, -70, -61]
	
	String s1 = new String(b2, "iso8859-1");//通过iso8859-1解码，但是iso8859-1并不识别中文，所以出现乱码
	System.out.println(s1);
	
	byte[] b3 = s1.getBytes("iso8859-1");//通过iso8859-1进行编码，得到码：[-60, -29, -70, -61]
	String s2 = new String(b3,"gbk");//再次通过gbk解码从而正确的解码
	System.out.println(s2);
	注意：这个原理可以解决客户端的数据通过tomcat之后到后台发生乱码的现象，因为tomcat采用的编码是iso8859-1,所以如果浏览器和后台采用的编码是gbk或者是utf-8的时候就会发生乱码的现象，此时用这个原理就可以解释这个现象并且解决这个问题
	
二：如果中文采用的gbk编码，然后解码的时候就用utf-8，则会发生乱码的现象，而此时和一的情况又不一样了，
	此时再采用一的解决方式则无法解决了，因为utf-8和gbk都能够识别中文，因此在用utf-8解码之后得到乱码，然后又用utf-8编码，
	则会从码表中得到另外一个字符，因为utf-8是可以识别中文的
	String s = "你好";
	byte[] b2 = s.getBytes("gbk");//指定编码
	System.out.println(Arrays.toString(b2));
	
	String s1 = new String(b2, "utf-8");
	System.out.println(s1);
	
	byte[] b3 = s1.getBytes("utf-8");
	String s2 = new String(b3,"gbk");
	System.out.println(s2);
*/
public class EncodeDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "你好";
		byte[] b2 = s.getBytes("gbk");//指定编码
		System.out.println(Arrays.toString(b2));
		
		String s1 = new String(b2, "utf-8");
		System.out.println(s1);
		
		byte[] b3 = s1.getBytes("utf-8");
		String s2 = new String(b3,"gbk");
		System.out.println(s2);
	}

}
