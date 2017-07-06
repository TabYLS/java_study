package com.study.java.reflect.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月20日 下午3:21:27
 *
 * @version 1.0
 * 
 */
public class TestTicket {

	@Test
	public void test() {
		Ticket_Station ticket_Station = new Ticket_Station();
		ClassLoader classLoader = TestTicket.class.getClassLoader();
		TicketInvocationHandler h = new TicketInvocationHandler(ticket_Station);
		//Ticket ticket = (Ticket)Proxy.newProxyInstance(classLoader, new Class[]{Ticket.class}, h);
		Ticket ticket = (Ticket)Proxy.newProxyInstance(classLoader, ticket_Station.getClass().getInterfaces(), h);//gong
		ticket.buy();
	}

}
