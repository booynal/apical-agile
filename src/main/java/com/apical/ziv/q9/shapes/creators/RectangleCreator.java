/**
 * RectangleCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Rectangle;
import com.apical.ziv.q9.shapes.Shape;
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
	protected Shape createShape(String[] words) throws ShapeCreateException {
		float x = NumberUtil.parseFloat(words[1]);
		float y = NumberUtil.parseFloat(words[2]);
		float sideLength = NumberUtil.parseFloat(words[3]);
		float side2Length = NumberUtil.parseFloat(words[4]);
		return new Rectangle(x, y, sideLength, side2Length);
	}

	@Override
	public int index() {
		return 12;
	}

}
