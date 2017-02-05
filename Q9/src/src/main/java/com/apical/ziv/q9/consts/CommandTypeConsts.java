/**
 * CommandTypeConsts.java
 */
package com.apical.ziv.q9.consts;

/**
 * @author ziv
 *
 */
public class CommandTypeConsts {

	public static final String EXIT = "exit";
	public static final String HELP = "help";

	public static boolean isExit(String command) {
		return EXIT.equalsIgnoreCase(command);
	}

	public static boolean isHelp(String command) {
		return HELP.equalsIgnoreCase(command);
	}

}
