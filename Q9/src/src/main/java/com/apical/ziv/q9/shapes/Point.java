/**
 * Point.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.interfaces.Shape;

/**
 * 点
 *
 * @author ziv
 *
 */
public class Point implements Shape {

	private float x;
	private float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("%s at (%.2f, %.2f)", getType(), x, y);
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
	public String toId() {
		return null;
	}

	@Override
	public String getType() {
		return ShapeTypeConsts.POINT;
	}

}
