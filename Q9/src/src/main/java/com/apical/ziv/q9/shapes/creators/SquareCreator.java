/**
 * SquareCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Square;
import com.apical.ziv.q9.shapes.usage.SquareUsager;
import com.apical.ziv.q9.shapes.validators.SquareValidator;
import com.apical.ziv.q9.utils.NumberUtil;

/**
 * @author ziv
 *
 */
@Component
public class SquareCreator extends AbstractShapeCreator {

	@Autowired
	private SquareValidator squareValidator;
	@Autowired
	private SquareUsager squareUsager;

	@Override
	protected String getType() {
		return ShapeTypeConsts.SQUARE;
	}

	@Override
	protected Validatable getValidator() {
		return squareValidator;
	}

	@Override
	protected Usageable getUsager() {
		return squareUsager;
	}

	@Override
	protected ClosedShape createShape(String[] words) throws ShapeCreateException {
		double x = NumberUtil.parsedouble(words[1]);
		double y = NumberUtil.parsedouble(words[2]);
		double sideLength = NumberUtil.parsedouble(words[3]);
		if(sideLength<=0)
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_006, " width:" +words[3]));
		
		return new Square(x, y, sideLength);
	}

	@Override
	public int index() {
		return 13;
	}

}
