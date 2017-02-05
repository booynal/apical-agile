/**
 * Point.java
 */
package com.apical.ziv.q9.shapes;
import com.apical.ziv.q9.interfaces.*;
import com.apical.ziv.q9.consts.ShapeTypeConsts;

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
		return String.format("Point at (%.2f, %.2f)",  x, y);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return "Point";
	}

}
