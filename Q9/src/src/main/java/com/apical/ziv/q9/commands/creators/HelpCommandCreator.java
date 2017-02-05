/**
 * HelpCommandCreator.java
 */
package com.apical.ziv.q9.commands.creators;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.commands.HelpCommand;
import com.apical.ziv.q9.consts.CommandTypeConsts;
import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
@Component
public class HelpCommandCreator extends AbstractCommandCreator {

	@Override
	public boolean isSupport(String command) {
		return CommandTypeConsts.isHelp(command);
	}

	@Override
	public Command create(String command) {
		return new HelpCommand();
	}

	@Override
	public int index() {
		return 101;
	}

}
