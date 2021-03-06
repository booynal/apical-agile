/**
 * NumberUtil.java
 */
package com.apical.ziv.q9.utils;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;

/**
 * @author ziv
 *
 */
public class NumberUtil {

	public static double parsedouble(String s) throws ShapeCreateException {
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException e) {
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_003, e.getMessage()));
		}
	}
}
