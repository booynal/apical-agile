/**
 * SquareUsager.java
 */
package com.apical.ziv.q9.shapes.usage;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.interfaces.Usageable;

/**
 * @author ziv
 *
 */
@Component
public class SquareUsager implements Usageable {

	@Override
	public String usage() {
		return String.format("Usage: '%s <x> <y> <sideLength>'", ShapeTypeConsts.SQUARE);
	}

}
