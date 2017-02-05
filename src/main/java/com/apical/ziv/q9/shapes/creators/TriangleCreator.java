/**
 * TriangleCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Shape;
import com.apical.ziv.q9.shapes.Triangle;
import com.apical.ziv.q9.shapes.usage.TriangleUsager;
import com.apical.ziv.q9.shapes.validators.TriangleValidator;
import com.apical.ziv.q9.utils.NumberUtil;

/**
 * @author ziv
 *
 */
@Component
public class TriangleCreator extends AbstractShapeCreator {

	@Autowired
	private TriangleValidator triangleValidator;
	@Autowired
	private TriangleUsager triangleUsager;

	@Override
	protected String getType() {
		return ShapeTypeConsts.TRIANGLE;
	}

	@Override
	protected Validatable getValidator() {
		return triangleValidator;
	}

	@Override
	protected Usageable getUsager() {
		return triangleUsager;
	}

	@Override
	protected Shape createShape(String[] words) throws ShapeCreateException {
		float x1 = NumberUtil.parseFloat(words[1]);
		float y1 = NumberUtil.parseFloat(words[2]);
		float x2 = NumberUtil.parseFloat(words[3]);
		float y2 = NumberUtil.parseFloat(words[4]);
		float x3 = NumberUtil.parseFloat(words[5]);
		float y3 = NumberUtil.parseFloat(words[6]);
		return new Triangle(x1, y1, x2, y2, x3, y3);
	}

	@Override
	public int index() {
		return 14;
	}

}
