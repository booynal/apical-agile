/**
 * LoadFileCommandCreator.java
 */
package com.apical.ziv.q9.commands.creators;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.commands.LoadFileCommand;
import com.apical.ziv.q9.consts.CommandTypeConsts;
import com.apical.ziv.q9.interfaces.Command;

/**
 * @author ziv
 *
 */
@Component
public class LoadFileCommandCreator extends AbstractCommandCreator {

	@Override
	public boolean isSupport(String input) {
		return CommandTypeConsts.isLoadFile(StringUtils.trimToEmpty(input));

	}

	@Override
	public Command create(String input) {
		return new LoadFileCommand(input);
	}

	@Override
	public int index() {
		return 104;
	}

}
