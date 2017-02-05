/**
 * PointUsager.java
 */
package com.apical.ziv.q9.shapes.usage;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.interfaces.Usageable;

/**
 * @author ziv
 *
 */
@Component
public class PointUsager implements Usageable {

	@Override
	public String usage() {
		return "Usage: '(<x>, <y>)'";
	}

}
