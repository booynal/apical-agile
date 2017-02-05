/**
 * DonutCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Donut;
import com.apical.ziv.q9.shapes.Shape;
import com.apical.ziv.q9.shapes.usage.DonutUsager;
import com.apical.ziv.q9.shapes.validators.DonutValidator;
import com.apical.ziv.q9.utils.NumberUtil;

/**
 * @author ziv
 *
 */
@Component
public class DonutCreator extends AbstractShapeCreator {

	@Autowired
	private DonutValidator donutValidator;
	@Autowired
	private DonutUsager donutUsager;

	@Override
	protected String getType() {
		return ShapeTypeConsts.DONUT;
	}

	@Override
	protected Validatable getValidator() {
		return donutValidator;
	}

	@Override
	protected Usageable getUsager() {
		return donutUsager;
	}

	@Override
	protected Shape createShape(String[] words) throws ShapeCreateException {
		float x = NumberUtil.parseFloat(words[1]);
		float y = NumberUtil.parseFloat(words[2]);
		float radius = NumberUtil.parseFloat(words[3]);
		float radius2 = NumberUtil.parseFloat(words[4]);
		return new Donut(x, y, Math.min(radius, radius2), Math.max(radius, radius2));
	}

	@Override
	public int index() {
		return 11;
	}

}
