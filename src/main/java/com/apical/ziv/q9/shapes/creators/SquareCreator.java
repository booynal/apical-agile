/**
 * SquareCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Shape;
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
	protected Shape createShape(String[] words) throws ShapeCreateException {
		float x = NumberUtil.parseFloat(words[1]);
		float y = NumberUtil.parseFloat(words[2]);
		float sideLength = NumberUtil.parseFloat(words[3]);
		return new Square(x, y, sideLength);
	}

	@Override
	public int index() {
		return 13;
	}

}
