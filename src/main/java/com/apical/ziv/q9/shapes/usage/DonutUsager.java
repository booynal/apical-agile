/**
 * DonutUsager.java
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
public class DonutUsager implements Usageable {

	@Override
	public String usage() {
		return String.format("Usage: '%s <x> <y> <innerRadius> <outterRadius>'", ShapeTypeConsts.DONUT);
	}

}
