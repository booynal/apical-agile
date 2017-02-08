/**
 * ShapeCommandCreator.java
 */
package com.apical.ziv.q9.commands.creators;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.commands.LoadFileCommand;
import com.apical.ziv.q9.commands.OverlapCommand;
import com.apical.ziv.q9.commands.ShapeCommand;
import com.apical.ziv.q9.consts.CommandTypeConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.shapes.creators.PointCreator;

/**
 * @author ziv
 *
 */
@Component
public class LoadFileCommandCreator extends AbstractCommandCreator {

	@Override
	public boolean isSupport(String input) {
		String temp = StringUtils.trimToEmpty(input);
		if(CommandTypeConsts.isLoadFile(temp)){
			return true;
		}else{
			return false;
		}
		
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
