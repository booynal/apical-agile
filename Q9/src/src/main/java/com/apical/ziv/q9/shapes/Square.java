/**
 * Square.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;

/**
 * 正方形，x和y表示左上角的顶点
 *
 * @author ziv
 *
 */
public class Square extends ClosedShape {

	private float x;
	private float y;
	private float sideLength;

	public Square(float x, float y, float sideLength) {
		super(ShapeTypeConsts.SQUARE);
		this.x = x;
		this.y = y;
		this.sideLength = sideLength;
	}

	protected Square(String name, float x, float y, float sideLength) {
		super(name);
		this.x = x;
		this.y = y;
		this.sideLength = sideLength;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with top left corner at (%.2f, %.2f) and side %.2f", getIdLong(), getType(), x, y, sideLength);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSideLength() {
		return sideLength;
	}

	public void setSideLength(float sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	public boolean inside(Point point) {
		float px = point.getX();
		float py = point.getY();
		float x1 = x, x2 = x + sideLength;
		float y1 = y, y2 = y - sideLength;
		boolean bx = px >= x1 && px <= x2;
		boolean by = py <= y1 && py >= y2;
		return bx && by;
	}

	@Override
	public float calcArea() {
		return (float) Math.pow(sideLength, 2);
	}

	@Override
	public Rectangle getExternalRectangle() {
		return new Rectangle(x, y, sideLength, sideLength);
	}

}
