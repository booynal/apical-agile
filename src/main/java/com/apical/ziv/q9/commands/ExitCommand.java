/**
 * ExitCommand.java
 */
package com.apical.ziv.q9.commands;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
@Component
public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.err.println("Program will be exited.");
		System.exit(0);
	}

}
