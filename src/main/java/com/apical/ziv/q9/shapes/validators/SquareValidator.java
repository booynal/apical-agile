/**
 * SquareValidator.java
 */
package com.apical.ziv.q9.shapes.validators;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.ShapeConsts;
import com.apical.ziv.q9.exceptions.ValidateException;
import com.apical.ziv.q9.interfaces.Validatable;

/**
 * @author ziv
 *
 */
@Component
public class SquareValidator implements Validatable {

	@Override
	public void validate(String[] words) throws ValidateException {
		if (words.length < ShapeConsts.COMMAND_LINE_WORDS_COUNT_SQUARE) {
			throw new ValidateException(ErrorConsts.ERROR_001);
		} else if (words.length > ShapeConsts.COMMAND_LINE_WORDS_COUNT_SQUARE) {
			throw new ValidateException(ErrorConsts.ERROR_002);
		}
	}

}
