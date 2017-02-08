/**
 * RectangleCreator.java
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
import com.apical.ziv.q9.shapes.Rectangle;
import com.apical.ziv.q9.shapes.usage.RectangleUsager;
import com.apical.ziv.q9.shapes.validators.RectangleValidator;
import com.apical.ziv.q9.utils.NumberUtil;

/**
 * @author ziv
 *
 */
@Component
public class RectangleCreator extends AbstractShapeCreator {

	@Autowired
	private RectangleValidator rectangleValidator;
	@Autowired
	private RectangleUsager rectangleUsager;

	@Override
	protected String getType() {
		return ShapeTypeConsts.RECTANGLE;
	}

	@Override
	protected Validatable getValidator() {
		return rectangleValidator;
	}

	@Override
	protected Usageable getUsager() {
		return rectangleUsager;
	}

	@Override
	protected ClosedShape createShape(String[] words) throws ShapeCreateException {
		double x = NumberUtil.parsedouble(words[1]);
		double y = NumberUtil.parsedouble(words[2]);
		double sideLength = NumberUtil.parsedouble(words[3]);
		double side2Length = NumberUtil.parsedouble(words[4]);
		if(sideLength<=0)
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_006, " width:" +words[3]));
		if(side2Length<=0)
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_006, " width:" +words[4]));
			
		return new Rectangle(x, y, sideLength, side2Length);
	}

	@Override
	public int index() {
		return 12;
	}

}
