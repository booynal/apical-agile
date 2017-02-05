/**
 * RectangleUsager.java
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
public class RectangleUsager implements Usageable {

	@Override
	public String usage() {
		return String.format("Usage: '%s <x> <y> <width> <height>'", ShapeTypeConsts.RECTANGLE);
	}

}
