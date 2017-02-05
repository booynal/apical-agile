/**
 * CircleCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Circle;
import com.apical.ziv.q9.shapes.Shape;
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
	protected Shape createShape(String[] words) throws ShapeCreateException {
		float x = NumberUtil.parseFloat(words[1]);
		float y = NumberUtil.parseFloat(words[2]);
		float radius = NumberUtil.parseFloat(words[3]);
		return new Circle(x, y, radius);
	}

	@Override
	public int index() {
		return 10;
	}

}
