/**
 * Point.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;

/**
 * 点
 *
 * @author ziv
 *
 */
public class Point extends Shape {

	private float x;
	private float y;

	public Point(float x, float y) {
		super(ShapeTypeConsts.POINT, true);
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("%s at (%.2f, ­%.2f)", getName(), x, y);
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

	@Override
	public boolean inside(Point point) {
		return false;
	}

	@Override
	public float calcArea() {
		return 0;
	}

}
