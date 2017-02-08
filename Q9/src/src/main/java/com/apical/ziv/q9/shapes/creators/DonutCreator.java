/**
 * DonutCreator.java
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
import com.apical.ziv.q9.shapes.Donut;
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
	protected ClosedShape createShape(String[] words) throws ShapeCreateException {
		double x = NumberUtil.parsedouble(words[1]);
		double y = NumberUtil.parsedouble(words[2]);
		double radius = NumberUtil.parsedouble(words[3]);
		double radius2 = NumberUtil.parsedouble(words[4]);
		if(radius<=0){
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_006, " innerradius:" +words[3]));	
		}
		
		if(radius2<=0){
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_006, " outerradius:" +words[4]));	
		}
		if(radius>=radius2){
			throw new ShapeCreateException(String.format("%s: %s", ErrorConsts.ERROR_007, " innerradius:" +words[3] + " outerradius:"+ words[4]));
		}
		
		return new Donut(x, y, Math.min(radius, radius2), Math.max(radius, radius2));
	}

	@Override
	public int index() {
		return 11;
	}

}
