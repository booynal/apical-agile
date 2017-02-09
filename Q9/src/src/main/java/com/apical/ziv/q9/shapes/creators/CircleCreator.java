/**
 * CircleCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Circle;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.usage.CircleUsager;
import com.apical.ziv.q9.shapes.validators.CircleValidator;
import com.apical.ziv.q9.utils.NumberUtil;

/**
 * @author ziv
 *
 */
@Component
public class CircleCreator extends AbstractShapeCreator {

	@Autowired
	CircleValidator circleValidator;
	@Autowired
	CircleUsager circleUsager;

	@Override
	protected String getType() {
		return ShapeTypeConsts.CIRCLE;
	}

	@Override
	protected Validatable getValidator() {
		return circleValidator;
	}

	@Override
	protected Usageable getUsager() {
		return circleUsager;
	}

	@Override
	protected ClosedShape createShape(String[] words) throws ShapeCreateException {
		double x = NumberUtil.parsedouble(words[1]);
		double y = NumberUtil.parsedouble(words[2]);
		double radius = NumberUtil.parsedouble(words[3]);
		if (radius <= 0) {
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_006, " radius:" + words[3]));
		}
		return new Circle(x, y, radius);
	}

	@Override
	public int index() {
		return 10;
	}

}
