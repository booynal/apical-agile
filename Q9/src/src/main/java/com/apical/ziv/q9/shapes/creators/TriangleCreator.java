/**
 * TriangleCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import java.awt.geom.Line2D;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.ClosedShape;
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
	protected ClosedShape createShape(String[] words) throws ShapeCreateException {
		double x1 = NumberUtil.parsedouble(words[1]);
		double y1 = NumberUtil.parsedouble(words[2]);
		double x2 = NumberUtil.parsedouble(words[3]);
		double y2 = NumberUtil.parsedouble(words[4]);
		double x3 = NumberUtil.parsedouble(words[5]);
		double y3 = NumberUtil.parsedouble(words[6]);
		if (x1 == x2 && y1 == y2) {
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_008, " point(" + words[1] + "," + words[2] + ")"));
		}
		if (x2 == x3 && y2 == y3) {
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_008, " point(" + words[3] + "," + words[4] + ")"));
		}
		if (x3 == x1 && y3 == y1) {
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_008, " point(" + words[5] + "," + words[6] + ")"));
		}
		if (Line2D.ptLineDistSq(x1, y1, x2, y2, x3, y3) == 0.0) {
			throw new ShapeCreateException(ErrorConsts.ERROR_009);
		}
		return new Triangle(x1, y1, x2, y2, x3, y3);
	}

	@Override
	public int index() {
		return 14;
	}

}
