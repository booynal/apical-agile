/**
 * HelpCommand.java
 */
package com.apical.ziv.q9.commands;

import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
public class HelpCommand implements Command {

	@Override
	public void execute() {
		System.out.println("This application can handle shape, such as clac area, or if a point is in a shape, and so on.");
	}

}
