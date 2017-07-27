package com.study.java.jvm;
/**
* @author 叶林生 
* @date：2017年7月21日 上午11:18:22
* @version 1.0
* 
*/
public class Stack {
	
	
	public static void main(String[] args) {
		/*查看初始值
		 * */
		System.out.println("-Xmx=" + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
		System.out.println("free memory=" + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");
		System.out.println("total memory=" + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
		
		/*byte[] b = new byte[1 * 1024 * 1024];//分配了1M的内存空间给数组
		System.out.println("-Xmx=" + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
		System.out.println("free memory=" + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");
		System.out.println("total memory=" + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");*/
		
		byte[] b = new byte[121 * 1024 * 1024];//分配了1M的内存空间给数组
		System.out.println("-Xmx=" + Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
		System.out.println("free memory=" + Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");
		System.out.println("total memory=" + Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
		
		
	}

}
