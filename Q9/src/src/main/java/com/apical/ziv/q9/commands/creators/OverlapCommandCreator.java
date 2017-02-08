/**
 * ShapeCommandCreator.java
 */
package com.apical.ziv.q9.commands.creators;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class OverlapCommandCreator extends AbstractCommandCreator {

	@Override
	public boolean isSupport(String input) {
		String temp = StringUtils.trimToEmpty(input);
		if(CommandTypeConsts.isOverlap(temp)){
			temp=temp.replaceAll(CommandTypeConsts.OVERLAP, "");
			return ShapeTypeConsts.isShape(StringUtils.trimToEmpty(temp).split("\\s+", 2)[0]);	
		}else{
			return false;
		}
		
	}

	@Override
	public Command create(String input) {
		input=input.toLowerCase().replaceAll(CommandTypeConsts.OVERLAP, "").trim();
		return new OverlapCommand(input);
	}

	@Override
	public int index() {
		return 103;
	}

}
