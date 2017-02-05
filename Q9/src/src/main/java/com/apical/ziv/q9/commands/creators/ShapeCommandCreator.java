/**
 * ShapeCommandCreator.java
 */
package com.apical.ziv.q9.commands.creators;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.commands.ShapeCommand;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.shapes.creators.PointCreator;

/**
 * @author ziv
 *
 */
@Component
public class ShapeCommandCreator extends AbstractCommandCreator {

	@Autowired
	private PointCreator pointCreator;

	@Override
	public boolean isSupport(String input) {
		return ShapeTypeConsts.isShape(StringUtils.trimToEmpty(input).split("\\s+", 2)[0]) || pointCreator.isSupport(input);
	}

	@Override
	public Command create(String input) {
		return new ShapeCommand(input);
	}

	@Override
	public int index() {
		return 102;
	}

}
