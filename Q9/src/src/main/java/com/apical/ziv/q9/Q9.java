/**
 * Q9.java
 */
package com.apical.ziv.q9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.spring.SpringContext;

/**
 * @author ziv
 *
 */
@Component
public class Q9 {

	@Autowired
	private CommandHandler commandHandler;

	public static void main(String[] args) {
		SpringContext.start();
		SpringContext.getBean(Q9.class).launch();
	}

	private void launch() {
		commandHandler.handle();
	}
}
