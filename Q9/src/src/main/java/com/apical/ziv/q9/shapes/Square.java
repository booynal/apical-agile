/**
 * Square.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;

/**
 * 正方形，从长方形继承而来
 *
 * @author ziv
 *
 */
public class Square extends Rectangle {

	public Square(double x, double y, double sideLength) {
		super(ShapeTypeConsts.SQUARE, x, y, sideLength, sideLength);
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with top left corner at (%.2f, %.2f) and side %.2f", getId(), getType(), getX(), getY(), getHeight());
	}
}
