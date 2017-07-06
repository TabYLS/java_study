package com.study.java.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午3:17:57
 *
 * @version 1.0
 * 
 */
public class TicketInvocationHandler implements InvocationHandler {

	private Object obj;
	public TicketInvocationHandler(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("代理。。。。。执行之前");
		//通过反射调用方法
		Object object = method.invoke(obj, args);
		System.out.println("代理........执行之后");
		return object;
	}

}
