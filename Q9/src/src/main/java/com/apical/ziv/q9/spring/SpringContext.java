package com.apical.ziv.q9.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

	private static ClassPathXmlApplicationContext context;

	public static void start() {
		if (null == context) {
			context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
			context.start();
		}
	}

	public static <T> T getBean(Class<T> targetClass) {
		if (null == context) {
			start();
		}
		return context.getBean(targetClass);
	}

}
