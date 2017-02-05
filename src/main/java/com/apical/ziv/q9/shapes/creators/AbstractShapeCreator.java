/**
 * AbstractShapeCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import org.apache.commons.lang.StringUtils;

import com.apical.ziv.q9.exceptions.NotImplementedException;
import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.exceptions.ValidateException;
import com.apical.ziv.q9.interfaces.Creatable;
import com.apical.ziv.q9.interfaces.Usageable;
import com.apical.ziv.q9.interfaces.Validatable;
import com.apical.ziv.q9.shapes.Shape;

/**
 * @author ziv
 *
 */
public abstract class AbstractShapeCreator implements Creatable<Shape> {

	@Override
	public boolean isSupport(String input) {
		return StringUtils.equalsIgnoreCase(getType(), StringUtils.trimToEmpty(input).split("\\s+", 2)[0]);
	}

	protected String getType() {
		throw new NotImplementedException();
	}

	protected Usageable getUsager() {
		throw new NotImplementedException();
	}

	protected Validatable getValidator() {
		throw new NotImplementedException();
	}

	protected Shape createShape(String[] words) throws ShapeCreateException {
		throw new NotImplementedException();
	}

	@Override
	public Shape create(String input) throws ShapeCreateException {
		String[] words = input.split("\\s+");
		try {
			getValidator().validate(words);
			return createShape(words);
		} catch (ValidateException e) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%s: %s", e.getMessage(), input));
			sb.append(System.lineSeparator());
			sb.append(getUsager().usage());
			throw new ShapeCreateException(sb.toString(), e);
		}
	}

}
