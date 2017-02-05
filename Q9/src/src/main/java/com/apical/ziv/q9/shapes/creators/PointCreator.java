/**
 * PointCreator.java
 */
package com.apical.ziv.q9.shapes.creators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.utils.NumberUtil;

/**
 * @author ziv
 *
 */
@Component
public class PointCreator extends AbstractShapeCreator {

	private static final String basicRegex = "\\(?-?[0-9\\.]+\\s*,\\s*-?[0-9\\.]+\\)?";
	private static final String findRegex = "\\(?\\s*(-?[0-9]+\\.?[0-9]*)\\s*,\\s*(-?[0-9]+\\.?[0-9]*)\\s*\\)?";
	private static final Pattern compile = Pattern.compile(findRegex);

	@Override
	public boolean isSupport(String input) {
		return StringUtils.trimToEmpty(input).matches(basicRegex);
	}

	@Override
	public Shape create(String input) throws ShapeCreateException {
		Matcher matcher = compile.matcher(input);
		if (matcher.find() && 2 == matcher.groupCount()) {
			float x = NumberUtil.parseFloat(matcher.group(1));
			float y = NumberUtil.parseFloat(matcher.group(2));
			return new Point(x, y);
		}
		return null;
	}

	@Override
	public int index() {
		return 20;
	}

}
