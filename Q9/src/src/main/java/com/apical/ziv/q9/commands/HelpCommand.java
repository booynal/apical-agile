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
		System.out.println("You can give the file path via -DinputFile=/file/to/path, and then program will read the file as console");
	}

}
