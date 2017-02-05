/**
 * ExitCommandCreator.java
 */
package com.apical.ziv.q9.commands.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.commands.ExitCommand;
import com.apical.ziv.q9.consts.CommandTypeConsts;
import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
@Component
public class ExitCommandCreator extends AbstractCommandCreator {

	@Autowired
	private ExitCommand exitCommand;

	@Override
	public boolean isSupport(String command) {
		return CommandTypeConsts.isExit(command);
	}

	@Override
	public Command create(String command) {
		return exitCommand;
	}

	@Override
	public int index() {
		return 100;
	}

}
