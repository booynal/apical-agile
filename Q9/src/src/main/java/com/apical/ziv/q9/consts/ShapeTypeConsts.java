/**
 * ShapeTypeConsts.java
 */
package com.apical.ziv.q9.consts;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.apical.ziv.q9.shapes.Circle;
import com.apical.ziv.q9.shapes.Donut;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.Rectangle;
import com.apical.ziv.q9.shapes.Square;
import com.apical.ziv.q9.shapes.Triangle;

/**
 * @author ziv
 *
 */
public class ShapeTypeConsts {

	public static final String CIRCLE = Circle.class.getSimpleName().toLowerCase();
	public static final String DONUT = Donut.class.getSimpleName().toLowerCase();
	public static final String RECTANGLE = Rectangle.class.getSimpleName().toLowerCase();
	public static final String SQUARE = Square.class.getSimpleName().toLowerCase();
	public static final String TRIANGLE = Triangle.class.getSimpleName().toLowerCase();
	public static final String POINT = Point.class.getSimpleName().toLowerCase();

	private static final List<String> allShapes = Arrays.asList(CIRCLE, DONUT, RECTANGLE, SQUARE, TRIANGLE, POINT);

	public static boolean isShape(String type) {
		return allShapes.contains(StringUtils.lowerCase(type));
	}

	public static boolean isCircle(String type) {
		return CIRCLE.equalsIgnoreCase(type);
	}

	public static boolean isDonut(String type) {
		return DONUT.equalsIgnoreCase(type);
	}

	public static boolean isRectangle(String type) {
		return RECTANGLE.equalsIgnoreCase(type);
	}

	public static boolean isSquare(String type) {
		return SQUARE.equalsIgnoreCase(type);
	}

	public static boolean isTriangle(String type) {
		return TRIANGLE.equalsIgnoreCase(type);
	}

	public static boolean isPoint(String type) {
		return POINT.equalsIgnoreCase(type);
	}

}
